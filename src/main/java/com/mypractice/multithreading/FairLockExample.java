/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author shsahu
 */
public class FairLockExample {
    private final Lock lock = new ReentrantLock(true);
    
    public void accessresource(){
    lock.lock();
    try{
        System.out.println(Thread.currentThread().getName() + " Aquired lock");
        Thread.sleep(1000);
    } catch(InterruptedException e){
        Thread.currentThread().interrupt();
        } finally {
        System.out.println(Thread.currentThread().getName() + " Released lock");
        lock.unlock();
            }
    }
    
    public static void main(String args[]){
        
        FairLockExample fairlock = new FairLockExample();
        
        Runnable task = () -> {
            fairlock.accessresource();
        };
        
        Thread thread1 = new Thread(task, "Thread1");
        Thread thread2 = new Thread(task, "Thread2");
        Thread thread3 = new Thread(task, "Thread3");
        try{
        thread1.start();
        Thread.sleep(50);
        thread2.start();
        Thread.sleep(50);
        thread3.start();
        } catch (Exception e){
        
        }
        
    
    }
    
}
