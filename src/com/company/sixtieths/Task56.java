package com.company.sixtieths;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task56 implements EulerTask {
    @Override
    public int getAnswer() {
        int result = 0;
//        System.out.println(getDigitsSum(new BigInteger("1000000000000000001")));
        for(int i = 50; i < 100; i++){
            for(int j = 50; j < 100; j++){
                BigInteger bigInteger = BigInteger.valueOf(i).pow(j);
                int x = getDigitsSum(bigInteger);
                if (x > result){
                    result = x;
                }
            }
        }
        return result;
    }

    private int getDigitsSum(BigInteger number){
        int result = 0;
        char[] digits = number.toString().toCharArray();
        for (char d: digits){
            result+=Character.getNumericValue(d);
        }
        return result;
    }
}
