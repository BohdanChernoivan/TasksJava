package tasks.starbucks;

import tasks.starbucks.company.Starbucks;
import tasks.starbucks.customers.Customer;
import tasks.starbucks.customers.RandomizeCustomer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>(new RandomizeCustomer().manyCustomers(100));

        Starbucks starbucks = new Starbucks();

        for (Customer customer : customerList) {
            starbucks.sellCoffee(customer);
        }

        starbucks.income();

    }
}
