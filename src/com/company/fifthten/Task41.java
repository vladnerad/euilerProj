package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task41 implements EulerTask {

    //    private boolean[] primes = new boolean[493827115];
    private int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1};

//    @Override
//    public int getAnswer() {
//        Arrays.fill(primes, true);
//        for (int i = 0; i < primes.length; i++) {
//            if (primes[i]) {
//                // В индексе массива закодировано число
//                long chislo = getNumberFromIdx(i);
//                for (long j = chislo; (((chislo * j) - 1) / 2) - 1 < primes.length; j++) {
//                    int idx = getIdxFromNumber(chislo, j);
//                    // Четные числа не участвуют
//                    if (chislo * j % 2 == 1) primes[idx] = false;
//                }
//            }
//        }
//
//        for (long i = 987654321; i > 5000; i--){
//            if (i % 2 != 0 && i % 5 != 0 && i % 9 != 0){
//                if (isPanNumber(i)){
//                    if (primes[getIdx(i)]){
//                        System.out.println(i);
//                        break;
//                    }
//                }
//            }
//        }
//
//        return 0;
//    }

//    private static int getNumberFromIdx(int idx) {
//        return (2 * (idx + 1) + 1);
//    }
//
//    private static int getIdxFromNumber(long prime, long factor) {
//        return (int) ((((prime * factor) - 1) / 2) - 1);
//    }
//
//    private static int getIdx(long number) {
//        if (number % 2 == 0) return -2;
//        if (number == 3 || number == 1) return 0;
//        return (int) (((number - 1) / 2) - 1);
//    }
//
//    private boolean isPanNumber (long number){
//        String numStr = String.valueOf(number);
//        int len = numStr.length();
//        boolean result = true;
//        for (int i = 0; i < len; i++){
//            if (!numStr.contains(String.valueOf(digits[i]))) {
//                result = false;
//                break;
//            }
//        }
//        return result;
//    }

    @Override
    public int getAnswer() {
        //целое число делится на 3, если сумма его цифр делится на 3, если же сумма цифр данного числа не делится на 3, то и само число не делится на 3
        //поэтому начинаем с 7ми
        //массив простых чисел заполняется слишком долго, поэтому лучше проверять только найденные числа
        //метод грубой силы работает примерно 30 сек
        int f = 2;
        while (f < 5) {
            int[] subDigits = Arrays.copyOfRange(digits, f, digits.length);
            int notch = subDigits.length;
            while (notch != 0) {
                if (notch != subDigits.length && subDigits[notch] + 1 > subDigits[notch]) {
                    int z = findNotchIncrease(subDigits, notch);
                    if (z != -1) {
                        swap(subDigits, notch, z);
                        sortMaxToMin(subDigits, notch + 1);
                        notch = subDigits.length;
                        int y = subDigits[subDigits.length - 1];
                        if (y == 1 || y == 3 || y == 7) {
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < subDigits.length; i++) {
                                sb.append(subDigits[i]);
                            }
                            long l = Long.parseLong(sb.toString());
                            if (/*primes[getIdx(l)]*/ isPrime(l)) {
                                System.out.println(l);
                                break;
                            }
                        }
                    } else notch--;
                } else notch--;
            }
            f++;
        }
        return 0;
    }

    private void swap(int[] array, int notch, int second) {
        int idx = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == second) idx = i;
        }
        int tmp = array[notch];
        array[notch] = second;
        array[idx] = tmp;
    }

    private int[] sortMaxToMin(int[] array, int from) {
        int[] part = Arrays.copyOfRange(array, from, array.length);
        for (int i = 0; i < part.length; i++) {
            part[i] *= -1;
        }
        Arrays.sort(part);
        for (int i = 0; i < part.length; i++) {
            part[i] *= -1;
        }
        if (part.length - 1 >= 0) System.arraycopy(part, 0, array, from, part.length);
        return array;
    }

    private int findNotchIncrease(int[] array, int notch) {
        int result = -1;
        int[] part = Arrays.copyOfRange(array, notch, array.length);
        for (int i = 0; i < part.length; i++) {
            part[i] *= -1;
        }
        Arrays.sort(part);
        for (int i = 0; i < part.length; i++) {
            part[i] *= -1;
        }
        for (int i = 0; i < part.length; i++) {
            if (part[i] < array[notch]) return part[i];
        }
        return result;
    }

    private boolean isPrime(long n) {
        if (n % 2 == 0) return n == 2;
        if (n == 1) return false;
        for (int i = 3; i * i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
