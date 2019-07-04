package com.company;

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
}
