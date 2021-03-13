package com.ityb.iv.arithmetic;

/**
 * 二分查找
 */
public class BinSearch {

    public static void main(String[] args) {
        int[] nums = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(binSearch1(nums,11));
        System.out.println(binSearch2(nums,0,nums.length-1,11));
    }

    public static int binSearch1(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int mid = 0;
        while(start <= end){
            mid = (start+end)>>1;
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else if((mid -1) > 0 && nums[mid] == nums[mid -1]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return  -1;
    }

    // 二分查找递归实现
    public static int binSearch2(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch2(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch2(srcArray, start, mid - 1, key);
        }
        return -1;
    }
}
