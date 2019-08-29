package com.company.fifthten;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task48 /*implements EulerTask*/ {

//    @Override
    public String getAnswer() {
        BigInteger result = new BigInteger("1");
        for (int i = 2; i < 1001; i++){
            result = result.add(new BigInteger(String.valueOf(i)).pow(i));
        }
//        System.out.println(result);
        String res = result.toString();
        return res.substring(res.length() - 10);
    }
}
