package com.ityb.iv.design.mode.dynamicProxy.proxy;

import java.util.List;

/**
 * Created by viruser on 2020/4/14.
 */
public class ProxyTest {
    public static void main(String[] args) {
        MapperProxy mapperProxy = new MapperProxy(MapperInterface.class);
        MapperInterface mapperInterface = (MapperInterface) mapperProxy.getProxy();
        UserEntity one = mapperInterface.getOne();
        System.out.println(one);
        List<UserEntity> list = mapperInterface.queryUser();
        System.out.println(list);
    }
}
