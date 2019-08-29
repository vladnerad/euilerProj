package com.company.fifthten;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task48 /*implements EulerTask*/ {

    //    @Override
    public String getAnswer() {
        BigInteger result = new BigInteger("1");
        for (int i = 2; i < 1001; i++) {
            result = result.add(new BigInteger(String.valueOf(i)).pow(i));
        }
//        System.out.println(result);
        String res = result.toString();
        return res.substring(res.length() - 10);
    }

    public long getAnswer2() {
        long modulo = 10000000000L;
        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            long temp = i;
            for (int j = 1; j < i; j++) {
                temp *= i;
                if (temp >= Long.MAX_VALUE / 1000){
                    temp %= modulo;
                }
            }
            result += temp;
            result %= modulo;
        }
        return result;
    }

    public BigInteger getAnswer3() {
        BigInteger result = new BigInteger("0");
        BigInteger mod = new BigInteger("10").pow(10);

        for (int i = 1; i <= 1000; i++){
            BigInteger tmp = new BigInteger(String.valueOf(i));
            result = result.add(tmp.modPow(tmp, mod)).remainder(mod);
        }
        return result;
    }
}
