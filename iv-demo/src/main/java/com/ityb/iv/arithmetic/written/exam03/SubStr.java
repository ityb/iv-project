package com.ityb.iv.arithmetic.written.exam03;

/**
 * ���ֽ�����ȡ����
 * @author Administrator
 *
 */
public class SubStr {
	
	//�ж�һ���ַ��Ƿ��Ǻ���
	public static  boolean isZh(char c){
		String s = String.valueOf(c);
		return s.getBytes().length>1? true:false;
	}
	//��ȡ�ַ���
	public static String subString(String s,int num){
		if(num<=0){
			return null;
		}
		int index=0;
		int byteCount=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(!isZh(c)){//���Ǻ���
				index++;
				byteCount++;
			}else{
				if(byteCount+2<=num){
					index++;
					byteCount+=2;
				}else{
					break;
				}
			}
			if(byteCount>=num){
				break;
			}
		}
		System.out.println("byteCount="+byteCount + "index="+index);
		if(index<=0){
			return null;
		}
		return s.substring(0,index);
	}
	
	public static void main(String[] args) {
		System.out.println(SubStr.subString("��ABC��DEF���˵���", 55));
	}
	
}
