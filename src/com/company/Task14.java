package com.company;

public class Task14 {

    private int border = 1000000;
    private int counter;
    private int maxCount = 0;

    public int getAnswer() {
        int answer = -1;
        for (int i = border - 1; i > border / 2; i--) {
            if (i % 2 != 0) {
                counter = 0;
                getCount(i);
                if (counter > maxCount) {
                    maxCount = counter;
                    answer = i;
                }
            }
        }
        return answer;
    }

    public int getCount(long nubmer) {
        if (nubmer == 1) return counter;
        else {
            if (nubmer % 2 == 0) {
                counter++;
                return getCount(nubmer / 2);
            } else {
                counter++;
                return getCount(3 * nubmer + 1);
            }
        }
    }
}
