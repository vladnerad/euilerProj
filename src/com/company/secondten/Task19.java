package com.company.secondten;

import com.company.EulerTask;

public class Task19 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;
        int year = 1900;
        int pointer = 1;
        int[] mounths = {3, -1, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
        for (int i = year; i < 2001; i++) {
            if (isLeap(i)) mounths[1] = 1;
            else mounths[1] = 0;

            for (int j = 0; j < mounths.length; j++) {
                pointer += mounths[j];

                if (i != year && pointer == 7) {
                    result++;
                }

                if (pointer > 7) {
                    pointer = pointer - 7;
                }
            }
        }
        return result;
    }

    private boolean isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else return year % 4 == 0;
    }
}
