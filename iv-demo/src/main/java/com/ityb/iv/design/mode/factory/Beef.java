package com.ityb.iv.design.mode.factory;

/**
 * Created by viruser on 2020/5/15.
 */
public class Beef implements Food {
    @Override
    public void name() {
        System.out.println("牛肉");
    }

    public static void main(String[] args) {
        String a="ab";
        String b="a"+"b";
        System.out.println(a==b);


    }

}
