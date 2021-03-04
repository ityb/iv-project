package com.ityb.iv.design.mode.dynamicProxy.proxy;

import java.util.List;

/**
 * Created by viruser on 2020/4/14.
 */
public interface MapperInterface {

    List<UserEntity> queryUser();

    UserEntity getOne();

}
