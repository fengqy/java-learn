package com.wallace.thread;

/**
 * 主线程执行100次，子线程执行10次，如此循环50次
 *
 * @author fengqy
 * @date 2015/12/2.
 */
public class TraditionalThreadCommunication {
    private final static Business business = new Business();

    public static void main(String[] args) {
        new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.mian(i);
                }
            }
        }).start();
    }
}
