package com.ityb.iv.arithmetic.written.exam07.intersection;

import java.util.ArrayList;
import java.util.List;
/**
 * ���н��ʲ���
 * 
 * @author Administrator
 *
 */
public class Intersection {
	public static List<MySet> doIntersection(List<MySet> list1, List<MySet> list2) {
		List<MySet> mySetList = new ArrayList<MySet>();
		if (list1 == null) {
			return mySetList;
		}
		if (list2 == null) {
			return mySetList;
		}
		int i = 0, j = 0;
		while (i < list1.size() && j < list2.size()) {
			MySet mySet1=list1.get(i);
			MySet mySet2=list2.get(j);
			int list1Min = mySet1.getMin();
			int list1Max =mySet1.getMax();
			int list2Min = mySet2.getMin();
			int list2Max = mySet2.getMax();
			if (list1Min < list2Min) {
				if (list1Max < list2Min) {// ������i,j��û�н������� i+1��j�����ܳ��ֽ���
					i++;
				} else if (list1Max >= list2Min) {// ���ڽ���[list2Min,list1Max]
					mySetList.add(new MySet(list2Min, list1Max));
					i++;
				} else {// ����list2��list1���Ӽ�
					mySetList.add(new MySet(list2Min, list2Max));
					j++;
				}
			} else if (list1Min <= list2Max) {// ֻ�е�list1����СֵС��list2�е����ֵ��ʱ��Ż���ֽ���
				if (list1Max < list2Max) {// list1��list2���Ӽ�
					mySetList.add(new MySet(list1Min, list1Max));
					i++;
				} else {
					mySetList.add(new MySet(list1Min, list2Max));
					j++;
				}
			} else {// ���ཻ
				j++;
			}
		}
		return mySetList;
	}

	public static void main(String[] args) {
		List<MySet> list1 = new ArrayList<MySet>();
		list1.add(new MySet(4, 8));
		list1.add(new MySet(9, 13));
		List<MySet> list2 = new ArrayList<MySet>();
		list2.add(new MySet(6, 12));
		List<MySet> list = Intersection.doIntersection(list1, list2);
		for (MySet mySet : list) {
			System.out.println("["+mySet.getMin()+","+mySet.getMax()+"]");
		}
	}
}
