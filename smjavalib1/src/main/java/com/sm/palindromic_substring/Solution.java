package com.sm.palindromic_substring;

/**
 * Created by Administrator on 2018/1/4.
 *
 *
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */

public class Solution {

    int result0, result1, resultL;

    public String longestPalindrome(String s) {
        result0 = result1 = resultL = 1;
        int length = s.length();
        if (length == 1) {
            return s;
        }
        if (length == 2) {
            return s.charAt(0) == s.charAt(1) ? s : String.valueOf(s.charAt(0));
        }
        int index = 0;
        while (true) {
             if (s.charAt(index + 2) == s.charAt(index)) {
                 searchForPalindrome(s, length, index, index + 2);
            }
            if (s.charAt(index) == s.charAt(index + 1)) {
                 searchForPalindrome(s, length, index, index + 1);
            }

            if (index == length - 3) {
                if(s.charAt(index + 1) == s.charAt(index + 2)) searchForPalindrome(s, length, index+1, index + 2);
                break;
            } else {
                index++;
            }
        }
        System.out.format("final result0: %d , result1: %d\n",result0, result1);
        return s.substring(result0, result1+1);
    }

    private void searchForPalindrome(String s, int length, int index0, int index1) {
        while (true) {
            if(index0 -1 < 0 || index1 + 1 > length -1) break;
            if (s.charAt(index0 -1) != s.charAt(index1 + 1)) break;
            index0--;
            index1++;
        }
        int l = index1 - index0 + 1;
        if (l > resultL) {
            System.out.format("resultL: %d, index0: %d, index1: %d\n", l, index0, index1);
            result0 = index0;
            result1 = index1;
            resultL = l;
        }
    }


    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.format(a.substring(0, 1) + "\n");

        Solution solution = new Solution();
        System.out.format(solution.longestPalindrome("abb") + "\n");

//        System.out.format(solution.longestPalindrome("bab") + "\n");
//        System.out.format(solution.longestPalindrome("babad") + "\n");
//        System.out.format(solution.longestPalindrome("cbbd") + "\n");
//        System.out.format(solution.longestPalindrome("abcdefggggfe") + "\n");
//        System.out.format(solution.longestPalindrome("abcdefggggfedcccccccdefgggg") + "\n");
//        System.out.format(solution.longestPalindrome("ggggfedcccccccdefgggg") + "\n");
//        System.out.format(solution.longestPalindrome("ccccccc") + "\n");
//        System.out.format(solution.longestPalindrome("ccd") + "\n");

    }
}
