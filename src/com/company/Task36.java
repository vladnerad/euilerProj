package com.company;

public class Task36 /*implements EulerTask*/ {
    //Решение основано на генерации палиндромов для их пересчета
    //Генерируется палиндром по основанию 2, переводится в десятиричную систему и
    //проверяется на палиндром

    /*@Override*/
    public int getAnswer() {
        int result = 0;
//        for (int i = 1; i < 1000000; i=i+2) {
//            if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
//                result += i;
//            }
//        }
        int i = 1;
        int limit = 1000000;
        int z = makePalindromeBase2(i, true);
        while (z < limit) {
            if (isPalindrome(z,10) ) {
                result += z;
            }
            i++;
            z = makePalindromeBase2(i, true);
        }
        i = 1;
        z = makePalindromeBase2(i, false);
        while (z < limit) {
            if (isPalindrome(z,10) ) {
                result += z;
            }
            i++;
            z = makePalindromeBase2(i, false);
        }
        return result;
    }

//    public static boolean isPalindrome(String numberStr) {
//        StringBuilder sb = new StringBuilder();
//        if (numberStr.length() % 2 == 0) {
//            sb.append(numberStr.substring(numberStr.length() / 2));
//        } else {
//            sb.append(numberStr.substring(numberStr.length() / 2 + 1));
//        }
//        return numberStr.substring(0, numberStr.length() / 2).equals(sb.reverse().toString());
//    }

    public static boolean isPalindrome(long n, int base){
        long reversed = 0;
        long k = n;
        while (k > 0){
            reversed = reversed * 10 + k % base;
            k/=10;
        }
        return reversed == n;
    }

    private int makePalindromeBase2(int n, boolean oddLength){
        int res = n;
        if (oddLength) n = n>>1;
        while (n > 0){
            res = res << 1 | n & 1;
            n = n >> 1;
        }
        return res;
    }
}
