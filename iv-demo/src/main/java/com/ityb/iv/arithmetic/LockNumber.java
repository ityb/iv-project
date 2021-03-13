package com.ityb.iv.arithmetic;

public class LockNumber {
    public static void main(String[] args) {
        int a[] ={0,1,2,3,4,5,7,8};
        System.out.println(solve(a));
    }

    public static int solve (int[] a) {
        // write code here
        //利用等差数列求和公式： s(n) = a[0]+ (n*(n-1)/2)*d   其中n为数组的长度 d为公差 a[0]为数组的第一项
        int n=a[a.length-1]+1;
        int total = a[0]+((n*(n-1))/2)*1;
        int sum=0;
        for(int data : a){
            sum+=data;
        }
        int sub = total - sum;
        return sub == 0? n: sub;
    }
}
