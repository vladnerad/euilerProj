package com.company;

import java.util.Arrays;

public class Task10 {

    private boolean[] firstArr = new boolean[Integer.MAX_VALUE / 2000];
    private long result = 0;

    // Немного модифицированное решето Эратосфена
    public long getAnswer() {
        Arrays.fill(firstArr, true);
        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i]) {
                // В индексе массива закодировано число
                long chislo = Task7.getNumberFromIdx(i);
                for (long j = chislo; (((chislo * j) - 1) / 2) - 1 < firstArr.length; j++) {
                    int idx = Task7.getIdxFromNumber(chislo, j);
                    // Четные числа не участвуют
                    if (chislo * j % 2 == 1) firstArr[idx] = false;
                }
            }
        }
        for (int i = 0; i < firstArr.length; i++) {
            long buf = Task7.getNumberFromIdx(i);
            if (firstArr[i] && buf < 2000000) result += buf;
        }
        return result + 2; //т.к. в массиве счет начинается с трех
    }
}
