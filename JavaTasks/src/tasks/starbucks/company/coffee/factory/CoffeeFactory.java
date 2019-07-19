package tasks.starbucks.company.coffee.factory;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee.coffee_drinks.BaseCoffee;

public interface CoffeeFactory {

    default BaseCoffee createCoffee(CoffeeType coffeeType) { return null; }
}
