package com.wallace.thread;

/**
 * ���߳�ִ��100�Σ����߳�ִ��10�Σ����ѭ��50��
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
