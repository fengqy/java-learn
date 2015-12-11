package com.wallace.observer;




/**
 * @author fengqy
 * @date 2015/12/11.
 */
public interface Subject {
     void registerObserver(Observer o);
     void  removeObserver(Observer o);
     void notifyObservers();
}
