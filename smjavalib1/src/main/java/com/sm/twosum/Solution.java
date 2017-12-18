package com.sm.twosum;

/**
 * Created by Administrator on 2017/12/17.
 */

import java.lang.invoke.MutableCallSite;
import java.util.HashMap;

/**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++) {
            int cur = nums[i];
            int rest = target - cur;
            Integer restIndex = map.get(rest);
            if(restIndex != null) {
                results[0] = restIndex;
                results[1] = i;
                return results;
            } else {
                map.put(cur, i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 22;

        Solution solution = new Solution();
        int[] results = solution.twoSum(nums, target);
        for (int i = 0; i< results.length ; i++) {
            System.out.format("result[%d] : %d\n", i, results[i]);
        }

    }

}


