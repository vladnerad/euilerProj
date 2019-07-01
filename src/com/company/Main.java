package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        long startTime = System.currentTimeMillis();
        System.out.println(new Task11().getAnswer());
        System.out.println("It takes: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
