package tasks.starbucks.company.coffee;

public class Cost {


    private CoffeeType coffeeType;

    public Cost(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int returnCost() {

        switch (coffeeType) {

            case AMERICANO:
                return 20;
            case ESPRESSO:
                return 10;
            case LATTE:
                return 15;
            default:
                return 0;

        }
    }
}
