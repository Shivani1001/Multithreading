/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 * @author shsahu
 */
public class Demo {
    public static void main(String args[]) throws SecurityException, NoSuchMethodException{
    Class userClass = new User().getClass();
    System.out.println("Get class name" + userClass.getName());
    
    Field[] fields = userClass.getDeclaredFields();
    
    System.out.println("===Get fields name===");
    Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
    
    System.out.println("===Get fields type===");
    Arrays.stream(fields).forEach(field -> System.out.println(field.getGenericType()));
    
    System.out.println("===Does field have private modifier===");
    Arrays.stream(fields).forEach(field -> System.out.println(Modifier.isPrivate(field.getModifiers())));
    
    System.out.println("Get package name: " + userClass.getPackageName());
    System.out.println("Get super class name: " + userClass.getSuperclass());
    
    System.out.println("===== Get Interfaces =====");
    Class[] interfaces = userClass.getInterfaces();
    Arrays.stream(interfaces).forEach(i -> System.out.println(i.getName()));
		
    //userClass = Class.forName("com.itbulls.learnit.javacore.reflection.Demo$User");
		
    System.out.println("===== Get Constructors =====");
    Constructor<User>[] constructors = userClass.getDeclaredConstructors();
    System.out.println("Number of constructors: " + constructors.length);
    Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor.getName()));
		
    System.out.println("===== Get Private Constructor =====");
    Constructor<User> privateConstructor = userClass.getDeclaredConstructor(String.class);
    System.out.println(privateConstructor);
    
    
    
    
    
        }

    private static class User {
        private static int id= 0;
        
        private String firstName;
        private String lastName;
        private String email;
        
        static {
            id++;
                }
        public User() {
            this("default@user.com");
        }

        public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public User(String defaultemail) {
            this.email = defaultemail;
        }
        
//        public void printFullNameToConsole(){
//            System.out.println(firstName + " " + lastName);
//        }
//        
//        public double calculateTotalAmountSpendOnlineStore(){
//            return 11.25;
//        }

       
    }
}
