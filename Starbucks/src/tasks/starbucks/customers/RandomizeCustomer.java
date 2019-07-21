package tasks.starbucks.customers;

import tasks.starbucks.company.coffee.CoffeeType;

import java.util.ArrayList;
import java.util.Random;

public class RandomizeCustomer {

    private static final int MAX_NUMBER = 50;

    private Random random = new Random();

    public Customer randomCustomer() {
        return new Customer(name().get(getRandomNumber()), getRandomCoffeeType(), getRandomNumber(), randomWantSugar());
    }

    public ArrayList<Customer> manyCustomers(int numberCustomers) {
        ArrayList<Customer> customerList = new ArrayList<>();

        for (int i = 0; i < numberCustomers; i++) {
            customerList.add(new RandomizeCustomer().randomCustomer());
        }

        return customerList;
    }

    private int getRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }

    private boolean randomWantSugar() {
        if(Math.random() >= 0.5) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<String> name() {

        ArrayList<String> arrayName = new ArrayList<String>();

        for (int i = 1; i <= MAX_NUMBER; i++) {
            String rndName = "Customer[" + i + "]";

            arrayName.add(rndName);
        }

        return arrayName;
    }


    private CoffeeType getRandomCoffeeType() {

        CoffeeType[] arrayCoffeeType = {CoffeeType.AMERICANO, CoffeeType.ESPRESSO, CoffeeType.LATTE};

        int randomIntInCoffeeType = random.nextInt(arrayCoffeeType.length);

        return arrayCoffeeType[randomIntInCoffeeType];
    }
}
