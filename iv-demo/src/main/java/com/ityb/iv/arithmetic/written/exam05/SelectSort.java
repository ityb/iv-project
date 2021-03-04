package com.ityb.iv.arithmetic.written.exam05;
/**
 * ѡ������
 * @author Administrator
 * ʵ��˼·��ѡȡiΪ��׼ ��[i+1~length]��ѡ����С�������±�j
 * 			ʵ��i��j�ཻ��
 *
 */
public class SelectSort {
	public static void sort(int array[]){
		if(array==null){
			return ;
		}
		if(array.length==0){
			return ;
		}
		for(int i=0;i<array.length;i++){
			int flag=i;
			int temp=array[i];
			for(int j=i+1;j<array.length;j++){
				if(array[j]<temp){
					flag=j;
					temp=array[j];
				}
			}
			temp=array[i];
			array[i]=array[flag];
			array[flag]=temp;
		}
	}
	public static void main(String[] args) {
		int array[]={1,-5,12,0,78,-5,771,2};
		SelectSort.sort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
		
	}
}
