package com.thread;

/**
 * 通过实现 Runnable 接口来创建线程
 */
public class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            //Thread(Runnable threadOb,String threadName); 这个是常用的Thread构造方法
            //threadOb 是一个实现 Runnable 接口的类的实例, threadName 指定新线程的名字
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
