package main.com.alevel;

public class TestThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello to new thread world " + i);
        }
    }
}
