package com.sm.longestsubstring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/21.

 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int index;
        StringBuilder builder = new StringBuilder();
        int longestL = 0;
        int builderL = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            index = builder.indexOf(String.valueOf(c));
            if(index >= 0) {
                builder.delete(0, index + 1);
            }
            builder.append(c);
            builderL = builder.length();
            if(builderL > longestL) longestL = builderL;
        }

        return longestL;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int r1 = solution.lengthOfLongestSubstring("abcabcbb");
        int r2 = solution.lengthOfLongestSubstring("bbbbb");
        int r3 = solution.lengthOfLongestSubstring("pwwkew");
        System.out.format("r1: %d, r2: %d, r3: %d",r1, r2, r3);


//        StringBuilder builder = new StringBuilder();
//        builder.append("SMinsssabcd");
//        int indexa = builder.indexOf(String.valueOf("a"));
//        System.out.format("index: %d\n", indexa);
//
//        String sub = builder.substring(indexa + 1); // 包括当前那个字符
//
//        System.out.format("sub: %s\n", sub);
//
//        builder.delete(0, indexa + 1);
//
//        System.out.format("after delete: %s\n", builder.toString());
//
//        int indexm = builder.indexOf(String.valueOf("m"));
//        System.out.format("indexm: %d\n", indexm);
    }

}
