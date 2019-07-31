package tasks.starbucks.company.coffee;

public enum CoffeeType {

    AMERICANO(20),
    ESPRESSO(10),
    LATTE(15);

    private int cost;

    CoffeeType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
