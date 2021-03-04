package com.ityb.iv.design.mode.dynamicProxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viruser on 2020/4/14.
 */
public class MapperProxy<T> implements InvocationHandler{

    private Class<T> mapperInterface;

    public MapperProxy(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("queryUser")){
            List<UserEntity> resultList=new ArrayList<UserEntity>();
            for(int i=0;i<10;i++){
                UserEntity userEntity=new UserEntity();
                userEntity.setId((long)i);
                userEntity.setUserName("yangbin"+i);
                resultList.add(userEntity);
            }
            return resultList;
        }else if(method.getName().equals("getOne")){
            UserEntity userEntity=new UserEntity();
            userEntity.setId((long)1);
            userEntity.setUserName("yangbin");
            return userEntity;
        }
        return null;
    }

    public T getProxy(){
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},this);
    }
}
