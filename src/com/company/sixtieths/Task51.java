package com.company.sixtieths;

import com.company.EulerTask;

public class Task51 implements EulerTask {

    @Override
    public int getAnswer() {
        for (int i = 56997; i < Integer.MAX_VALUE; i+=2){
            String numStr = String.valueOf(i);

        }
        return 0;
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
