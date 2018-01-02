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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if((m+n)%2==0){
            return (findKth(nums1,nums2,0,0,m,n,k)+findKth(nums1,nums2,0,0,m,n,k+1))/2;
        }   else {
            return findKth(nums1,nums2,0,0,m,n,k+1);
        }
    }

    private double findKth(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k){
        if(len1>len2){
            return findKth(arr2,arr1,start2,start1,len2,len1,k);
        }
        if(len1==0){
            return arr2[start2 + k - 1];
        }
        if(k==1){
            return Math.min(arr1[start1],arr2[start2]);
        }
        int p1 = Math.min(k/2,len1) ;
        int p2 = k - p1;
        if(arr1[start1 + p1-1]<arr2[start2 + p2-1]){
            return findKth(arr1,arr2,start1 + p1,start2,len1-p1,len2,k-p1);
        } else if(arr1[start1 + p1-1]>arr2[start2 + p2-1]){
            return findKth(arr1,arr2,start1,start2 + p2,len1,len2-p2,k-p2);
        } else {
            return arr1[start1 + p1-1];
        }
    }

    public static void main(String[] args) {
        // maybe the memories are better..
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

        num1Objs.add(new int[]{});
        num2Objs.add(new int[]{1,2,3,4});

        num1Objs.add(new int[]{});
        num2Objs.add(new int[]{1});

        num1Objs.add(new int[]{1});
        num2Objs.add(new int[]{1});

        num1Objs.add(new int[]{1,2,3,4});
        num2Objs.add(new int[]{1,3,4,5});

        num1Objs.add(new int[]{6,6});
        num2Objs.add(new int[]{1,1});

        num1Objs.add(new int[]{1,1});
        num2Objs.add(new int[]{6,6});

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