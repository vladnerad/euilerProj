package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task50 implements EulerTask {

    private boolean[] primes = new boolean[500000];

    private int getNumberFromIdx(int idx) {
        return (2 * (idx + 1) + 1);
    }

    private int getIdxFromNumber(long prime, long factor) {
        return (int) ((((prime * factor) - 1) / 2) - 1);
    }

    private static int getIdx(long number) {
        if (number % 2 == 0) return -2;
        if (number == 3 || number == 1) return 0;
        return (int) (((number - 1) / 2) - 1);
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

    @Override
    public int getAnswer() {
        fillPrimes();
        int result = 0;
        int count1;
        int maxCount = 0;
        int dano = 1000000;
        for (int i = dano; i > 0; i--) {
            count1 = 1;
            if (i % 2 != 0 && (primes[getIdx(i)])) {
                int buff = 2;
                int count2 = 0;
                for (int j = 0; buff < i; j++) {
                    if (primes[j]) {
                        buff += getNumberFromIdx(j);
                        count1++;
                    }
                }
                while (buff > i) {
                    count1--;
                    if (count2 == 0) {
                        buff -= 2;
                    } else {
                        buff -= getNumberFromIdx(count2 - 1);
                    }
                    count2++;
                }
                if (buff == i && count1 > maxCount) {
                    maxCount = count1;
                    result = buff;
                }
            }
        }
        return result;
    }
}
