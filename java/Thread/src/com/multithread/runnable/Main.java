/** 
 *@functon 多线程学习 
 */  
package com.multithread.runnable; 

class Data {
	private int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void incr(){
		this.counter++;
	}
}

class Thread2 implements Runnable{  
    private String name;  
    private Data dat;
  
    public Thread2(String name, Data dat) {  
        this.name=name;
        this.dat = dat;
    }  
  
    @Override  
    public void run() {  
          for (int i = 0; i < 5; i++) {
        	    dat.incr();
        	    System.out.println("counter in child "+ name+ " is "+dat.getCounter());
                System.out.println(name + "运行  :  " + i);  
                try {  
                    Thread.sleep((int) Math.random() * 10);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }
                
            }  
          
    }  
      
}  
public class Main {  
  
    public static void main(String[] args) throws InterruptedException {
    	Data dat = new Data();
        Thread th1= new Thread(new Thread2("C", dat));
        th1.start();
        Thread th2 = new Thread(new Thread2("D",dat));
        th2.start();
        //th1.join();
        //th2.join();
        System.out.println("counter in main is"+dat.getCounter());
    }  
  
}