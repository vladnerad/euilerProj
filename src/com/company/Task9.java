package com.company;

public class Task9 implements EulerTask {

    @Override
    public int getAnswer() {
        int bPlusC;
        int c;
        int b;
        for (int a = 333; a > 0; a--) {
            bPlusC = 1000 - a;
            //эту формулу вывел на бумаге
            c = 500000 / bPlusC - a;
            b = 1000 - a - c;
            if (c > b && b > a && testAnw(a, b, c)) {
                return a * b * c;
            }
        }
        return -1;
    }

    private boolean testAnw(int a, int b, int c) {
        return c * c == a * a + b * b;
    }
}
