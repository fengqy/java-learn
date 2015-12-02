package com.wallace.thread;

/**
 * @author fengqy
 * @date 2015/12/2.
 */
public class Business {

    private boolean shouldDone = true;

    //主线程执行100次
    public synchronized void mian(int j) {
        while (shouldDone) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("main thread sequece of " + i + " Loop of " + j);
        }
        shouldDone = true;
        this.notifyAll();
    }

    //子线程执行10次
    public synchronized void sub(int j) {
        while (!shouldDone) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("sub thread sequece of " + i + " Loop of " + j);

        }
        shouldDone = false;
        this.notifyAll();
    }
}
