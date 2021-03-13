package com.ityb.iv.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 */
public class MaxSubstringLength {
    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 4, 3,};
        System.out.println(maxLength(arr));
    }

    public static int maxLength(int[] arr) {
        int start = 0;
        int end = -1;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) >= start) {
                start = map.get(arr[i]) + 1;
            }
            map.put(arr[i], i);
            end++;
            int curLen = end - start + 1;
            if ( curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
}
