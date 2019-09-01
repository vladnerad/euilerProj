package com.company.fifthten;

import com.company.EulerTask;

import java.util.*;

public class Task49 implements EulerTask {

    private Set<Integer> nabs = new HashSet<>();
    private int[] end = {1, 3, 7, 9};

    @Override
    public int getAnswer() {
        fillSet();
        for (Integer zi : nabs) {
            int[] digs = new int[3];
            digs[0] = zi / 100;
            digs[1] = zi % 100 / 10;
            digs[2] = zi % 100 % 10;
//            System.out.println(Arrays.toString(digs));
            Set<Integer> set = new TreeSet<>();
            set.add(zi);
            int count = 0;
            int notch = digs.length;
            while (count != 6) {
                if (notch < 0) break;
                if (notch != digs.length && digs[notch] + 1 > digs[notch]) {
                    int z = findNotchIncrease(digs, notch);
                    if (z != -1) {
                        swap(digs, notch, z);
                        sortMinToMax(digs, notch + 1);
                        notch = digs.length;
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < digs.length; i++) {
                            sb.append(digs[i]);
                        }
                        set.add(Integer.parseInt(sb.toString()));
                        count++;
                    } else notch--;
                } else notch--;
            }
//            System.out.println(set);
            ArrayList<Integer> arrayList = new ArrayList<>(set);
            Collections.sort(arrayList);
            int buff = 0;
            int buff1 = 0;
            boolean isFound = false;
            int[] res = new int[3];
            for (int y = arrayList.get(0); y < arrayList.get(5); y++) {
                if (buff != 0) {
                    if (arrayList.contains(buff1 + buff)) {
                        res[2] = buff1 + buff;
                        isFound = true;
                        break;
                    } else {
                        buff = 0;
                        buff1 = 0;
                        res = new int[3];
                    }
                }
                if (arrayList.contains(arrayList.get(0) + y)) {
                    buff = y;
                    buff1 = arrayList.get(0) + y;
                    res[0] = arrayList.get(0);
                    res[1] = arrayList.get(0) + y;
                } else if (arrayList.contains(arrayList.get(1) + y)) {
                    buff = y;
                    buff1 = arrayList.get(1) + y;
                    res[0] = arrayList.get(1);
                    res[1] = arrayList.get(1) + y;
                } else {
                    res = new int[3];
                    buff1 = 0;
                }
            }
            if (isFound) {
                for (Integer i : end) {
                    boolean isF = true;
                    for (Integer j : res) {
                        int gh = j * 10 + i;
                        if (!isPrime(gh)) {
                            isF = false;
                            break;
                        }
                    }
                    if (isF) {
                        System.out.println(Arrays.toString(res));
                        System.out.println(i);
                    }
                }
            }
        }
        return 0;
    }

    private void fillSet() {
        for (int i = 1; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                for (int z = j + 1; z < 10; z++) {
                    nabs.add(z + j * 10 + i * 100);
                }
            }
        }
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

    private boolean isPrime(long n) {
        if (n % 2 == 0) return n == 2;
        if (n == 1) return false;
        for (int i = 3; i * i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
