package com.multithread.learning;  
/** 
 *@functon 多线程学习 
 */  
class Thread1 extends Thread{  
    private String name;  
    public Thread1(String name) {  
       this.name=name;  
    }  
    public void run() {  
        for (int i = 0; i < 500; i++) {  
            System.out.println(name + "运行  :  " + i);  
            try {
            	int sl =(int) (Math.random() * 1000f);
            	System.out.println("sleep for "+sl+"ms.............");
                sleep(sl);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
         
    }  
}

public class Main {  
	  
    public static void main(String[] args) {  
        Thread1 mTh1=new Thread1("A");  
        Thread1 mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
  
    }  
  
}