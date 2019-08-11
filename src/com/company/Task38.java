package com.company;

import java.util.HashSet;
import java.util.Set;

public class Task38 implements EulerTask {

    @Override
    public int getAnswer() {
        int result = 0;
        for (int i = 2; i <= 9876; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < 7; j++) {
                if (sb.length() >= 9) break;
                sb.append(i * j);
            }
            if (sb.length() == 9) {
                Set<Integer> set = new HashSet<>();
                for (String dig : sb.toString().split("")) {
                    set.add(Integer.parseInt(dig));
                }
                if (set.size() == 9 && !set.contains(0)) {
                    int z = Integer.parseInt(sb.toString());
                    if (z > result) {
                        result = z;
                    }
                }
            }
        }
        return result;
    }
}
