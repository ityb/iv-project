package com.ityb.iv.arithmetic.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int array[]={1,3,4,9,5,6,8,2,7,10};
        sort(array);
        printArray(array);
    }

    private static void sort(int array[]){
       for (int i=array.length-1;i>0;i--){
           for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
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
