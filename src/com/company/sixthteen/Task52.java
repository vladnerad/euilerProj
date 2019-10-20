package com.company.sixthteen;

import com.company.EulerTask;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task52 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;
//        System.out.println(isContainsSameDigits(125874, 251748));
        for (int i = 100000; i < 1000000; i++){
            int j = i * 2;
            int k = i * 3;
            int l = i * 4;
            int m = i * 5;
            int n = i * 6;
            if (isContainsSameDigits(i, j) && isContainsSameDigits(i, k)
            && isContainsSameDigits(i, l) && isContainsSameDigits(i, m)
            && isContainsSameDigits(i, n)) return i;
        }
        return result;
    }

    private boolean isContainsSameDigits(int x1, int x2){
        Set<String> first = new HashSet<>(Arrays.asList(String.valueOf(x1).split("")));
        Set<String> second = new HashSet<>(Arrays.asList(String.valueOf(x2).split("")));
        return first.equals(second);
    }
}
