package com.company.sixtieths;

import com.company.EulerTask;

import java.util.HashSet;
import java.util.Set;

public class Task58 implements EulerTask {
    @Override
    public int getAnswer() {
        Set<Long> diagNum = new HashSet<>();
        diagNum.add(1L);
        int primes = 0;
        final int firstNumDiagDelta = 8;
        int currentDiagDelta = 2;
        final int diagNumDelta = 2;
        int currentDelta = 0;
        long lastFirstAdded = 1L;
        double d = 1;
        while (d >= 0.1) {
            lastFirstAdded += currentDiagDelta;
            diagNum.add(lastFirstAdded);
            if (isPrime(lastFirstAdded)) primes++;
            currentDiagDelta += firstNumDiagDelta;

            currentDelta += diagNumDelta;
            for (int i = 1; i <= 3; i++) {
                long angleNum = lastFirstAdded + currentDelta * i;
                diagNum.add(angleNum);
                if (isPrime(angleNum)) primes++;
            }
            d = (double) primes / (double) diagNum.size();
        }
        return currentDelta + 1;
    }

    public boolean isPrime(long l) {
        if (l % 2 == 0) return l == 2;
        long i;
        for (i = 3; i * i < l && l % i != 0; ) {
            i = i + 2;
        }
        return i * i > l;
    }
}
