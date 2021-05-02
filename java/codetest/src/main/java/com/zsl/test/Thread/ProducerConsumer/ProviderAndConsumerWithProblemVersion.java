package com.zsl.test.Thread.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProviderAndConsumerWithProblemVersion {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                System.out.println("#############Producer start run "+ this.getName());
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        queue.notify();
                        System.out.println("Current queue full:" + this.getName()+queue.size()+" priority:"+this.getPriority());
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("Producer produce a task，current task queue size:" + queue.size()+","+this.getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                System.out.println("##############consumer start run"+this.getName()+" priority:"+this.getPriority());
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("Current queue is empty."+this.getName());
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("Consumer consume a task，current queue size:" + queue.size()+":"+this.getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ProviderAndConsumerWithProblemVersion pc = new ProviderAndConsumerWithProblemVersion();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();

        Producer producerr = pc.new Producer();
        producerr.start();
        Producer producerrr = pc.new Producer();
        producerrr.start();
        /*
        Producer producer2 = pc.new Producer();
        Consumer consumer2 = pc.new Consumer();
        producer2.start();
        consumer2.start();
        consumer2.sleep(10000);

        Producer producer3 = pc.new Producer();
        Consumer consumer3 = pc.new Consumer();
        producer3.start();
        consumer3.start();
        consumer3.sleep(10000);
        */
    }
}