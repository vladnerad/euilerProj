package com.company;

import java.util.stream.Stream;

public class Task30 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;
        for (int i = 1222; i <= 354294; i++) {
            int[] digits = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            int summ = 0;
            for (Integer digit : digits) {
                summ += (digit * digit * digit * digit * digit);
            }
            if (summ == i) {
                result += i;
            }
        }
        return result;
    }
}
