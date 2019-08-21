package com.company.thirdten;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task25 implements EulerTask {

    private BigInteger current = new BigInteger("3");
    private BigInteger previous = new BigInteger("2");
    private int count = 4;

    //Brute force(
    @Override
    public int getAnswer() {
        while (current.toString().length() != 1000) {
            BigInteger tmp = previous;
            previous = current;
            current = previous.add(tmp);
            count++;
        }
        return count;
    }

    //Solution from comments
    //Binet's Fibonacci Number Formula

    //golden ratio
    static final double g = (Math.sqrt(5) + 1) / 2;

    public int getAnswer2() {
        int i = 1;
        double temp = 1;
        while (temp < 999) {
            i++;
            temp = i * Math.log10(g) + Math.log10(1 / Math.sqrt(5));
        }
        return i;
    }
}
