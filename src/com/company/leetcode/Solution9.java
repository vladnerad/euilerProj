package com.company.leetcode;

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int number = x;
        int reverse = 0;
        int remainder;
        do {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;

        } while (number > 0);

        return x == reverse;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(-121));
    }
}