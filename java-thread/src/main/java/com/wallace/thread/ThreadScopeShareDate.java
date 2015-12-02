package com.wallace.thread;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 为每个线程放独立的数据，每个线程，在每个模块中取到的数据一样，线程范围内共享数据
 * @author fengqy
 * @date 2015/12/2.
 */
public class ThreadScopeShareDate {
    private static int data=0;
    //使用HashMap线程不安全，取出的结果会不对
    private static Map<Thread,Integer> threadData=new ConcurrentHashMap<Thread, Integer>();
    public static void main(String[] args) {
        for(int i=0;i<10000;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data: " + data);
                    threadData.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();

                }
            }).start();
        }
    }

    static  class A{
        public void get(){
            int  data = threadData.get(Thread.currentThread());
            System.out.println(" A from "+Thread.currentThread().getName()+" get data:"+data);
        }
    }

    static  class B{
        public void get(){
            int  data = threadData.get(Thread.currentThread());
            System.out.println(" B from "+Thread.currentThread().getName()+" get data:"+data);

        }
    }
}
