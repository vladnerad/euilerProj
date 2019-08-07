package com.company;

import java.util.*;

public class Task33 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;
        int chisl = 1;
        int znam = 1;

        for (int i = 12; i < 100; i++) {
            for (int j = 11; j < i; j++) {
                if (!(i % 10 == 0 && j % 10 == 0)) {
                    Map<String, Integer> map = new LinkedHashMap<>();
                    for (String s : String.valueOf(j).split("")) {
                        map.put(s, 0);
                    }
                    for (String s : String.valueOf(i).split("")) {
                        if (map.containsKey(s)) {
                            map.replace(s, 1);
                        } else map.put(s, 0);
                    }
                    if (map.size() == 3) {
                        double z = (double) j / (double) i;
                        ArrayList<Double> list = new ArrayList<>();
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            if (entry.getValue() == 0) list.add(Double.parseDouble(entry.getKey()));
                        }
                        double y0 = list.get(0);
                        double y1 = list.get(1);
                        double y = y0 / y1;
                        if (z > 0.0 && z < 1.0 && z == y) {
                            chisl *= j;
                            znam *= i;
                            System.out.println(j + " / " + i);
                        }
                    }
                }
            }
        }
        System.out.println(chisl + " / " + znam);
        return result;
    }
}
