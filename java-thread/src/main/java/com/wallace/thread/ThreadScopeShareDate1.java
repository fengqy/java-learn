package com.wallace.thread;

import java.util.Random;

/**
 * 为每个线程放独立的数据，每个线程，在每个模块中取到的数据一样
 * @author fengqy
 * @date 2015/12/2.
 */
public class ThreadScopeShareDate1 {
    private static int data=0;

    public static void main(String[] args) {
        for(int i=0;i<10000;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data: " + data);
                    new A().get();
                    new B().get();

                }
            }).start();
        }
    }

    static  class A{
        public void get(){
            System.out.println(" A from "+Thread.currentThread().getName()+" get data:"+data);
        }
    }

    static  class B{
        public void get(){
            System.out.println(" B from "+Thread.currentThread().getName()+" get data:"+data);

        }
    }
}
