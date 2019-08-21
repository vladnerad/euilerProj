package com.company.firstten;

public class Task3 {

    private long chislo;

    public Task3(long chislo) {
        this.chislo = chislo;
    }

    public long getAnswer(){
        //n prime check
        if(isPrime(chislo)) return chislo;
        //n not prime
        double root = Math.sqrt(chislo);
        long zal = (long) Math.floor(root);
        for (long i = zal; i>1; i--){
            if(chislo % i == 0){
                if(isPrime(i)){
                    return i;
                }
            }
        }
        return 0;
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
