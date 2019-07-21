package tasks.starbucks.company.coffee_maker;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee.coffee_drinks.BaseCoffee;
import tasks.starbucks.company.coffee.factory.CoffeeTypeFactory;
import tasks.starbucks.company.product.IngredientStorage;

public class CoffeeMachine extends AbstractCoffeeMaker {

    private String name = "Coffee machine";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean makeCoffee(IngredientStorage storage, CoffeeType coffeeType, boolean sugar) {

        BaseCoffee baseCoffee = new CoffeeTypeFactory().choiceCoffeeType(coffeeType, sugar);

        int needSugar;

        if (sugar) {
            needSugar = 1;
        } else
            needSugar = 0;

        return interactionOfStorageWithTheBaseCoffee(storage, baseCoffee, needSugar);
    }
}
