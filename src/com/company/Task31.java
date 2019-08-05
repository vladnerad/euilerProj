package com.company;

public class Task31 implements EulerTask {

    private int[] arr = new int[201];
    private int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

    @Override
    public int getAnswer() {
        arr[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < arr.length; j++) {
                arr[j] += arr[j - coins[i]];
            }
        }
        return arr[arr.length - 1];
    }
/*
    // Рекурсивная функция разложения на слагаемые
    private int dec(int n, int k) {
        if (n >= 0 && k >= 0 && arr[n][k] > 0) return arr[n][k];
        if (n < 0) return 0;
        if (n <= 1 || k == 1) return 1;
        arr[n][k] = dec(n, k - 1) + dec(n - k, k);
        return arr[n][k];
    }
*/
}
