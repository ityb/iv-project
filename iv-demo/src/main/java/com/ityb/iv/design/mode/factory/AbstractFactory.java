package com.ityb.iv.design.mode.factory;

/**
 * Created by viruser on 2020/5/15.
 */
public abstract class AbstractFactory {

    abstract Food createFood(Integer type);

    abstract Fruit createFruit(Integer type);

}
