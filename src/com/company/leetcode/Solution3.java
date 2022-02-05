package com.company.leetcode;

import java.util.HashSet;
import java.util.Iterator;

public class Solution3 {

//    public int lengthOfLongestSubstring(String s) {
//        int result = s.length() == 0 ? 0 : 1;
//        for (int i = 0; i < s.length(); i++){
//            char current = s.charAt(i);
//            int currentLength;
//            for (int j = i + 1; j < s.length(); j++){
//                if (s.charAt(j) == current || j == s.length() - 1){
//                    currentLength = j - i;
//                    if (currentLength > result) result = currentLength;
//                    break;
//                }
////                else {
////                    if (j == s.length() - 1 && s.charAt(j) != current){
////                        currentLength = j - i;
////                        if (currentLength > result) result = currentLength;
////                        break;
////                    }
////                }
//            }
//        }
//        return result;
//    }

    public int lengthOfLongestSubstring(String s) {
        int result = s.length() == 0 ? 0 : 1;
        result = helper(s, result);
        return result;
    }

    private int helper(String s, int currentMax){
        Iterator<Integer> iterator = s.chars().iterator();
        HashSet<Integer> buffer = new HashSet<>();
        while (iterator.hasNext()){
            int before = buffer.size();
            buffer.add(iterator.next());
            int after = buffer.size();
            if(before == after){
                int cMax = Math.max(after, currentMax);
//                if (after > currentMax)
                    return Math.max(cMax, helper(s.substring(1), cMax));
//                if (after != 1) buffer = new HashSet<>();
            }
        }
        if (buffer.size() > currentMax)
            return Math.max(buffer.size(), helper(s.substring(1), buffer.size()));
        return s.length() > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("bbtablud")); //6
        System.out.println(solution3.lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(solution3.lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(solution3.lengthOfLongestSubstring("aab")); //2
        System.out.println(solution3.lengthOfLongestSubstring("dvdf")); //3
    }

}
