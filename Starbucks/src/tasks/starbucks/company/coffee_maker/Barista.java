package tasks.starbucks.company.coffee_maker;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee.coffee_drinks.BaseCoffee;
import tasks.starbucks.company.coffee.factory.CoffeeTypeFactory;
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
    public boolean isMakeCoffee(IngredientStorage storage, CoffeeType coffeeType, boolean sugar) {

        BaseCoffee baseCoffee = new CoffeeTypeFactory().choiceCoffeeType(coffeeType, sugar);

        return interactionOfStorageWithTheBaseCoffee(storage, baseCoffee, getIntSugar(sugar));
    }

    @Override
    public void makeCoffee(IngredientStorage storage, CoffeeType coffeeType, boolean sugar) {

        BaseCoffee baseCoffee = new CoffeeTypeFactory().choiceCoffeeType(coffeeType, sugar);

        storage.setCup(storage.getCup() - baseCoffee.getCup());
        storage.setWater(storage.getMilk() - baseCoffee.getMilk());
        storage.setCoffeeBeans(storage.getCoffeeBeans());
        storage.setMilk(storage.getMilk() - baseCoffee.getMilk());
        storage.setSugar(storage.getSugar() - getIntSugar(sugar));
    }

    private int getIntSugar(boolean sugar) {

        if (sugar) {
            return 1;
        } else
            return 0;
    }
}
