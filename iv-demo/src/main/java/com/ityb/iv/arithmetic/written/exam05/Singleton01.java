package com.ityb.iv.arithmetic.written.exam05;

/**
 * ��Ϊ����ʽ����ģʽ
 * 
 * @author Administrator
 *
 */
public class Singleton01 {

	private static Singleton01 sington01 = new Singleton01();

	private Singleton01() {

	}
	public static Singleton01 getInstance(){
		return sington01;
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton01.getInstance().hashCode());
		System.out.println(Singleton01.getInstance().hashCode());
	}

}
