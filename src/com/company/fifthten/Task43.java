package com.company.fifthten;

import com.company.EulerTask;

import java.util.Arrays;

public class Task43 implements EulerTask {

    private int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private int[] end = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    public int getAnswer() {
//        System.out.println(isCorrect("1406357289"));
        long result = 0;

        int notch = digits.length;
        while (digits != end) {
            if (notch < 0) break;
            if (notch != digits.length && digits[notch] + 1 > digits[notch]) {
                int z = findNotchIncrease(digits, notch);
                if (z != -1) {
                    swap(digits, notch, z);
                    sortMaxToMin(digits, notch + 1);
                    notch = digits.length;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < digits.length; i++) {
                        sb.append(digits[i]);
                    }
//                    System.out.println(sb.toString());
                        if (isCorrect(sb.toString())) {
                            result += Long.parseLong(sb.toString());
                        }
                } else notch--;
            } else notch--;
        }
        System.out.println(result);
        return 0;
    }

    private boolean isCorrect(String numStr) {

        if (numStr.length() != 10) {
            System.out.println("Error");
            return false;
        }
        if (Integer.parseInt(numStr.substring(1, 4)) % 2 != 0) return false;
        if (Integer.parseInt(numStr.substring(2, 5)) % 3 != 0) return false;
        if (Integer.parseInt(numStr.substring(3, 6)) % 5 != 0) return false;
        if (Integer.parseInt(numStr.substring(4, 7)) % 7 != 0) return false;
        if (Integer.parseInt(numStr.substring(5, 8)) % 11 != 0) return false;
        if (Integer.parseInt(numStr.substring(6, 9)) % 13 != 0) return false;
        if (Integer.parseInt(numStr.substring(7, 10)) % 17 != 0) return false;
        return true;
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
}
