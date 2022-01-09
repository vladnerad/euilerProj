package com.company.leetcode;

import java.math.BigInteger;

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger n1 = getBigInt(l1);
        BigInteger n2 = getBigInt(l2);

        String[] arr = n1.add(n2).toString().trim().split("");
        ListNode result = null;
        ListNode current = null;
        if (arr.length == 1) result = new ListNode(Integer.parseInt(arr[0]));
        for (int i = arr.length - 1; i > 0; i--){
            if (i == arr.length - 1){
                current = new ListNode(Integer.parseInt(arr[i]));
                result = current;
            }
            else {
                current = current.next;
            }
            current.next = new ListNode(Integer.parseInt(arr[i-1]));
        }
        return result;
    }

    private BigInteger getBigInt(ListNode listNode){
        StringBuilder sb = new StringBuilder().append(listNode.val);
        ListNode currentNode = listNode;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            sb.append(currentNode.val);
        }
        return new BigInteger(sb.reverse().toString());
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode a3 = new ListNode(3);
        ListNode a2 = new ListNode(4, a3);
        ListNode a1 = new ListNode(2, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        ListNode z1 = new ListNode(0);
        ListNode z2 = new ListNode(0);

//        ListNode result = new Solution().addTwoNumbers(a1, b1);
        ListNode result = new Solution2().addTwoNumbers(z1, z2);

        System.out.println(result.val);
        while (result.next != null){
            result = result.next;
            System.out.println(result.val);
        }
    }
}