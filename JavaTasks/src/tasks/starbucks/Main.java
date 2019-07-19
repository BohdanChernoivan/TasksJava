package tasks.starbucks;

import tasks.starbucks.company.Starbucks;
import tasks.starbucks.company.coffee.CoffeeType;
import tasks.starbucks.customers.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.setMoney(19);
        customer.setCoffeeWant(CoffeeType.AMERICANO);
        customer.setName("Вован");

        Starbucks starbucks = new Starbucks();
        starbucks.sellCoffee(customer);

        System.out.println(customer.getMoney());
        System.out.println(CoffeeType.AMERICANO.toString());

    }
}
