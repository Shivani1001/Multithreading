/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author shsahu
 */
public class ReadWriteCounter {
    
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    
    public void increment(){
        writeLock.lock();
        try{
        count++;
        } finally {
        writeLock.unlock();
        }
    }
    
    public int getCount(){
        readLock.lock();
        try{
        return count;
        } finally {
        readLock.unlock();
        }
    }
    
    public static void main(String args[]) throws InterruptedException{
    ReadWriteCounter counter = new ReadWriteCounter();
    Runnable readtask = new Runnable(){
        @Override
        public void run(){
            for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + " Thread " + counter.getCount());
                }
            }
        };
    
    Runnable writetask = new Runnable(){
        @Override
        public void run(){
            for(int i=0; i<10; i++){
            counter.increment();
            System.out.println(Thread.currentThread().getName() + " increament ");
                }
            }
        };
    
    Thread writerThread = new Thread(writetask);
    Thread readerThread1 = new Thread(readtask);
    Thread readerThread2 = new Thread(readtask);
    
    writerThread.start();
    readerThread1.start();
    readerThread2.start();
    
    writerThread.join();
    readerThread1.join();
    readerThread2.join();
    
    System.out.println(" Final count " + counter.getCount());
    
    
    }
}
