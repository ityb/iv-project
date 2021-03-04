package com.ityb.iv.arithmetic.written.exam05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ����ʽ�̰߳�ȫ����
 * @author Administrator
 *
 */
public class Singleton02 {

	private static Singleton02 sington02 = null;
	private static Lock lock = new ReentrantLock();

	private Singleton02() {

	}

	public static Singleton02 getInstance() {
		if (sington02 == null) {
			lock.lock();
			try {
				if(sington02==null){
					sington02=new Singleton02();
					return sington02;
				}
				return sington02;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		return sington02;
	}

	public static void main(String[] args) {
		System.out.println(Singleton02.getInstance().hashCode());
		System.out.println(Singleton02.getInstance().hashCode());
	}

}
