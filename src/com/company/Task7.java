package com.company;

import java.util.Arrays;

public class Task7 {
    private int counter = 0;

    private boolean[] firstArr = new boolean[Integer.MAX_VALUE/30000];

    public long getAnswer(){
        Arrays.fill(firstArr, true);
        for (int i = 0; i<firstArr.length; i++) {
            if (firstArr[i]){
                int idx = 0;
                int chislo = (2 * (i + 1) + 1);
                for (int j = chislo; idx<firstArr.length && Integer.MAX_VALUE / j < i; j++) {
//                    int chislo = (2 * (i + 1) + 1) * j;
                    if (chislo * j % 2 == 1) {
                        idx = (((chislo*j)-1)/2)-1;
                        if(idx<firstArr.length && idx>0 && Integer.MAX_VALUE / j < i) firstArr[idx] = false;
                        if(!firstArr[2]) {
                            System.out.println(chislo);
//                            System.out.println(j);
                            System.out.println(/*141201*152087 < */Integer.MAX_VALUE / 152087);
                        }
                    }
                }
            }
        }
        for(int i = 0; i<firstArr.length; i++){
            if (firstArr[i]) counter++;
            if (counter==10000) return 2*(i+1)+1;
        }
        return 0;
    }
}
