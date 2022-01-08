package com.company.sixtieths;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task57 implements EulerTask {
    @Override
    public int getAnswer() {
        int result = 0;
        int counter = 1;
        BigInteger ch = new BigInteger("2");
        BigInteger zn = new BigInteger("5");

        while (counter < 1000){
            BigInteger tmp = ch;
            ch = zn;
            zn = zn.multiply(new BigInteger("2")).add(tmp);
            if (String.valueOf(ch.add(zn)).length() - String.valueOf(zn).length() > 0){
                result++;
            }
            counter++;
        }
        return result;
    }
}
