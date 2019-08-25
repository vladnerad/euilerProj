package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task44 implements EulerTask {

//    private int[] fifthAnglers = new int[5000];

//    @Override
//    public int getAnswer() {
//
//        fifthAnglers[0] = 1;
//        fifthAnglers[1] = 5;
//
//        for (int i = 2; i < fifthAnglers.length; i++){
//            fifthAnglers[i] = 2 * fifthAnglers[i-1] - fifthAnglers[i-2] + 3;
//        }
//
//        int step = 1;
//        while (step < fifthAnglers.length) {
//            for (int i = 2; i < fifthAnglers.length - step; i++) {
//                int diff = fifthAnglers[i + step] - fifthAnglers[i];
//                int sum = fifthAnglers[i + step] + fifthAnglers[i];
//                if (Arrays.stream(fifthAnglers).anyMatch(x -> x == diff) && Arrays.stream(fifthAnglers).anyMatch(x -> x == sum)) {
//                    return diff;
//                }
//            }
//            step++;
//        }
//
//        System.out.println("here");
//        return 0;
//    }

    @Override
    public int getAnswer() {
        int[] pentagonal = new int[5000];
//        pentagonal[0] = 1;
//        pentagonal[1] = 5;
//        for (int i = 2; i < pentagonal.length; i++){
//            pentagonal[i] = 2 * pentagonal[i-1] - pentagonal[i-2] + 3;
//        }

        for (int i = 1; i < pentagonal.length; i++) {
            pentagonal[i] = (i * 3 * i - i) / 2;
        }

        for (int i = 1; i < pentagonal.length; i++) {
            for (int j = i-1; j > 0; j--) {
                if (isPentagonal(pentagonal[i] + pentagonal[j]) &&
                        isPentagonal(pentagonal[i] - pentagonal[j])) {
                    System.out.println("Difference is " + (pentagonal[i] - pentagonal[j]));
                    return 1;
                }
            }
        }
        return 0;
    }

    private boolean isPentagonal(int number) {
        double penTest = (Math.sqrt(1 + 24 * number) + 1) / 6;
        return penTest == (int) penTest;
    }
}
