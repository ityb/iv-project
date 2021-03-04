package com.ityb.iv.arithmetic.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author Administrator
 *
 */
public class HeapSort {
	public static void HeapAdjust(int[] array, int parent, int length) {
		int temp = array[parent]; // temp保存当前父节点
		int child = 2 * parent + 1; // 先获得左孩子

		while (child < length) {
			// 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			if (child + 1 < length && array[child] < array[child + 1]) {
				child++;
			}

			// 如果父结点的值已经大于孩子结点的值，则直接结束
			if (temp >= array[child])
				break;

			// 把孩子结点的值赋给父结点
			array[parent] = array[child];

			// 选取孩子结点的左孩子结点,继续向下筛选
			parent = child;
			child = 2 * child + 1;
		}

		array[parent] = temp;
	}

	public static void sort(int[] array) {
		// 循环建立初始堆
		for (int i = array.length / 2; i >= 0; i--) { // i=array.length的目的是定位到
			// 最后一个叶子结点的父结点 依次向上调整
			HeapAdjust(array, i, array.length);
		}

		// 进行n-1次循环，完成排序 每次都是顶！顶堆与最后一个元素交换，然后在调整堆
		for (int i = array.length - 1; i > 0; i--) {
			// 最后一个元素和第一元素进行交换
			swap(array,i,0);

			// 筛选 R[0] 结点，得到i-1个结点的堆
			HeapAdjust(array, 0, i);
			System.out.format("第 %d 趟: \t", array.length - i);
			System.out.println(Arrays.toString(array));
		}
	}

	private static void swap(int array[],int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}

	public static void main(String[] args) {
		int array[] = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0, 78, -7, 5 };
		HeapSort.sort(array);

	}
}
