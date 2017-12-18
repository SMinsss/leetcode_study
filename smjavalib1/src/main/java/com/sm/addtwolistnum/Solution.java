package com.sm.addtwolistnum;

/**
 * Created by Administrator on 2017/12/17.
 */

/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */

class Solution {
    // simplify your code
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curL1 = l1, curL2 = l2;
        boolean hasAddIn; // 有进位
        int va1 = curL1.val;
        int va2 = curL2.val;
        int sum = va1 + va2;

        ListNode result = new ListNode(sum %10);
        ListNode curResult = result;

        while (curL1.next != null) {
            if(curL2.next == null) {
                //System.out.format("curL2.next == null\n");
                copyList(curL1.next, curResult, sum);
                return result;
            } else {
                sum = curL1.next.val + curL2.next.val + sum/10;
                //System.out.format("sum: %s, rest: %s\n", sum, rest);
                curResult.next = new ListNode(sum%10);
                curResult = curResult.next;
                curL1 = curL1.next;
                curL2 = curL2.next;
            }
        }
        if(curL2.next != null) {
            //System.out.format("curL1.next == null\n");
            copyList(curL2.next, curResult, sum);
        } else {
            if (sum/10 == 1) {
                curResult.next = new ListNode(1);
            }
        }

        return result;
    }

    private void copyList(ListNode origNode, ListNode destNode, int lastSum) {
        ListNode curOrigNode = origNode;
        ListNode curDestNode = destNode;
        int sum = curOrigNode.val + lastSum/10;
        //System.out.format("copyList sum: %s, rest: %s, result: %s\n", sum, rest, hasAdd?rest:sum);
        curDestNode.next = new ListNode(sum%10);
        curDestNode = curDestNode.next;
        while (curOrigNode.next != null) {
            //System.out.format("copyList origin next not null\n");
            curOrigNode = curOrigNode.next;
            sum = curOrigNode.val + (sum/10);
            curDestNode.next = new ListNode(sum%10);
            curDestNode = curDestNode.next;
        }
        if(sum/10 == 1) {
            curDestNode.next = new ListNode(1);
        }
    }

    private static class  ListNode {
        ListNode(int x) { val = x; }
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
////        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.format("%s", result.val);
        while (result.next != null) {
            result = result.next;
            System.out.format(" -> %s", result.val);
        }
    }
}



