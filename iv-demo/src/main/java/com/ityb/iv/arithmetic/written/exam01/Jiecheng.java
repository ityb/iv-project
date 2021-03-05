package com.ityb.iv.arithmetic.written.exam01;

import java.util.ArrayList;
import java.util.List;


/**
 * 计算N! n的阶乘
 */
public class Jiecheng {

	public static long jisuanJC(long n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * jisuanJC(n - 1);
		}
	}
	public static void main(String[] args) {
		System.out.println(Jiecheng.jisuanJC(20));
		List<? super Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(14);
		System.out.println(list);
		
	}

}
