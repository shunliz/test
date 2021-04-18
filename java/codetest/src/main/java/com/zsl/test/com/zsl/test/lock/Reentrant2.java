package com.zsl.test.com.zsl.test.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Lock{
    private boolean isLocked = false;

    public synchronized void lock()
            throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}

class SpinLock{
    boolean isLocked = false;
    Thread  lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock()
            throws InterruptedException{
        Thread callingThread =
                Thread.currentThread();
        while(isLocked && lockedBy != callingThread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }

    public synchronized void unlock(){
        if(Thread.currentThread() ==
                this.lockedBy){
            lockedCount--;

            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

}

public class Reentrant2{
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    //Lock lock = new Lock();
    SpinLock lock = new SpinLock();

    public void outer() throws InterruptedException {
        lock.lock();
        System.out.println("in outter"+Thread.currentThread().getName());
        inner();
        lock.unlock();
    }

    public synchronized void inner() throws InterruptedException {
        lock.lock();
        System.out.println("in inner:"+Thread.currentThread().getName());
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        //test1();

        test2();
    }

    private static void test2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                Reentrant2 test = new Reentrant2();
                try {
                    test.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Reentrant2 test2 = new Reentrant2();
                try {
                    test2.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread2");

        executor.execute(t0);
        executor.execute(t);
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    private static void test1() {
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                Reentrant2 test = new Reentrant2();
                try {
                    test.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1");
        t0.start();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Reentrant2 test2 = new Reentrant2();
                try {
                    test2.inner();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread2");
        t.start();
    }
}