package tasks.starbucks.customers;

public interface Payment {

    void card(int needMoney);

    void cash(int needMoney);
}
