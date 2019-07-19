package tasks.starbucks.company.product;

public class IngredientStorage {

    private int water;
    private int coffeeBeans;
    private int milk;
    private int cup;
    private int sugar;

    public IngredientStorage() {
    }

    public IngredientStorage(int water, int coffeeBeans, int milk, int cup, int sugar) {
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.milk = milk;
        this.cup = cup;
        this.sugar = sugar;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
}
