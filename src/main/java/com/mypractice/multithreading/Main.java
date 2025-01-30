/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

/**
 *
 * @author shsahu
 */
public class Main {
    public static void main(String args[]){
        Locks sbi = new Locks();
        Runnable task = new Runnable(){
            @Override
            public void run(){
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
        
    }
}
