package com.company;

import java.util.Arrays;

public class Task31 implements EulerTask {

    private int[][] arr = new int[201][201];

    public Task31() {
        for (int[] ints : arr) {
            Arrays.fill(ints, -1);
        }
    }

    @Override
    public int getAnswer() {
        return dec(1, 1);
    }

    // Рекурсивная фенкция разложения на слагаемые
    private int dec(int n, int k) {
        if (n >= 0 && k >= 0 && arr[n][k] > 0) return arr[n][k];
        if (n < 0) return 0;
        if (n <= 1 || k == 1) return 1;
        arr[n][k] = dec(n, k - 1) + dec(n - k, k);
        return arr[n][k];
    }
}
