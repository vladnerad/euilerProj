package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task46 implements EulerTask {

    private boolean[] primes = new boolean[5000];
    private int[] leftovers = new int[5000];

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

        for (int i = 0; i < leftovers.length; i++) {
            leftovers[i] = 2 * (i + 1) * (i + 1);
        }

        for (int i = 0; i < primes.length; i++) {
            if (!primes[i] && i > 10) {
                boolean isDecomp = false;
                for (int j = i - 1; j > 0; j--) {
                    if (primes[j]) {
                        if (Arrays.binarySearch(leftovers, (getNumberFromIdx(i) - getNumberFromIdx(j))) >= 0) {
                            isDecomp = true;
                            break;
                        }
                    }
                }
                if (!isDecomp) return getNumberFromIdx(i);
            }
        }
        return 0;
    }

    private static int getNumberFromIdx(int idx) {
        return (2 * (idx + 1) + 1);
    }

    private static int getIdxFromNumber(long prime, long factor) {
        return (int) ((((prime * factor) - 1) / 2) - 1);
    }
}
