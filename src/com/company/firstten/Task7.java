package com.company.firstten;

import java.util.Arrays;

public class Task7 {
    private int counter = 0;

    private boolean[] firstArr = new boolean[Integer.MAX_VALUE / 3000];

    // Немного модифицированное решето Эратосфена
    public long getAnswer() {
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
        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i]) counter++;
            if (counter == 10000) return 2 * (i + 1) + 1;
        }
        return -1;
    }

    public static long getNumberFromIdx (int idx){
        return (2 * (idx + 1) + 1);
    }

    public static int getIdxFromNumber (long prime, long factor){
        return (int) ((((prime * factor) - 1) / 2) - 1);
    }
}
