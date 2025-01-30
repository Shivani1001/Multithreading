/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypractice.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shsahu
 */
public class Locks {
    private int balance = 500;
    private final Lock lock = new ReentrantLock(); //implementation of lock
    
    public void withdraw(int amount){
        System.out.println( Thread.currentThread().getName() + " attempting to withdraw amount " + amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){       //waits for a perticular time to acquire lock
                     if(balance>= amount){
                        try{ 
                        System.out.println( Thread.currentThread().getName() + " Processing withdrawl ");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println( Thread.currentThread().getName() + " Completed withdrawal " + balance);
                 }catch(Exception e){
                            
                 }finally{
                         lock.unlock();
                         }
                }else{
                System.out.println( Thread.currentThread().getName() + " Insufficient balance " + balance);
                }
            }else{
                    System.out.println( Thread.currentThread().getName() + " Could not accuire lock");
                }
            }catch (InterruptedException ex) {
            Logger.getLogger(Locks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
      }
