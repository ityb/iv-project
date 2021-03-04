package com.ityb.iv.arithmetic.sort;

public class InsertSort {
    public static void main(String[] args) {
        int array[]={1,3,4,9,5,6,8,2,7,10};
        sort(array);
        printArray(array);
    }

    private static void sort(int array[]){
        for (int i=1;i<array.length;i++){
            for (int j=i;j>0 && array[j]<array[j-1];j--){
                swap(array,j,j-1);
            }
        }
    }

    private static void swap(int array[],int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    private static void printArray(int array[]){
        for (int item:array){
            System.out.print(item+" ");
        }
    }
}
