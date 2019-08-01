package tasks.starbucks.company;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee.Cost;
import tasks.starbucks.company.coffee_maker.AbstractCoffeeMaker;
import tasks.starbucks.company.coffee_maker.Barista;
import tasks.starbucks.company.coffee_maker.CoffeeMachine;
import tasks.starbucks.company.product.IngredientStorage;
import tasks.starbucks.customers.Customer;

public class Starbucks {

    private static final int PRODUCTS_IN_STORAGE = 70;
    private static final double CHANCE = 0.2;

    private static int accountant = 0;

    AbstractCoffeeMaker barista = new Barista();
    AbstractCoffeeMaker machine = new CoffeeMachine();
    IngredientStorage storage = new IngredientStorage(PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE, PRODUCTS_IN_STORAGE);

    public void sellCoffee(Customer customer) {

        if (isMakeCoffeeType(customer.getCoffeeWant(), customer.isWantSugar())) {
        if (customer.getMoney() >= new Cost(customer.getCoffeeWant()).returnCost()) {
            makeCoffeeType(customer.getCoffeeWant(), customer.isWantSugar());
            customer.wantPayment(new Cost(customer.getCoffeeWant()).returnCost());
            System.out.println("Type coffee = " + customer.getCoffeeWant() + ", sold out " + customer.getName());
            accountant += new Cost(customer.getCoffeeWant()).returnCost();
        } else {
            System.out.println("The " + customer.getName() + " did not have enough " + customer.getCoffeeWant());
        }
        } else {
            System.out.println("Not enough ingredients");
        }
    }

    public int income() {
        return accountant;
    }

    private boolean isMakeCoffeeType(CoffeeType coffeeType, boolean sugar) {
            return barista.isMakeCoffee(storage, coffeeType, sugar);
    }

    private void makeCoffeeType(CoffeeType coffeeType, boolean sugar) {

        if(Math.random() >= CHANCE) {
            System.out.println(machine.getName());
            machine.makeCoffee(storage, coffeeType, sugar);
        } else {
            System.out.println(barista.getName());
            barista.makeCoffee(storage, coffeeType, sugar);
        }
    }
}
