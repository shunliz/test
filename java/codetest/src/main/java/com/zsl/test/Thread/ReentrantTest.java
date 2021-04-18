package com.zsl.test.Thread;

public class ReentrantTest{
    public synchronized void outer() throws InterruptedException {
        System.out.println("in outter");
        Thread.sleep(5000);
        inner();
    }

    public synchronized void inner() throws InterruptedException {
        Thread.sleep(5000);
       System.out.println("in innner");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                ReentrantTest test = new ReentrantTest();
                try {
                    test.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t0.start();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ReentrantTest test2 = new ReentrantTest();
                try {
                    test2.inner();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
