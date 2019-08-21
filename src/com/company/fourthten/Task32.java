package com.company.fourthten;

import com.company.EulerTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task32 implements EulerTask {
    @Override
    public int getAnswer() {
        HashSet<Integer> resul = new HashSet<>();
        int result = 0;

        for (int i = 12; i <= 98; i++) {
            if (i % 10 != 0 && i % 11 != 0) {
                String[] delimiter = String.valueOf(i).split("");
                for (int j = 9876; j >= 1234; j--) {
                    Set<String> buff = new HashSet<>(Arrays.asList(String.valueOf(j).split("")));
                    if (buff.size() == 4 && !buff.contains(delimiter[0]) && !buff.contains(delimiter[1]) && !buff.contains("0") && j % i == 0) {
                        int z = j / i;
                        Set<String> zSet = new HashSet<>(Arrays.asList(String.valueOf(z).split("")));
                        if (zSet.size() == 3 && !zSet.contains(delimiter[0]) && !zSet.contains(delimiter[1])
                                && Collections.disjoint(zSet, buff) && !zSet.contains("0")) {
//                            System.out.println(i + " * " + z + " = " + j);
                            resul.add(j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            String delimiter = String.valueOf(i);
            for (int j = 9876; j >= 1234; j--) {
                Set<String> buff = new HashSet<>(Arrays.asList(String.valueOf(j).split("")));
                if (buff.size() == 4 && !buff.contains(delimiter) && !buff.contains("0") && j % i == 0) {
                    int z = j / i;
                    Set<String> zSet = new HashSet<>(Arrays.asList(String.valueOf(z).split("")));
                    if (zSet.size() == 4 && !zSet.contains(delimiter)
                            && Collections.disjoint(zSet, buff) && !zSet.contains("0")) {
//                        System.out.println(i + " * " + z + " = " + j);
                        resul.add(j);
                    }
                }
            }
        }
//        System.out.println("**********************");
        for (int i : resul) {
//            System.out.println(i);
            result += i;
        }
        return result;
    }
}
