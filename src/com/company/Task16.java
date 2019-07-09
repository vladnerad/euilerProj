package com.company;

import java.math.BigInteger;

public class Task16 {

    public int getAnswer() {
        BigInteger bigInteger = new BigInteger("2");
        String answer = bigInteger.pow(1000).toString();
        int result = 0;
        for (char c : answer.toCharArray()) {
            result += Character.getNumericValue(c);
        }
        return result;
    }
}
