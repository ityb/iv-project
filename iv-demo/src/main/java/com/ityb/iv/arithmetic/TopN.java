package com.ityb.iv.arithmetic;


/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则第五小的数据是5，结果输出5
 */
public class TopN {

    public static void main(String[] args) {
        int array[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int n = topN(array, 3);
        System.out.println(n);
    }

    public static Integer topN(int array[], int k) {
        if (array.length < k) {
            return null;
        }
        int index = partition(array, 0, array.length - 1);
        while (index != k) {
            if (index > k) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        return array[k];
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
