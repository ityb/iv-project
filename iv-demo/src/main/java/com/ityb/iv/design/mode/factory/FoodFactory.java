package com.ityb.iv.design.mode.factory;

/**
 * Created by viruser on 2020/5/15.
 */
public class FoodFactory extends AbstractFactory {
    @Override
    Food createFood(Integer type) {
        Food food = null;
        switch (type) {
            case 1:
                food = new Pork();
                break;
            case 2:
                food = new Beef();
                break;
        }
        return food;
    }

    @Override
    Fruit createFruit(Integer type) {
        return null;
    }
}
