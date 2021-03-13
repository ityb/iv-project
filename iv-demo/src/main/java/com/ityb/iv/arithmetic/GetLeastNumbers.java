package com.ityb.iv.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int array[] = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> leastN = findLeastN(array, 10);
        leastN.stream().forEach(e -> System.out.print(e + " "));
    }

    public static ArrayList<Integer> findLeastN(int array[], int k) {
        if (array.length < k) {
            return new ArrayList<>();
        }
        int index = partition(array, 0, array.length - 1);
        while (index != k) {
            if (index > k) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(array[i]) ;
        }
        return list;
    }

    private static int partition(int array[], int left, int right) {
        if (left > right) {
            return left;
        }
        int i = left;
        int j = right - 1;
        int base = array[right];
        while (i <= j) {
            while (i <= j && array[i] <= base) {
                i++;
            }
            while (i <= j && array[j] > base) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }



}
