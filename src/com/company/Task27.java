package com.company;

import java.util.Arrays;

public class Task27 implements EulerTask{

    private boolean[] firstArr = new boolean[10000];

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

        int maxCount = 0;
        int result = 0;
        for (int i = -999; i < 1000; i = i + 2) {
            for (int j = -999; j < 1000; j = j + 2) {
                int count = 0;
                for (int n = 0; n < 80; n++) {
                    int z = n * n + j * n + i;
                    if (z % 2 != 0) {
                        if (firstArr[getIdx(Math.abs(z))]) {
                            count++;
                        } else {
                            if (count > maxCount) {
                                maxCount = count;
                                result = i * j;
                            }
                            break;
                        }
                    }
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

    private static int getIdx(long number) {
        if (number % 2 == 0) return -2;
        if (number == 3 || number == 1) return 0;
        return (int) (((number - 1) / 2) - 1);
    }
}
