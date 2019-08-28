package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task47 implements EulerTask {

    private boolean[] primes = new boolean[500];

    @Override
    public int getAnswer() {
        fillPrimes();
        int inRow = 0;
        int buff = 0;
        for (int i = 646; ; i++) {
            if (getDivCount(i) == 4 && buff == 0) {
                buff = i;
            } else if (getDivCount(i) == 4 && buff == (i - 1)) {
                inRow++;
                buff = i;
            } else {
                buff = 0;
                inRow = 0;
            }
            if (inRow == 3) {
                return i - 3;
            }
        }
    }

    private int getNumberFromIdx(int idx) {
        return (2 * (idx + 1) + 1);
    }

    private int getIdxFromNumber(long prime, long factor) {
        return (int) ((((prime * factor) - 1) / 2) - 1);
    }

    private void fillPrimes() {
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
    }

    private int getDivCount(int number) {
        int count = 0;
        if (number % 2 == 0) {
            count++;
            while (number % 2 == 0) {
                number /= 2;
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if (number == 1) break;
            if (number % getNumberFromIdx(i) == 0) {
                count++;
                while (number % getNumberFromIdx(i) == 0) {
                    number /= getNumberFromIdx(i);
                }
            }
        }
        return count;
    }
}
