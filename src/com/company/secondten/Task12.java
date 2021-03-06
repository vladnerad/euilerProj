package com.company.secondten;

import com.company.EulerTask;
import com.company.firstten.Task7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task12 implements EulerTask {

    private int result = 0;
    private boolean[] firstArr = new boolean[100];
    private HashMap<Integer, Integer> kanonRazlozh;
    long buff = 0;
    private int factorsQuantity = 500;

    @Override
    public int getAnswer() {
        sieveErFill(firstArr);
        for (int i = 1; i < Integer.MAX_VALUE / 2; i++) {
            //int idx = 0;
            //Карта с каноноческий разложение, ключ - числа, значение = степень
            kanonRazlozh = new HashMap<>();
            //Количество делителей
            int factorCount = 1;
            //Рассматриваемое треугольное число
            result += i;
            //Начинаем проверку с делителя 2
            int factor = 1;
            int zal = result;
            do {
                //Степень делителя
                int factPow = 0;
                factor++;
                while (zal % factor == 0) {
                    factPow++;
                    if (!kanonRazlozh.containsKey(factor)) kanonRazlozh.put(factor, 1);
                    else kanonRazlozh.replace(factor, factPow);
                    zal /= factor;
                    if (zal == 1) break;
                }
            } while (zal != 1);
//                factorCount++;
            for (int z = 0; z < firstArr.length; z++) {
                buff = Task7.getNumberFromIdx(z);
                if (firstArr[z] && buff > factor) {
                    break;
                }
                if (factor > result) break;
            }
            for (Map.Entry<Integer, Integer> entry : kanonRazlozh.entrySet()) {
                factorCount *= (entry.getValue() + 1);
            }
            if (factorCount > factorsQuantity) {
                return result;
            }
        }
        return -1;
    }

    public void sieveErFill(boolean[] firstArr) {
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
    }

/*    public int anotherVariant(){
        int n = 3;      //start with a prime
        int Dn = 2;     //number of divisors for any prime
        int cnt = 0;    //to insure the while loop is entered
        int n1, Dn1, i, exponent;

        sieveErFill(firstArr);
        while (cnt < factorsQuantity){
            n = n + 1;
            n1 = n;
            if (n1 % 2 == 0) n1 = n1 / 2;
            Dn1 = 1;
            for (int z = 0; z < firstArr.length; z++) {
                buff = Task7.getNumberFromIdx(z);
                if (buff * buff > n1){
                    Dn1 = 2 * Dn1;
                    break;
                }
                exponent = 1;
                while (n1 % buff == 0){
                    exponent++;
                    n1 = n1 / (int)buff;
                }
                if (exponent > 1) Dn1 *= exponent;
                if (n1 == 1) break;
            }
            cnt = Dn * Dn1;
            Dn = Dn1;
        }
        return n * (n-1) / 2;
    }*/
}