/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shsahu
 */
public class SyncInc {
    private static int counter;
    public static void main(String args[]) throws InterruptedException{
        List<Thread> allThreads = new ArrayList<>();
        int numberOfCounts =  1000;
        
        for (int i =0; i < numberOfCounts; i++){
        var t = new Thread(SyncInc::increment);
        allThreads.add(t);
        t.start();
        }
        for(Thread threads : allThreads){
        threads.join();
        }
        System.out.println(counter);
    }
    
    public synchronized static void increment(){
    counter++;
    }
}
