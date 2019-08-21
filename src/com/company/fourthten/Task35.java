package com.company.fourthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task35 implements EulerTask {

    private boolean[] primes = new boolean[500000];

    @Override
    public int getAnswer() {
        Arrays.fill(primes, true);
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                // В индексе массива закодировано число
                long chislo = getNumberFromIdx(i);
                for (long j = chislo; (((chislo * j) - 1) / 2) - 1 < primes.length; j++) {
                    int idx = getIdxFromNumber(chislo, j);
                    // Четные числа не участвуют
                    if (chislo * j % 2 == 1) primes[idx] = false;
                }
            }
        }
        int result = 0;

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                int r = getNumberFromIdx(i);
                int z = 0;
                int c = getNumSwaps(getNumberFromIdx(r));
                while (z < c - 1) {
                    r = swapLast(r);
                    if (r % 2 == 0 || !primes[getIdx(r)]) break;
                    else z++;
                }
                if (z == c - 1) {
//                    System.out.println(getNumberFromIdx(i));
                    result++;
                }
            }
        }
        return ++result;
    }

    private static int getNumberFromIdx(int idx) {
        return (2 * (idx + 1) + 1);
    }

    private static int getIdxFromNumber(long prime, long factor) {
        return (int) ((((prime * factor) - 1) / 2) - 1);
    }

    private static int getIdx(long number) {
        if (number % 2 == 0) return -2;
        if (number == 3 || number == 1) return 0;
        return (int) (((number - 1) / 2) - 1);
    }

    private static int swapLast(int number) {
        if (number < 0) return -1;
        if (number < 10) return number;
        String[] val = String.valueOf(number).split("");
        String tmp = val[val.length - 1];
        for (int i = 0; i < val.length; i++) {
            String tmp2 = val[i];
            val[i] = tmp;
            tmp = tmp2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            sb.append(val[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    private static int getNumSwaps(int number) {
        return String.valueOf(number).split("").length;
    }
}
