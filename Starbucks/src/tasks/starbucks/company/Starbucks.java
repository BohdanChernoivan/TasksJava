package tasks.starbucks.company;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee_maker.AbstractCoffeeMaker;
import tasks.starbucks.company.coffee_maker.Barista;
import tasks.starbucks.company.coffee_maker.CoffeeMachine;
import tasks.starbucks.company.product.IngredientStorage;
import tasks.starbucks.customers.Customer;

public class Starbucks {

    private static final int PRODUCTS_IN_STORAGE = 90;
    private static final double CHANCE = 0.2;

    private static int accountant = 0;

    AbstractCoffeeMaker barista = new Barista();
    AbstractCoffeeMaker machine = new CoffeeMachine();
    IngredientStorage storage = new IngredientStorage(PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE);

    public void sellCoffee(Customer customer) {

        if (makeCoffeeType(customer.getCoffeeWant(), customer.isWantSugar())) {
        if (customer.getMoney() >= customer.getCoffeeWant().getCost()) {
            customer.wantPayment(customer.getCoffeeWant().getCost());
            System.out.println("Type coffee = " + customer.getCoffeeWant() + ", sold out " + customer.getName());
            accountant += customer.getCoffeeWant().getCost();
        } else {
            System.out.println("The " + customer.getName() + " did not have enough " + customer.getCoffeeWant());
        }
        } else {
            System.out.println("Not enough ingredients");
        }
    }

    public void income() {
        System.out.println("Income = " + accountant);
    }

    private boolean makeCoffeeType(CoffeeType coffeeType, boolean sugar) {

        if(Math.random() >= CHANCE) {
            System.out.println(machine.getName());
            return machine.makeCoffee(storage, coffeeType, sugar);
        } else {
            System.out.println(barista.getName());
            return barista.makeCoffee(storage, coffeeType, sugar);
        }
    }
}
