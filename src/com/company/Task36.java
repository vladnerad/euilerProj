package com.company;

public class Task36 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
                result += i;
            }
        }
        return result;
    }

    public static boolean isPalindrome(String numberStr) {
        StringBuilder sb = new StringBuilder();
        if (numberStr.length() % 2 == 0) {
            sb.append(numberStr.substring(numberStr.length() / 2));
        } else {
            sb.append(numberStr.substring(numberStr.length() / 2 + 1));
        }
        return numberStr.substring(0, numberStr.length() / 2).equals(sb.reverse().toString());
    }
}
