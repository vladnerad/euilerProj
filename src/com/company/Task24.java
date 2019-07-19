package com.company;

import java.util.Arrays;

public class Task24 {

    private int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int shuffleCount = 999999;

    public String getAnswer() {
        int counter = 0;
        int notch = array.length;
        while (counter < shuffleCount) {
            if (notch != array.length && array[notch] + 1 > array[notch]) {
                int z = findNotchIncrease(array, notch);
                if (z != -1) {
                    swap(array, notch, z);
                    sortMinToMax(array, notch + 1);
                    counter++;
                    notch = array.length;
//                    System.out.println(Arrays.toString(array));
                } else notch--;
            } else notch--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
        return null;
    }

    private int[] sortMinToMax(int[] array, int from) {
        int[] part = Arrays.copyOfRange(array, from, array.length);
        Arrays.sort(part);
        if (part.length - 1 >= 0) System.arraycopy(part, 0, array, from, part.length);
        return array;
    }

    private int findNotchIncrease(int[] array, int notch) {
        int result = -1;
        int[] part = Arrays.copyOfRange(array, notch, array.length);
        Arrays.sort(part);
        for (int i = 0; i < part.length; i++) {
            if (part[i] > array[notch]) return part[i];
        }
        return result;
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
}

