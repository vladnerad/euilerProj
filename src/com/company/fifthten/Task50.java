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
        int z = 0;
        int dano = 1000;
        for (int i = dano; i > 0; i--) {
            int buff = 0;
            int count = 0;
                for (int j = 0; buff < i; j++){
                    if (primes[j]){
                        buff+=getNumberFromIdx(j);
                        count++;
                    }
                }
//            System.out.println(buff);
//            System.out.println(count);
            if (buff < dano && buff % 2 != 0 && (primes[getIdx(buff)] || primes[getIdx(buff+2)])){
                if (primes[getIdx(buff)]) z = buff;
                else if (primes[getIdx(buff+2)]) z = buff+2;
                else z = -1;
                break;
            }
        }
        System.out.println(z);
        return 0;
    }
}
