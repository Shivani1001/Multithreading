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
public class ReentrantEx {
    private final Lock lock = new ReentrantLock();


    public void outerMethod(){
    lock.lock();
    try {
    System.out.println("OUTER");
    innerMethod();
        } finally{
            lock.unlock();
        }
    
    }

    public void innerMethod(){
    lock.lock();
    try {
    System.out.println("INNER");
        } finally{
            lock.unlock();
        }
    }
    
    public static void main(String args[]){
    ReentrantEx example = new ReentrantEx();
    example.outerMethod();
    }
}


