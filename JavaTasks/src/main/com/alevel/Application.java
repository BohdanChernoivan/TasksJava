package main.com.alevel;

public class Application {

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new TestThread();

        Thread thread = new Thread(new TestThread2());
        thread.setDaemon(true);
        thread.start();

        long start = System.currentTimeMillis();
        while (thread.isAlive()) {
            System.out.println("Die");
        }
//        Thread.currentThread().sleep(100);
        thread.join();
        System.out.println(System.currentTimeMillis() - start);
    }
}
