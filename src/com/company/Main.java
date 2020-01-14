package com.company;

import com.company.sixteen.Task53;

public class Main {

    public static void main(String[] args) {
        // write your code here
        long startTime = System.currentTimeMillis();
//        System.out.println(com.company.sixteen.Task51Kt.isPrime(20));
        System.out.println(new Task53().getAnswer());
        System.out.println("It takes: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
