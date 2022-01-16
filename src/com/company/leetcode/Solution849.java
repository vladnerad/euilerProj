package com.company.leetcode;

public class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int start = -1;
        int end = seats.length - 1;
        int maxLength = 0;
        int prevPerson = start;

        for (int i = 0; i < seats.length; i++){
            if (seats[i] == 1 && i != end) {
                if ((i - prevPerson) / 2 > maxLength) {
                    if (prevPerson == start) maxLength = i;
                    else maxLength = (i - prevPerson) / 2;
                }
                prevPerson = i;
            }
            if (i == end){
                if (seats[i] == 0 && i - prevPerson > maxLength) {
                    maxLength = i - prevPerson;
                }
                if (seats[i] == 1){
                    if (prevPerson == start) maxLength = i;
                    else {
                        if ((i - prevPerson) / 2 > maxLength) {
                            maxLength = (i - prevPerson) / 2;
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] ex1 = {1,0,0,0,1,0,1}; //2
        int[] ex2 = {1,0,0,0};  //3
        int[] ex3 = {0,1};  //1
        int[] ex4 = {0,1,0,1,0};  //1
        int[] ex5 = {1,0,1};  //1
        int[] ex6 = {1,1,0,0,0,1,1,0,0,1,0};  //2
        int[] ex7 = {1,0,1,1,0,0,0,0,0,1,0,0,0,1};  //3

        System.out.println(new Solution849().maxDistToClosest(ex1));
        System.out.println(new Solution849().maxDistToClosest(ex2));
        System.out.println(new Solution849().maxDistToClosest(ex3));
        System.out.println(new Solution849().maxDistToClosest(ex4));
        System.out.println(new Solution849().maxDistToClosest(ex5));
        System.out.println(new Solution849().maxDistToClosest(ex6));
        System.out.println(new Solution849().maxDistToClosest(ex7));
    }
}
