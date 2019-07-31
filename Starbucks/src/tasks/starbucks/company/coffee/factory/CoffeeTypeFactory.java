package tasks.starbucks.company.coffee.factory;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee.coffee_drinks.Americano;
import tasks.starbucks.company.coffee.coffee_drinks.BaseCoffee;
import tasks.starbucks.company.coffee.coffee_drinks.Espresso;
import tasks.starbucks.company.coffee.coffee_drinks.Latte;

public class CoffeeTypeFactory {


    public BaseCoffee choiceCoffeeType(CoffeeType coffeeType, boolean sugar) {


        if (coffeeType.equals(CoffeeType.AMERICANO)) {
            return createAmericano(sugar);
        } else if (coffeeType.equals(CoffeeType.ESPRESSO)) {
            return createEspresso(sugar);
        } else if (coffeeType.equals(CoffeeType.LATTE)) {
            return createLatte(sugar);
        } else return null;

    }

    public Americano createAmericano(boolean sugar) {
        if (sugar) {
            return new Americano(2, 2, 0, 1, 1);
        }
        else {
            return new Americano(2, 2, 0, 1, 0);
        }
    }

    public Espresso createEspresso(boolean sugar) {
        if (sugar) {
            return new Espresso(1, 2, 0, 1, 1);
        } else {
            return new Espresso(1, 2, 0, 1, 1);
        }
    }

    public Latte createLatte(boolean sugar) {
        if (sugar) {
            return new Latte(1, 1, 1, 1, 1);
        }
        else {
            return new Latte(1, 1, 1, 1, 1);
        }
    }
}
