package com.ityb.iv.arithmetic.sort;

public class QuickSort {

    public static void main(String[] args) {
        int array[]={1,3,4,9,5,6,8,2,7,10};
        sort(array,0,array.length-1);
        printArray(array);
    }

    private static void sort(int array[],int left,int right){
        if(left>=right) return;
        int partition = partition(array, left, right);
        sort(array,left,partition-1);
        sort(array,partition+1,right);
    }


    private static int partition(int array[], int leftIndex, int rightIndex){
        if(leftIndex>rightIndex) return leftIndex;
        int i=leftIndex;
        int j=rightIndex-1;
        int temp=array[rightIndex];
        while (i<=j){
            while (i<=j&&array[i]<=temp){
                i++;
            }
            while (i<=j&&array[j]>temp){
                j--;
            }
            if(i<j){
                swap(array,i,j);
            }
        }
        swap(array,i,rightIndex);
        return i;
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
