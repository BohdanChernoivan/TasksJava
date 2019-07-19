package tasks.starbucks.company;

import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.company.coffee_maker.AbstractCoffeeMaker;
import tasks.starbucks.company.coffee_maker.Barista;
import tasks.starbucks.company.coffee_maker.CoffeeMachine;
import tasks.starbucks.company.product.IngredientStorage;
import tasks.starbucks.customers.Customer;

public class Starbucks {

    AbstractCoffeeMaker barista = new Barista();
    AbstractCoffeeMaker machine = new CoffeeMachine();
    IngredientStorage storage = new IngredientStorage();

    public void sellCoffee(Customer customer) {

        if (makeCoffeeType(customer.getCoffeeWant())) {
        if (customer.getMoney() >= customer.getCoffeeWant().getCost()) {
            customer.setMoney(customer.getMoney() - customer.getCoffeeWant().getCost());
            System.out.println("Тип кофе = " + customer.getCoffeeWant() + ", продано покупателю под именем " + customer.getName());
        } else {
            System.out.println("У покупателя под именем " + customer.getName() + " не хватило денег на " + customer.getCoffeeWant());
        }
        } else {
            System.out.println("Нету ингридиентов");
        }
    }

    private boolean makeCoffeeType(CoffeeType coffeeType) {

        if(Math.random() >= 0.5) {
            return machine.makeCoffee(storage, coffeeType);
        } else {
            return barista.makeCoffee(storage, coffeeType);
        }
    }
}
