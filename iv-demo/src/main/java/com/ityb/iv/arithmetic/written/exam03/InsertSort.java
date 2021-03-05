package com.ityb.iv.arithmetic.written.exam03;

/**
 * 插入排序
 */
public class InsertSort {
	public static   void sort(int array[]){
		if(array==null||array.length<=0){
			return;
		}
		for(int i=1;i<array.length;i++){
			int temp=array[i];
			int j=i;
			if(array[j-1]>temp){
				while(j>=1&&array[j-1]>temp){
					array[j]=array[j-1];
					j--;
				}
			}
			array[j]=temp;
		}
	}
	public static void main(String[] args) {
		int array[]={7,3,9,2,10,-8};
		InsertSort.sort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
}
