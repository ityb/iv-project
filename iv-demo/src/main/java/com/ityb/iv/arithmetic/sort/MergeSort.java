package com.ityb.iv.arithmetic.sort;

public class MergeSort {

    public static void main(String[] args) {
        int array[]={1,3,4,9,5,6,8,2,7,10};
        sort(array,0,array.length-1);
        printArray(array);
    }

    private static void sort(int array[],int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)>>1;
        sort(array,left,mid);
        sort(array, mid+1, right);
        merge(array,left,mid+1,right);
    }


    private static void merge(int array[], int leftIndex, int rightIndex,int rightBound){
        int temp[]=new int[rightBound-leftIndex+1];
        int mid=rightIndex-1;
        int i=leftIndex;
        int j=rightIndex;
        int k=0;
        while (i<=mid && j<=rightBound){
            temp[k++]=array[i]<=array[j]?array[i++]:array[j++];
        }
        while (i<=mid){
            temp[k++]=array[i++];
        }
        while (j<=rightBound){
            temp[k++]=array[j++];
        }
        for(int m=0;m<temp.length;m++){
            array[leftIndex+m]=temp[m];
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
