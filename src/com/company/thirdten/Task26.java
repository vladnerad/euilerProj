package com.company.thirdten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task26 implements EulerTask {

    private boolean[] firstArr = new boolean[500];

    // Немного модифицированное решето Эратосфена
    @Override
    public int getAnswer() {
        Arrays.fill(firstArr, true);
        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i]) {
                // В индексе массива закодировано число
                long chislo = getNumberFromIdx(i);
                for (long j = chislo; (((chislo * j) - 1) / 2) - 1 < firstArr.length; j++) {
                    int idx = getIdxFromNumber(chislo, j);
                    // Четные числа не участвуют
                    if (chislo * j % 2 == 1) firstArr[idx] = false;
                }
            }
        }

        int max = 0;
        int result = 0;
        for (int i = 0; i < firstArr.length; i++) {
            int z = getNumberFromIdx(i);
            if (firstArr[i] && z > 10) {
                long ord = getOrd(z);
                if (ord > max) {
                    max = (int) ord;
                    result = z;
                }
            }
        }
        return result;
    }

    private static int getNumberFromIdx(int idx) {
        return (2 * (idx + 1) + 1);
    }

    private static int getIdxFromNumber(long prime, long factor) {
        return (int) ((((prime * factor) - 1) / 2) - 1);
    }

    private int getOrd(int n) {
        int counter = 1;
        int buff = 10 % n;
        while (counter < n) {
            if (buff == 1) return counter;
            buff = (buff * 10) % n;
            counter++;
        }
        return 0;
    }
}
