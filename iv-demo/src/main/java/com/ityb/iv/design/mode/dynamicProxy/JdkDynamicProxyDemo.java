package com.ityb.iv.design.mode.dynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by viruser on 2020/5/15.
 */
public class JdkDynamicProxyDemo {

   static interface PersonService{

        int countPerson();
    }

    static class PersonServiceImpl implements PersonService {

        @Override
        public int countPerson() {
            return 10;
        }
    }

    static class PersonServiceProxy implements InvocationHandler{

        private PersonService personService;

        public PersonServiceProxy(PersonService personService) {
            this.personService = personService;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("执行"+method.getName()+"方法");
            return method.invoke(personService,args);
        }
    }

    public static void main(String[] args) throws Exception{
//        PersonService personService=new PersonServiceImpl();
//        PersonService proxyInstance = (PersonService)Proxy.newProxyInstance(personService.getClass().getClassLoader(), personService.getClass().getInterfaces(), new PersonServiceProxy(personService));
//        System.out.println(proxyInstance.countPerson());
        String proxyName="com.ityb.springboot.mybatis.demo.dynamicProxy.$Proxy0";
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyName, new Class[]{PersonService.class}, 16);
        OutputStream fos = new FileOutputStream(new File("D://txt.class"));
        fos.write(proxyClassFile);
        fos.flush();
   }
}
