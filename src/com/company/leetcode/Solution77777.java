package com.company.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution77777 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        ArrayList<Integer> all = new ArrayList<>();
//        all.addAll(nums1);

        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        if (result.length % 2 != 0){
            return result[result.length/2];
        }
        else {
            return (double) (result[result.length/2] + result[result.length/2 - 1]) / 2;
        }
    }

    public static void main(String[] args) {

        int[] m = {1, 2, 10, 54, 56};
        int[] n = {38, 40, 55, 62, 100};

//        System.out.println(new Solution().findMedianSortedArrays(m, n));
//        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new Solution77777().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//
//        int l1 = m.length;
//        int l2 = n.length;
//
//        int avgIdx1_1;
//        int avgIdx1_2;
//
//        int avgIdx2_1;
//        int avgIdx2_2;
//
////        if (l1 % 2 != 0){
////            avgIdx1_1 = l1/2 + 1;
////            avgIdx1_2 = avgIdx1_1;
////        } else {
////            avgIdx1_1 = l1 / 2;
////            avgIdx1_2 = l1/2 + 1;
////        }
////
////        if (l1 % 2 != 0){
////            avgIdx2_1 = l1/2 + 1;
////            avgIdx2_2 = avgIdx1_1;
////        } else {
////            avgIdx2_1 = l1 / 2;
////            avgIdx2_2 = l1/2 + 1;
////        }
//
//        int target1 = (l1 + l2) / 2;
//        int target2 = target1 % 2 == 0 ? target1 + 1 : 0;
//
//        int pointer1 = l1/2;
//        int pointer2 = l2/2;
//
//        while (true){
//            if (m[pointer1] == target1 || n[pointer2] == target1){
//                System.out.println("tut");
//                break;
//            }
//            else {
//                if (n[pointer2] > m[pointer1]){
//                    pointer1++;
//                }
//                else {
//                    pointer2++;
//                }
//            }
//        }


    }
}
