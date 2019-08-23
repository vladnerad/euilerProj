package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task44 implements EulerTask {

    private int[] fifthAnglers = new int[5000];

    @Override
    public int getAnswer() {

        fifthAnglers[0] = 1;
        fifthAnglers[1] = 5;

        for (int i = 2; i < fifthAnglers.length; i++){
            fifthAnglers[i] = 2 * fifthAnglers[i-1] - fifthAnglers[i-2] + 3;
        }

        int step = 1;
        while (step < fifthAnglers.length) {
            for (int i = 2; i < fifthAnglers.length - step; i++) {
                int diff = fifthAnglers[i + step] - fifthAnglers[i];
                int sum = fifthAnglers[i + step] + fifthAnglers[i];
                if (Arrays.stream(fifthAnglers).anyMatch(x -> x == diff) && Arrays.stream(fifthAnglers).anyMatch(x -> x == sum)) {
                    return diff;
                }
            }
            step++;
        }

        System.out.println("here");
        return 0;
    }
}
