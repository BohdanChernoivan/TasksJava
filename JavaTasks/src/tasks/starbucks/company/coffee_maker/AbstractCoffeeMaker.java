package tasks.starbucks.company.coffee_maker;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.product.IngredientStorage;

public abstract class AbstractCoffeeMaker {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean makeCoffee(IngredientStorage storage, CoffeeType coffeeType) {

        return false;
    }
}
