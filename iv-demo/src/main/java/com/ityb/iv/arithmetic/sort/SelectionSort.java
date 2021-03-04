package com.ityb.iv.arithmetic.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int array[]={1,3,4,9,5,6,8,2,7,10};
        sort(array);
        printArray(array);
    }

    private static void sort(int array[]){
        for (int i=0;i<array.length-1;i++){
            int tempIndex=i;
            for (int j=i+1;j<array.length;j++){
                tempIndex=array[j]<array[tempIndex]?j:tempIndex;
            }
            swap(array,i,tempIndex);
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
