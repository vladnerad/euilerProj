package com.company;

import java.util.Arrays;

public class Task37 implements EulerTask{

    private boolean[] primes = new boolean[500000];
    private int[] firstD    = {2, 3, 5, 7};
    private int[] midD      = {1, 3, 7, 9};
    private int[] lastD     = {3, 7};

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
        int counter = 0;

        for (int i = 0; i < firstD.length; i++){
            for (int j = 0; j < lastD.length; j++){
                if (firstD[i] != lastD[j]){
                    int num = firstD[i]*10 + lastD[j];
                    if (primes[getIdx(num)]){
                        counter++;
                        System.out.println(num);
                        result+=num;
                    }
                }
            }
        }

        for (int i = 0; i < firstD.length; i++){
            for (int j = 0; j < midD.length; j++) {
                if (firstD[i] != midD[j]) {
                    int zum = firstD[i] * 10 + midD[j];
                    if (primes[getIdx(zum)]) {
                        for (int z = 0; z < lastD.length; z++) {
                            if (midD[j] != lastD[z]) {
                                int num = firstD[i] * 100 + midD[j] * 10 + lastD[z];
                                int num2 = midD[j] * 10 + lastD[z];
                                if (primes[getIdx(num)] && primes[getIdx(num2)]) {
                                    counter++;
                                    System.out.println(num);
                                    result += num;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i < firstD.length; i++){
            for (int j = 2; j < midD.length; j++) {
                if (firstD[i] != midD[j]) {
                    int zum = firstD[i] * 10 + midD[j];
                    if (primes[getIdx(zum)]) {
                        for (int z = 3; z < midD.length; z++) {
                            if (midD[j] != midD[z]) {
                                int num = firstD[i] * 100 + midD[j] * 10 + midD[z];
                                int num2 = midD[j] * 10 + midD[z];
                                if (primes[getIdx(num)] && primes[getIdx(num2)]) {
                                   for (int y = 1; y < lastD.length; y++){
                                       if (midD[z] != lastD[y]){
                                           int num3 = firstD[i] * 1000 + midD[j] * 100 + midD[z]*10 + lastD[y];
                                           int num4 = midD[j] * 100 + midD[z]*10 + lastD[y];
                                           int num5 = midD[z]*10 + lastD[y];
                                           if (primes[getIdx(num3)] && primes[getIdx(num4)] && primes[getIdx(num5)]){
                                               counter++;
                                               System.out.println(num3);
                                               result += num3;
                                           }
                                       }
                                   }
                                }
                            }
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < primes.length; i++) {
//            if (primes[i]) {
//
//            }
//        }
        System.out.println(counter);
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
}
