/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

/**
 *
 * @author shsahu
 */
public class YieldDemo {
    public static void main(String[] args){
    var t0 = new Thread(() ->{
    Thread.yield();
    System.out.println(Thread.currentThread().getName());
    });
    var t1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
    t0.start();
    t1.start();
    }
    
}
