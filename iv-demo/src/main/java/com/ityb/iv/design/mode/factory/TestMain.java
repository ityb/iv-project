package com.ityb.iv.design.mode.factory;

/**
 * Created by viruser on 2020/5/15.
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractFactory foodFactory=FactoryProducer.getFactory(1);
        Food pork = foodFactory.createFood(1);
        pork.name();
        Food  beef= foodFactory.createFood(2);
        beef.name();

        AbstractFactory fruitFactory=FactoryProducer.getFactory(2);
        Fruit apple = fruitFactory.createFruit(1);
        apple.name();
        Fruit  pear= fruitFactory.createFruit(2);
        pear.name();
    }
}
