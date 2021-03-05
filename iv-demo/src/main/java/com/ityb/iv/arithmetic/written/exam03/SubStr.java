package com.ityb.iv.arithmetic.written.exam03;

/**
 *
 *
 * @author Administrator
 */
public class SubStr {

    public static boolean isZh(char c) {
        String s = String.valueOf(c);
        return s.getBytes().length > 1 ? true : false;
    }

    public static String subString(String s, int num) {
        if (num <= 0) {
            return null;
        }
        int index = 0;
        int byteCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isZh(c)) {
                index++;
                byteCount++;
            } else {
                if (byteCount + 2 <= num) {
                    index++;
                    byteCount += 2;
                } else {
                    break;
                }
            }
            if (byteCount >= num) {
                break;
            }
        }
        System.out.println("byteCount=" + byteCount + "，index=" + index);
        if (index <= 0) {
            return null;
        }
        return s.substring(0, index);
    }

    public static void main(String[] args) {
        System.out.println(SubStr.subString("ABBAB我BA是一个中国人", 55));
    }

}
