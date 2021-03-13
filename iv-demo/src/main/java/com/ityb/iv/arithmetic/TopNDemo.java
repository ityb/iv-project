package com.ityb.iv.arithmetic;

public class TopNDemo {

    public static void main(String[] args) {
        int a[] = {1,3,5,2,2};
        System.out.println(findKth(a,5,3));
    }

    public static int findKth(int[] a, int n, int K) {
        int index = parttion(a,0,a.length-1);
        while (index != K) {
            if (index > K) {
                index = parttion(a, 0, index - 1);
            } else {
                index = parttion(a, index + 1, a.length - 1);
            }
        }
        return a[index-1];
    }

    public static int parttion(int a[],int left,int right){
        int i = left;
        int j = right-1;
        int base = a[right];
        while(i<=j){
            while(i<=j && a[i] <= base){
                i++;
            }
            while(i<=j && a[j] > base){
                j--;
            }
            if ( i < j){
                swap(a,i,j);
            }
        }
        swap(a,i,right);
        return i;
    }
    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
