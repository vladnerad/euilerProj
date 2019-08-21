package com.company.thirdten;

import com.company.EulerTask;

public class Task23 implements EulerTask {

/*
    Running time: 121 ms.
            What's fast is the sumOfDivisors part; it extracts prime factors and then computes the sum of divisors from those primes. Hints to that algorithm are in the FAQ of this site. This is Alvaro's version, which is more readable than mine was.
    The algorithm counts n as a factor of n; to compensate, the comparison is done against n+n.
    For the selection of numbers that cannot be written as the sum of two abundant numbers, there is a choice of algorithm. One can search for a combination of abundant numbers to make each number, as I did, or one can generate the numbers that can be written as (...) by running through all combinations of abundant numbers. Perhaps the latter is faster :(

    Bart
*/

    private int border = 28123;
    private int[] abNums = new int[border + 1];
    private int[] nums = new int[border + 1];
    private boolean[] abundant = new boolean[border + 1];
    private int nAb = 0;

    @Override
    public int getAnswer() {
        for (int n = 1; n <= border; n++) {
            nums[n] = n;
            abundant[n] = isAbundant(n);
            if (abundant[n]) {
                abNums[nAb++] = n;
            }
        }
        for (int n = 1; n <= border; n++) {
            int iAb = 0;
            while (iAb < nAb) {
                if (n - abNums[iAb] < 12)
                    break;
                if (abundant[n - abNums[iAb]]) {
                    nums[n] = 0;
                    break;
                }
                iAb++;
            }
        }
        int sum = 0;
        for (int i = 1; i <= border; i++)
            sum += nums[i];
        return sum;
    }

    private boolean isAbundant(int n) {
        return (sumOfDivisors(n) > n + n);
    }

    private int sumOfDivisors(int n) {
        int prod = 1;
        for (int k = 2; k * k <= n; ++k) {
            int p = 1;
            while (n % k == 0) {
                p = p * k + 1;
                n /= k;
            }
            prod *= p;
        }
        if (n > 1)
            prod *= 1 + n;
        return prod;
    }

    //    @Override
//    public int getAnswer() {
//        int result = 0;
//        ArrayList<Integer> abundantNumbers = new ArrayList<>();
//        for (int i = 12; i <= border; i++) {
//            if (Task21.findDivSum(i) > i) abundantNumbers.add(i);
//        }
////        System.out.println(abundantNumbers.get(abundantNumbers.size()-1));
//        for (int i = 1; i < 24; i++) {
//            result += i;
//        }
//
//        for (int i = 25; i <= border; i++) {
//            int j = 0;
//            boolean flag = false;
//            if (i % 2 != 0 && i < 945) {
//                result += i;
//                continue;
//            }
//            while (j < i / 2 && j < abundantNumbers.size() - 1) {
//                if (abundantNumbers.contains(i - abundantNumbers.get(j))) {
//                    flag = true;
//                    break;
//                }
//                j++;
//            }
//            if(!flag) result += i;
//        }
//        return result;
//    }
}
