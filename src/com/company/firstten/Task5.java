package com.company.firstten;

import com.company.EulerTask;

public class Task5 implements EulerTask {
    private int range = 20;

    @Override
    public int getAnswer(){
        int result = 40;
        while (!chekDivis(result)){
            result+=range;
        }
        return result;
    }

    private boolean chekDivis(int n){
        for(int i = range; i>10; i--){
            if (!(n%i==0)) return false;
        }
        return true;
    }
}
