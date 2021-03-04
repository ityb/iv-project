package com.ityb.iv.arithmetic.written.exam03;
/**
 * ��������
 * @author Administrator
 *
 */
public class InsertSort {
	public static   void sort(int array[]){
		if(array==null||array.length<=0){
			return;
		}
		for(int i=1;i<array.length;i++){
			int temp=array[i];//����һ���м����������ÿ����Ҫ�����ֵ
			int j=i;//����һ������ָ��
			if(array[j-1]>temp){//�����ж�ǰһ���Ƿ�������ڲ����ֵ
				while(j>=1&&array[j-1]>temp){
					array[j]=array[j-1];//��ֵ�����
					j--;//ָ����ǰɨ
				}
			}
			//���в���
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
