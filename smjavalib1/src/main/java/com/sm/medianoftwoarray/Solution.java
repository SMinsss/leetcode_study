package com.sm.medianoftwoarray;

import com.sun.org.apache.bcel.internal.generic.BranchHandle;
import com.sun.org.apache.regexp.internal.REUtil;

import java.awt.image.DirectColorModel;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/23.
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */

class Solution {

    private double compareToFind(int[] num1, int[] num2, int index1, int index2, int length1, int length2, int median) {
        System.out.format("compareToFind index1: %d, index2: %d\n", index1, index2);
        int rest = (length1 + length2) % 2;
        int count = index1 + index2;
        while (true) {
            if(num1[index1] > num2[index2]) {
                index2++;
            } else {
                index1++;
            }
            System.out.format("after increase index1: %d, index2: %d\n", index1, index2);
            if(index1 >= length1) {
                System.out.format("index1 larger than length1 , index1: %d , index2: %d , median: %d\n", index1, index2, median);
                //return rest == 1?num2[median - index1 + index2]:(num2[median - index1 + index2] + num2[median - index1 + index2 + 1])/2;
                if(index2 != 0) {
                    index1--;
                    index2 = index2 + median- index1;
                }
                break;
            }
            if(index2 >= length2) {
                System.out.format("index2 larger than length2 , index1: %d , index2: %d , median: %d\n", index1, index2, median);
                //return rest == 1?num1[median - index2 + index1]:(num1[median - index2 + index1] + num1[median - index2 + index1 + 1])/2;
                if(index1 != 0) {
                    index2--;
                    index1 = index1 + median - index2;
                }
                break;
            }

            if(++count == median) {
                System.out.format("++count == median ,count: %d, median: %d\n", count, median);
                break;
            }
        }
        System.out.format("index1: %d , index2: %d\n", index1, index2);
        int result1, result2;
        if(index1 == 0 && index2 == length2) {
            index1 = median - index2;
            result1 = num1[index1++];
        } else if(index2 == 0 && index1 == length1) {
            index2 = median - index1;
            result1 = num2[index2++];
        } else if(num1[index1] > num2[index2]) {
            result1 = num2[index2];
            index2++;
        } else {
            result1 = num1[index1];
            index1++;
        }
        if(index1 >= length1) {
            result2 = num2[index2];
            System.out.format("s1 index1: %d, result2: %d\n", index2, result2);
            //return ((double)result1 + (double)num2[index2])/2;
        } else if(index2 >= length2) {
            result2 = num1[index1];
            System.out.format("s2 index1: %d, result2: %d\n", index1, result2);
            //return ((double)result1 + (double)num1[index1])/2;
        } else if(num1[index1] > num2[index2]) {
            result2 = num2[index2];
            System.out.format("s3 index2: %d, result2: %d\n", index2, result2);
            //return ((double)result1 + (double)num2[index2])/2;
        } else{
            result2 = num1[index1];
            System.out.format("s4 index1: %d, result2: %d\n", index1, result2);
            //return ((double)result1 + (double)num1[index1])/2;
        }
        System.out.format("index1: %d , index2: %d , result1: %d , result2: %d\n", index1, index2, result1, result2);
        if(rest == 1) {
            return result2;
        } else {
            return ((double) result1 + (double) result2)/2;
        }
    }

    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int length1 = num1.length, length2 = num2.length;
        int median = (length1 + length2)/2 - 1;
        int index1 = 0, index2 = 0, indexN1, indexN2;
        while (true) {
            if(num1[index1] > num2[index2]) {
                System.out.format("s1 num1[index1]: %d, num2[index2]: %d \n", num1[index1] , num2[index2]);
                indexN1 = index1;
                indexN2 = (index2<<1) + 1;
            } else {
                System.out.format("s2 num1[index1]: %d, num2[index2]: %d \n", num1[index1] , num2[index2]);
                indexN1 = (index1<<1) + 1;
                indexN2 = index2;
            }
            if(indexN1 >= length1 || indexN2 >= length2) {
                System.out.format("out of length, indexN1: %d, indexN2: %d\n", indexN1, indexN2);
                return compareToFind(num1, num2, index1, index2, length1, length2, median);
            }
            if(indexN1 + indexN2 >= median) {
                System.out.format("after median, indexN1: %d, indexN2: %d, median: %d\n", indexN1, indexN2, median);
                return compareToFind(num1, num2, index1, index2, length1, length2, median);
            }
            // 不用if-else将多了两次赋值
            System.out.format("findMedian, index: %d, index2: %d, indexN1: %d, indexN2: %d\n", index1, index2, indexN1, indexN2);
            index1 = indexN1;
            index2 = indexN2;
        }
    }

    public static void main(String[] args) {
        // maybe the memories are better..
        int[] num1 = new int[] {100,101,102,103,104,105};
        int[] num2 = new int[] {1,2};

        ArrayList<Object> num1Objs = new ArrayList<>();
        ArrayList<Object> num2Objs = new ArrayList<>();

        num1Objs.add(new int[]{1,3,5,6,7,9,11});
        num2Objs.add(new int[]{2,4,6,8,10});

        num1Objs.add(new int[]{1,3,5,6,7,9,11,13});
        num2Objs.add(new int[]{2,4,6,8,10,12});

        num1Objs.add(new int[]{1,3,5,6,7,9,11});
        num2Objs.add(new int[]{100});

        num1Objs.add(new int[]{1});
        num2Objs.add(new int[]{100,101,102,103,104,105});

        num1Objs.add(new int[]{100,101,102,103,104,105});
        num2Objs.add(new int[]{1,2,3});

        num1Objs.add(new int[]{100,101,102,103,104,105});
        num2Objs.add(new int[]{1,2,3,4});

        Solution solution = new Solution();
        for(int i = 0; i < num1Objs.size() ;i++) {
            int[] a1 = (int[]) num1Objs.get(i);
            for(int j = 0; j < a1.length;j++) {
                System.out.format("%d ", a1[j]); // 打印数组1
            }
            System.out.format("\n");
            int[] a2 = (int[]) num2Objs.get(i);
            for(int j = 0; j < a2.length;j++) {
                System.out.format("%d ", a2[j]); // 打印数组2
            }
            System.out.format("\n");
            System.out.println("result: " + solution.findMedianSortedArrays(a1, a2));
            System.out.format("\n");
        }

    }

}