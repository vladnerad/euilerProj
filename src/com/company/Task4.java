package com.company;

public class Task4 {
    private int first = 999;
    private int second = 999;

    public int getPalindrome(int first, int second){
        int product = first * second;
        if (isPalindrome(product)){
            System.out.println(first + " * " + second + " = " /*+ product*/);
            return product;
        }
        else {
            if (first == this.first && second < this.second - 1){
                first = this.first - (this.first - second)/2;
                return getPalindrome(first, first);
            }
            return getPalindrome(++first, --second);
        }
    }

    public int getAnswer(){
        return getPalindrome(first-1, second-1);
    }

    public boolean isPalindrome(int number){
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        if (str.length()%2==0){
            sb.append(str.substring(str.length()/2));
        }
        else {
            sb.append(str.substring(str.length()/2+1));
        }
        return str.substring(0, str.length()/2).equals(sb.reverse().toString());
    }
}
