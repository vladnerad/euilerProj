package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Task12 implements EulerTask{

    private int result = 0;
    private boolean[] firstArr = new boolean[Integer.MAX_VALUE / 5000];
    private HashMap<Integer, Integer> kanonRazlozh;

    @Override
    public int getAnswer() {
//        for (int i = 1; i<Integer.MAX_VALUE;i++){
//            int factorCount = 0;
//            result+=i;
//            for (int j = 1; j <= result; j++){
//                if (result%j==0){
//                    factorCount++;
//                }
//                if (factorCount>500) return i;
//            }
//        }

        sieveErFill(firstArr);
        for (int i = 1; i<Integer.MAX_VALUE;i++) {
            int idx = 0;
            kanonRazlozh = new HashMap<>();
            int factorCount = 0;
            result += i;
            int factor = 2;
            int factQuan = 0;
            for (int j = 2; j<Integer.MAX_VALUE; ) {
                while (result % factor == 0) {
                    factQuan++;
                    if (!kanonRazlozh.replace(factor, factQuan - 1, factQuan)) kanonRazlozh.put(factor, 1);
                }
                if (j)
            }
        }


        return -1;
    }

    public void sieveErFill (boolean[] firstArr){
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
