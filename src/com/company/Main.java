package com.company;

import com.company.fifthten.Task50;

public class Main {

    public static void main(String[] args) {
        // write your code here
        long startTime = System.currentTimeMillis();
        System.out.println(new Task50().getAnswer());
        System.out.println("It takes: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
