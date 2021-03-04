package com.ityb.iv.arithmetic.written.exam07.intersection;
/**
 * �Զ����һ�ּ���
 * @author Administrator
 *
 */
public class MySet {
	private Integer min;
	private Integer max;
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public MySet(Integer min, Integer max) {
		if(min>max){
			min=max-1;
		}
		this.min = min;
		this.max = max;
	}
}