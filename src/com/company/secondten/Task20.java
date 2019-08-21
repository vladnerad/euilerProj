package com.company.secondten;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task20 implements EulerTask {

    @Override
    public int getAnswer() {
        BigInteger bigInteger = new BigInteger("100");
        for (int i = 99; i > 1; i--) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        String factorial = bigInteger.toString();
        int result = 0;
        for (String x : factorial.split("")) {
            result += Integer.parseInt(x);
        }
        return result;
    }
}