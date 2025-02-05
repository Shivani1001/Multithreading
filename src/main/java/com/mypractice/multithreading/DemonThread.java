/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author shsahu
 */
public class DemonThread {
    
    public static void main(String args[]) throws InterruptedException{
    var t1 = new Thread(() -> {
    while(true){
    try{
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("Deamon is working");
        }
    catch(InterruptedException e){
            }
        }
    });
    t1.setDaemon(true);
    t1.start();
    TimeUnit.SECONDS.sleep(5);
    System.out.println("Main thread done");
    }
    
}

