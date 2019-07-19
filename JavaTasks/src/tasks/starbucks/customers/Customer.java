package tasks.starbucks.customers;

import tasks.starbucks.company.coffee.CoffeeType;

public class Customer implements Payment {

    String name;
    CoffeeType coffeeWant;
    int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoffeeType getCoffeeWant() {
        return coffeeWant;
    }

    public void setCoffeeWant(CoffeeType coffeeWant) {
        this.coffeeWant = coffeeWant;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void card() {

    }

    @Override
    public void cash() {

    }
}
