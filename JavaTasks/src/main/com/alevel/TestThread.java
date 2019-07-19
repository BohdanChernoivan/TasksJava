package main.com.alevel;

public class TestThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Hello to new thread world " +i++);
        }
    }
}
