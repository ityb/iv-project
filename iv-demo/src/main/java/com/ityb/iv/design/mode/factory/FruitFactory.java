package com.ityb.iv.design.mode.factory;

/**
 * Created by viruser on 2020/5/15.
 */
public class FruitFactory extends AbstractFactory {
    @Override
    Food createFood(Integer type) {
        return null;
    }

    @Override
    Fruit createFruit(Integer type) {
        Fruit fruit = null;
        switch (type) {
            case 1:
                fruit = new Apple();
                break;
            case 2:
                fruit = new Pear();
                break;
        }
        return fruit;
    }
}
