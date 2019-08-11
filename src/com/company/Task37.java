package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task37 implements EulerTask {

    private boolean[] primes = new boolean[500000];
//    private int[] firstD = {2, 3, 5, 7};
//    private int[] midD = {1, 3, 7, 9};
//    private int[] lastD = {3, 7};

    private int[] allD = {1, 2, 3, 5, 7, 9};

    private int count = 0;
    private int res = 0;

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

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(7);

        while (count < 11) {
            int primeCandidate = queue.poll();
            if (primes[getIdx(primeCandidate)]) {
                boolean isTruncablePrime = true;
                int n = primeCandidate;
                int multiplier = 1;

                while (n > 0) {
                    isTruncablePrime = ((n % 2 != 0 && primes[getIdx(n)] || n == 2) && n != 1) && isTruncablePrime;
                    n /= 10;
                    multiplier *= 10;
                }

                if (isTruncablePrime && primeCandidate > 10) {
                    res += primeCandidate;
                    System.out.println(primeCandidate);
                    count++;
                }

                for (int i = 0; i < allD.length; i++) {
                    queue.add(multiplier * allD[i] + primeCandidate);
                }
            }
        }
//        for (int i = 0; i < allD.length; i++) {
//            findPrime(allD[i]);
//        }
//        int result = 0;
//        int counter = 0;
//
////        System.out.println(primes[getIdx(73797)]);
//        for (int i = 0; i < firstD.length; i++){
//            for (int j = 0; j < lastD.length; j++){
//                if (firstD[i] != lastD[j]){
//                    int num = firstD[i]*10 + lastD[j];
//                    if (primes[getIdx(num)]){
//                        counter++;
//                        System.out.println(num);
//                        result+=num;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < firstD.length; i++){
//            for (int j = 0; j < midD.length; j++) {
//                if (firstD[i] != midD[j]) {
//                    int zum = firstD[i] * 10 + midD[j];
//                    if (primes[getIdx(zum)]) {
//                        for (int z = 0; z < lastD.length; z++) {
//                            if (midD[j] != lastD[z]) {
//                                int num = firstD[i] * 100 + midD[j] * 10 + lastD[z];
//                                int num2 = midD[j] * 10 + lastD[z];
//                                if (primes[getIdx(num)] && primes[getIdx(num2)]) {
//                                    counter++;
//                                    System.out.println(num);
//                                    result += num;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < firstD.length; i++){
//            for (int j = 0; j < midD.length; j++) {
//                if (firstD[i] != midD[j]) {
//                    int zum = firstD[i] * 10 + midD[j];
//                    if (primes[getIdx(zum)]) {
//                        for (int z = 0; z < midD.length; z++) {
//                            if (midD[j] != midD[z]) {
//                                int num = firstD[i] * 100 + midD[j] * 10 + midD[z];
//                                int num2 = midD[j] * 10 + midD[z];
//                                if (primes[getIdx(num)] && primes[getIdx(num2)]) {
//                                   for (int y = 0; y < lastD.length; y++){
//                                       if (midD[z] != lastD[y]){
//                                           int num3 = firstD[i] * 1000 + midD[j] * 100 + midD[z]*10 + lastD[y];
//                                           int num4 = midD[j] * 100 + midD[z]*10 + lastD[y];
//                                           int num5 = midD[z]*10 + lastD[y];
//                                           if (primes[getIdx(num3)] && primes[getIdx(num4)] && primes[getIdx(num5)]){
//                                               counter++;
//                                               System.out.println(num3);
//                                               result += num3;
//                                           }
//                                       }
//                                   }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < firstD.length; i++){
//            for (int j = 0; j < midD.length; j++) {
//                if (firstD[i] != midD[j]) {
//                    int zum = firstD[i] * 10 + midD[j];
//                    if (primes[getIdx(zum)]) {
//                        for (int z = 0; z < midD.length; z++) {
//                            if (midD[j] != midD[z]) {
//                                int num = firstD[i] * 100 + midD[j] * 10 + midD[z];
//                                int num2 = midD[j] * 10 + midD[z];
//                                if (primes[getIdx(num)] && primes[getIdx(num2)]) {
//                                    for (int y = 0; y <midD.length; y++){
//                                        if (midD[z] != midD[y]){
//                                            int num3 = firstD[i] * 1000 + midD[j] * 100 + midD[z]*10 + midD[y];
//                                            int num4 = midD[j] * 100 + midD[z]*10 + midD[y];
//                                            int num5 = midD[z]*10 + midD[y];
//                                            if (primes[getIdx(num3)] && primes[getIdx(num4)] && primes[getIdx(num5)]){
//                                                for (int o = 0; o < lastD.length; o++){
//                                                    if (midD[y] != lastD[o]){
//                                                        int num6 = firstD[i] * 10000 + midD[j] * 1000 + midD[z]*100 + midD[y]*10 + lastD[o];
//                                                        int num7 = midD[j] * 1000 + midD[z]*100 + midD[y]*10 + lastD[o];
//                                                        int num8 = midD[z]*100 + midD[y]*10 + lastD[o];
//                                                        int num9 = midD[y]*10 + lastD[o];
//                                                        if (primes[getIdx(num6)] && primes[getIdx(num7)] && primes[getIdx(num8)] && primes[getIdx(num9)]){
//                                                            counter++;
//                                                            System.out.println(num6);
//                                                            result += num6;
//                                                        }
//                                                    }
//                                                }
//
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < primes.length; i++) {
//            if (primes[i]) {
//
//            }
//        }

//        while (counter<11){
//            for (int i = 2; i<10; i++){
//                for (int j = 0; j<all.length; j++){
//
//                }
//            }
//        }


//        System.out.println(counter);
//        return ++result;
        System.out.println(count);
        return res;
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

//    private void findPrime(int n) {
//        if (n != 1 && n != 9) {
//            int k = n * 10;
//            for (int i = 0; i < allD.length; i++) {
//                int y = k + allD[i];
//                String[] nums = String.valueOf(y).split("");
//                if ((Integer.parseInt(nums[nums.length - 2]) != allD[i]) && ((y % 2) != 0)) {
//                    if (primes[getIdx(Integer.parseInt("".concat(nums[nums.length - 2]).concat(nums[nums.length - 1])))]) {
//                        if (primes[getIdx(y)] /*&& Integer.parseInt(nums[nums.length - 1])!=9*/) {
//                            System.out.println(y);
//                            count++;
//                            res += y;
//                            findPrime(y);
//                        }
//                    }
//                }
//            }
//        }
//    }
}
