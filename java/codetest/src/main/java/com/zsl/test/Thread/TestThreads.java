package com.zsl.test.Thread;


import java.util.concurrent.*;

class Semaphore {

    private boolean signal = false;

    public synchronized void take() {

        this.signal = true;

        this.notify();

    }

    public synchronized void release() throws InterruptedException{

        while(!this.signal) wait();

        this.signal = false;

    }

}

class Worker implements Runnable{

    private Thread beforeThread;
    public Worker(Thread t){
        this.beforeThread = t;
    }
    @Override
    public void run() {
        if (beforeThread != null) {
            try {
                beforeThread.join();

                System.out.println("thread start:" + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();

            }

        } else {
            System.out.println("thread start:" + Thread.currentThread().getName());

        }
    }
}

class Worker2 implements Runnable{
    @Override
    public void run() {
        System.out.println("thread start : " + Thread.currentThread().getName());
    }
}


class Work implements Runnable {
    CountDownLatch c1;

    CountDownLatch c2;

    Work(CountDownLatch c1, CountDownLatch c2) {
        super();

        this.c1 = c1;

        this.c2 = c2;

    }

    public void run() {
        try {
            c1.await();//前一线程为0才可以执行

            System.out.println("thread start:" + Thread.currentThread().getName());

            c2.countDown();//本线程计数器减少

        } catch (InterruptedException e) {
        }

    }

}


public class TestThreads {



    public static void main(String[] args) throws InterruptedException {
/*
        java.util.concurrent.Semaphore ss = new java.util.concurrent.Semaphore(0);
        System.out.println(ss.availablePermits());
        ss.acquire();
        System.out.println(ss.availablePermits());
        System.out.println("come here???");
        */
        //test2();
        for(int i=0;i<10;i++){
            test2();
            //test3();
            //test4();
            //test5();
            //test6();
            //test7();
            //test8();
        }

    }

    public static void test8() throws InterruptedException {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("开发人员开发新需求功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("测试人员测试新功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();

        thread3.join();
        System.out.println("#################################");
    }

    public static void test7(){
        //blockingQueue保证顺序
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        Thread t1 = new Thread(new Worker2(),"th111111111");
        Thread t2 = new Thread(new Worker2(),"th22222");
        Thread t3 = new Thread(new Worker2(),"th3333333333");
        blockingQueue.add(t1);
        blockingQueue.add(t2);
        blockingQueue.add(t3);
        for (int i = 0; i < 3; i++) {
            Thread t = null;
            try {
                t = (Thread) blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
//检测线程是否还活着
            while (t.isAlive()) ;
        }
    }

    public static void test6(){
        Thread t1 = new Thread(new Worker2(),"t1111");
        Thread t2 = new Thread(new Worker2(),"t2222");
        Thread t3 = new Thread(new Worker2(),"t3333");

        CompletableFuture.runAsync(()-> t1.start())
                .thenRun(()->t2.start())
                .thenRun(()->t3.start());
    }

    private static void test5(){
        {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread start : " + Thread.currentThread().getName() + " run one");
                }
            },"thread11111111111");

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread start : " + Thread.currentThread().getName() + " run two");
                }
            },"thread2222222222");

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread start : " + Thread.currentThread().getName() + " run three");
                }
            }, "thread333333");

            ExecutorService executor = Executors.newSingleThreadExecutor();
            // 将线程依次加入到线程池中
            executor.submit(t1);
            executor.submit(t2);
            executor.submit(t3);
            // 及时将线程池关闭
            executor.shutdown();
        }

    }

    private static void test4() throws InterruptedException {
        CountDownLatch c0 = new CountDownLatch(0); //计数器为0
        CountDownLatch c1 = new CountDownLatch(1); //计数器为1
        CountDownLatch c2 = new CountDownLatch(1); //计数器为1
//c0为0，t1可以执行。t1的计数器减1
        Thread t1 = new Thread(new Work(c0, c1), "thread1111111");
//t1的计数器为0时，t2才能执行。t2的计数器c2减1
        Thread t2 = new Thread(new Work(c1, c2),"thread2222222");
//t2的计数器c2为0时，t3才能执行
        Thread t3 = new Thread(new Work(c2, c2),"thread3333333");
        t1.start();
        t2.start();
        t3.start();

        t3.join();
        System.out.println("##############################");
    }

    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(new Worker(null),"thread111111");
        Thread t2 = new Thread(new Worker(t1),"thread22222222222");
        Thread t3 = new Thread(new Worker(t2),"thread333333333333");
        t1.start();
        t2.start();
        t3.start();
        t3.join();
        System.out.println("##############################");
    }

    private static void test2() throws InterruptedException {
        java.util.concurrent.Semaphore s1 = new java.util.concurrent.Semaphore(1);
        java.util.concurrent.Semaphore s2 = new java.util.concurrent.Semaphore(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("this is thread1");
                    Thread.sleep(200);
                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                while(s1.availablePermits()<2){

                }
                try {
                    s1.acquire();
                    System.out.println("this is thread2");
                    Thread.sleep(200);
                    s2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(s2.availablePermits()<2){

                }
                try {
                    s2.acquire();
                    t2.join();
                    s2.release();
                    System.out.println("this is thread3");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t3.join();
        System.out.println("#######################################");
    }

    private static void test1() {
        Semaphore s1 = new Semaphore();
        Semaphore s2 = new Semaphore();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is thread1");
                try {
                    Thread.sleep(2000);
                    s1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("this is thread2");
                try {
                    Thread.sleep(2000);
                    s2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("this is thread3");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
