package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        long startTime = System.currentTimeMillis();
        //System.out.println(new Task3(600851475143L).getAnswer());
        System.out.println(new Task4().getAnswer());
        System.out.println("It takes: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
