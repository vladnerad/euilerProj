package com.company;

public class Task39 implements EulerTask {

    @Override
    public int getAnswer() {
        int counter;
        int maxCount = 0;
        int result = 120;
        for (int i = 500; i < 1000; i=i+2) {
            counter = 0;
            for (int j = 1; j < i / 3; j++) {
                if ((i * i - 2 * i * j) % (2 * i - 2 * j) == 0) {
                    counter++;
                }
            }
            if (counter > maxCount) {
                maxCount = counter;
                result = i;
            }
        }
        return result;
    }
}
