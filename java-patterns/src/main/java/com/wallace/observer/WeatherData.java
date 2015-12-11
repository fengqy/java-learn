package com.wallace.observer;

import java.util.ArrayList;

/**
 * @author fengqy
 * @date 2015/12/11.
 */
public class WeatherData implements  Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers=new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObservers() {
      for(int i=0;i<observers.size();i++){
          Observer observer = observers.get(i);
          observer.update(temperature,humidity,pressure);
      }
    }

   //当从气象站得到更新观测值时，我们通知观察者
    public void  measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
       this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }








}
