package com.company;

import java.util.Arrays;

public class Task41 implements EulerTask {

    private boolean[] primes = new boolean[5000000];
    private int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

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

        for (long i = 987654321; i > 5000; i--){
            if (i % 2 != 0 && i % 5 != 0 && i % 9 != 0){
                if (isPanNumber(i)){
                    if (primes[getIdx(i)]){
                        System.out.println(i);
                        break;
                    }
                }
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

    private static int getIdx(long number) {
        if (number % 2 == 0) return -2;
        if (number == 3 || number == 1) return 0;
        return (int) (((number - 1) / 2) - 1);
    }

    private boolean isPanNumber (long number){
        String numStr = String.valueOf(number);
        int len = numStr.length();
        boolean result = true;
        for (int i = 0; i < len; i++){
            if (!numStr.contains(String.valueOf(digits[i]))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
