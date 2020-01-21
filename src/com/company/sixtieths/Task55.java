package com.company.sixtieths;

import com.company.EulerTask;

import java.math.BigInteger;

public class Task55 implements EulerTask {
    @Override
    public int getAnswer() {
        return bruteForce();
    }

    private int bruteForce() {
        int result = 0;
        for (int k = 1; k < 10000; k++) {
            int i = 0;
            BigInteger sum = new BigInteger(String.valueOf(k));
            while (i < 50) {
                try {
                    sum = sum.add(mirrorNumber(sum));
                } catch (NumberFormatException e) {
                    System.out.println(sum + " error, initial = " + k);
                }

                if (isPalindrome(sum)) break;
                i++;
            }
            if (i == 50) result++;
        }
        return result;
    }

//    public static boolean isPalindrome(long number){
//        String str = String.valueOf(number);
//        StringBuilder sb = new StringBuilder();
//        if (str.length()%2==0){
//            sb.append(str.substring(str.length()/2));
//        }
//        else {
//            sb.append(str.substring(str.length()/2+1));
//        }
//        return str.substring(0, str.length()/2).equals(sb.reverse().toString());
//    }
//
//    public static long mirrorNumber (long number){
//        StringBuilder sb = new StringBuilder(String.valueOf(number));
//        return Long.parseLong(sb.reverse().toString());
//    }

    public static BigInteger mirrorNumber(BigInteger number) {
        StringBuilder sb = new StringBuilder(String.valueOf(number));
        return new BigInteger(sb.reverse().toString());
    }

    public static boolean isPalindrome(BigInteger number) {
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        if (str.length() % 2 == 0) {
            sb.append(str.substring(str.length() / 2));
        } else {
            sb.append(str.substring(str.length() / 2 + 1));
        }
        return str.substring(0, str.length() / 2).equals(sb.reverse().toString());
    }
}
