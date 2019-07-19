package tasks.starbucks.company.coffee_maker;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.product.IngredientStorage;

public class Barista extends AbstractCoffeeMaker {

    private String name = "Barista";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean makeCoffee(IngredientStorage storage, CoffeeType coffeeType) {


        return false;
    }
}
