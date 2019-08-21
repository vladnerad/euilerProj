package com.company.fourthten;

import com.company.EulerTask;

public class Task34 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;

        int[] factorials = new int[10];
        for (int i = 0; i < factorials.length; i++) {
            factorials[i] = fact(i);
        }

        for (int i = 100; i < 100000; i++) {
            String[] dig = String.valueOf(i).split("");
            int factSum = 0;
            for (String s : dig) {
                factSum += factorials[Integer.parseInt(s)];
            }
            if (i == factSum) {
//                System.out.println(i);
                result += i;
            }
        }
        return result;
    }

    private int fact(int x) {
        if (x > 10) return -1;
        int result = 1;
        while (x > 0) {
            result *= x;
            x--;
        }
        return result;
    }
}
