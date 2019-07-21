package tasks.starbucks.customers;

import tasks.starbucks.company.coffee.CoffeeType;

public class Customer implements Payment {

    private static final double CHANCE = 0.5;

    private String name;
    private CoffeeType coffeeWant;
    private int money;
    private boolean wantSugar;


    public Customer(String name, CoffeeType coffeeWant, int money, boolean wantSugar) {
        this.name = name;
        this.coffeeWant = coffeeWant;
        this.money = money;
        this.wantSugar = wantSugar;
    }


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

    public boolean isWantSugar() {
        return wantSugar;
    }

    public void setWantSugar(boolean wantSugar) {
        this.wantSugar = wantSugar;
    }

    public void wantPayment(int money) {
        if (Math.random() >= CHANCE) {
            card(money);
        } else cash(money);
    }

    @Override
    public void card(int needMoney) {
        System.out.println("Card payment");
        setMoney(getMoney() - needMoney);
    }

    @Override
    public void cash(int needMoney) {
        System.out.println("Cash payment");
        setMoney(getMoney() - needMoney);
    }
}
