package com.company.sixteen;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task53 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;

        for (int i = 23; i <= 100; i++) {
            long numerator = i;
            int mlnStartsFrom;
            for (int j = 1; j < i; j++) {
                numerator = numerator * (i - j);
                if (numerator >= 1000000) {
                    mlnStartsFrom = j + 1;
                    int z = (int) (numerator / 1000000);
                    int preFact = 1;
                    for (int k = 1; k <= mlnStartsFrom; k++) {
                        preFact = preFact * k;
                    }
                    if (preFact <= z) {
                        result += i - mlnStartsFrom * 2 + 1;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private int bruteForce() {
        int result = 0;
        for (int i = 22; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                if (getChoice(i, j).compareTo(BigInteger.valueOf(1000000)) > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private BigInteger getChoice(int n, int r) {
        return fact(n).divide(fact(r).multiply(fact(n - r)));
    }

    private BigInteger fact(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}