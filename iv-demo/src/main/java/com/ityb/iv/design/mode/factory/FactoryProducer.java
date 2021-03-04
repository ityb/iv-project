package com.ityb.iv.design.mode.factory;

/**
 * Created by viruser on 2020/5/15.
 */
public class FactoryProducer {

    static AbstractFactory getFactory(Integer type){
        switch (type){
            case 1:
                return new FoodFactory();
            case 2:
                return new FruitFactory();
        }
        return null;
    }
}
