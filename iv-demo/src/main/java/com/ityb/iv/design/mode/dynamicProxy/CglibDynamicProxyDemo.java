package com.ityb.iv.design.mode.dynamicProxy;//package com.ityb.design.mode.dynamicProxy;
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * Created by viruser on 2020/5/15.
// */
//public class CglibDynamicProxyDemo {
//
//    static interface ManService{
//
//        int countMan();
//    }
//
//    static class ManServiceImpl implements ManService {
//
//        @Override
//        public int countMan() {
//            return 50;
//        }
//    }
//    static class MyMethodInterceptor implements MethodInterceptor {
//
//        /**
//         * sub：cglib生成的代理对象
//         * method：被代理对象方法
//         * objects：方法入参
//         * methodProxy: 代理方法
//         */
//        @Override
//        public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//            System.out.println("======插入前置通知======");
//            Object object = methodProxy.invokeSuper(sub, objects);
//            System.out.println("======插入后者通知======");
//            return object;
//        }
//    }
//    public static void main(String[] args) {
//        // 代理类class文件存入本地磁盘方便我们反编译查看源码
//        Enhancer enhancer = new Enhancer();
//        // 设置enhancer对象的父类
//        enhancer.setSuperclass(ManServiceImpl.class);
//        // 设置enhancer的回调对象
//        enhancer.setCallback(new MyMethodInterceptor());
//        // 创建代理对象
//        ManService proxy= (ManService)enhancer.create();
//        // 通过代理对象调用目标方法
//        System.out.println(proxy.countMan());
//    }
//}
