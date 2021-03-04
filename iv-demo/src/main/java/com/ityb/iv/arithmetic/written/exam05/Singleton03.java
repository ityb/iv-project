package com.ityb.iv.arithmetic.written.exam05;

/**
 * ʵ�����Ч�ʵĵ���ģʽ
 * 
 * @author ��
 *
 */
public class Singleton03 {
	public static class InnerClass { // ����һ����̬�ڲ��ౣ֤��ʼ����ʱ��ֻ�ܱ���ʼ��һ��
		private static Singleton03 singleton = new Singleton03();
	}

	public static Singleton03 getInstance() {
		Singleton03 singleton = InnerClass.singleton;
		return singleton;
	}
}
