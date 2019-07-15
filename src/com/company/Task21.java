package com.company;

import java.util.HashSet;

public class Task21 implements EulerTask {
    private int border = 10000;

    @Override
    public int getAnswer() {
        int result;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= border; i++) {
            int divSum = findDivSum(i);
            if (divSum > i) {
                int zal = findDivSum(divSum);
                if (zal == i) {
                    hashSet.add(i);
                    hashSet.add(divSum);
                }
            }
        }
        result = hashSet.stream().mapToInt(integer -> integer).sum();
        return result;
    }

    private int findDivSum(int number) {
        int result = 0;
        if (number < 1) return 0;
        if (number == 1) return 1;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) result += i;
        }
        return result + 1;
    }
}
