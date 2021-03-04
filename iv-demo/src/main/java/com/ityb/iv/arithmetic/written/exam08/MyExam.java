package com.ityb.iv.arithmetic.written.exam08;

public class MyExam {
	public static int getMinPath(int array[][]) {
		if (array == null) {
			return 0;
		}
		if (array.length == 0) {
			return 0;
		}
		int row = array.length;
		int col = array[0].length;
		int cache[][] = new int[row][col]; // ����һ��������������¼ÿһ���Ѿ��߹���·��
		cache[0][0] = array[0][0];
		for (int i = 1; i < row; i++) {// ��һ�е�ֵӦ����ԭ����һ��
			cache[i][0] = cache[i-1][0]+array[i][0];
		}
		for (int i = 1; i < col; i++) {// ��һ�е�ֵӦ����ԭ����һ��
			cache[0][i] = cache[0][i-1]+array[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (cache[i - 1][j] > cache[i][j - 1]) {// �����ÿո���Ͻ�������
					cache[i][j] = cache[i][j - 1] + array[i][j];
					System.out.print("["+i+","+(j-1)+"] ");
				} else {
					cache[i][j] = cache[i - 1][j] + array[i][j];
					System.out.print("["+(i-1)+","+j+"] ");
				}
			}
		}
		System.out.println("["+(row-1)+","+col+"]");
		return cache[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int array[][] = new int[][] { { 1,4,3}, {8,7,5 }, {2,1,5 } };
		System.out.print("path:");
		System.out.println("MinValue:"+MyExam.getMinPath(array));
	}
}
