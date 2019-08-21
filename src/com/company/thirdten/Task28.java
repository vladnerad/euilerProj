package com.company.thirdten;

import com.company.EulerTask;

public class Task28 implements EulerTask {

    private int side = 1001;

    @Override
    public int getAnswer() {
        int result = 0;
        for (long n = side; n > 1; n = n - 2) {
            result += 4 * n * n - 6 * n + 6;
        }
        return result + 1;
    }
}
