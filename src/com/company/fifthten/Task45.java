package com.company.fifthten;

import com.company.EulerTask;

import java.util.ArrayList;

public class Task45 {

//    @Override
    public long getAnswer() {
//        for (long i = 40756; i < Long.MAX_VALUE; i++) {
//            if (/*isTriangle(i) && */isHexagonal(i) && isPentagonal(i)){
//                System.out.println(i);
//                break;
//            }
//        }

//        long a = 286, b = 0, c = 0;
//
//        for (; !(a * (a + 1) / 2 == b * (3 * b - 1) / 2 && b * (3 * b - 1) / 2 == c * (2 * c - 1)); ) {
//            while (a * (a + 1) / 2 < b * (3 * b - 1) / 2 || a * (a + 1) / 2 < c * (2 * c - 1)) a++;
//            while (b * (3 * b - 1) / 2 < a * (a + 1) / 2 || b * (3 * b - 1) / 2 < c * (2 * c - 1)) b++;
//            while (c * (2 * c - 1) < b * (3 * b - 1) / 2 || c * (2 * c - 1) < a * (a + 1) / 2) c++;
//        }
//
//        System.out.println(a + " " + b + " " + c);
//        System.out.println((a * (a + 1) / 2) + (b * (3 * b - 1) / 2) + (c * (2 * c - 1)));

//        long hi = 40756;
//        double i, j, k;
//        while (true) {
//            i = checkInteger(2, -1, -hi);
//            if (Math.ceil(i) == Math.floor(i)) {
//                j = checkInteger(3, -1, -2 * hi);
//                if (Math.ceil(j) == Math.floor(j)) {
//                    k = checkInteger(1, 1, -2 * hi);
//                    if (Math.ceil(k) == Math.floor(k)) {
//                        System.out.println(hi);
//                        break;
//                    } else {
//                        k = Math.ceil(k);
//                        hi = (int) Math.ceil((k) * (k + 1) / 2);
//                    }
//                } else {
//                    j = Math.ceil(j);
//                    hi = (int) Math.ceil((j) * (3 * (j) - 1) / 2);
//                }
//            } else {
//                i = Math.ceil(i);
//                hi = (int) Math.ceil((i) * (2 * (i) - 1));
//            }
//        }

        /*Множество шестиугольных чисел является подмножеством треугольных
        * доказательство: подставить в формулу треугольного числа (2m-1) вместо n
        * генерируем шестиугольные числа и проверяем их на пятиугольность*/
        long result = 0;
        int i = 144;

        while (!isPentagonal(result)) {
            result = i * (2 * i - 1);
            i++;
        }
//        System.out.println(result);
        return result;
    }

//    private boolean isTriangle(long number) {
//        double penTest = (Math.sqrt(1 + 8 * number) - 1) / 2;
//        return penTest == (long) penTest;
//    }

    private boolean isPentagonal(long number) {
        double penTest = (Math.sqrt(1 + 24 * number) + 1) / 6;
        return penTest == (long) penTest;
    }
//
//    private boolean isHexagonal(long number) {
//        double penTest = (Math.sqrt(1 + 8 * number) + 1) / 4;
//        return penTest == (long) penTest;
//    }
//
//    public static double checkInteger(int a, int b, long c) {
//
//        double d = Math.sqrt(b * b - 4 * a * c);
//        return ((double) -b + d) / 2 / a;
//
//    }
}
