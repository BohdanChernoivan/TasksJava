package tasks.tamagochi;

import java.util.Scanner;

public class Tamagochi {

    private static final int MAX = 100;
    private static final int LOW = 30;

    Thread defectEat;
    Thread defectSleep;
    Thread defectCrap;
    Thread defectPlay;

    Scanner scanner;

    public Tamagochi() {
        scanner = new Scanner(System.in);

        defectEat = new DefectEat();
        defectSleep = new DefectSleep();
        defectCrap = new DefectCrap();
        defectPlay = new DefectPlay();

    }

    private int pointEat = MAX;
    private int pointSleep = MAX;
    private int pointCrap = MAX;
    private int pointPlay = MAX;


    void eat() {
        pointEat = MAX;
    }

    void sleep() {
        pointSleep = MAX;
    }

    void crap() {
        pointCrap = MAX;
    }

    void play() {
        pointPlay = MAX;
    }

    public boolean isAlive() {
        return pointEat > 0 && pointSleep > 0 && pointCrap > 0 && pointPlay > 0;
    }

    private void choice() {

        String include = scanner.nextLine();

            switch (include) {
                case "1":
                    eat();
                    break;
                case "2":
                    sleep();
                    break;
                case "3":
                    crap();
                    break;
                case "4":
                    play();
                    break;
        }
    }

    public void start() {
        defectEat.start();
        defectSleep.start();
//        defectCrap.start();
//        defectPlay.start();
    }

    public class DefectEat extends Thread {

        @Override
        public void run() {
            while (Tamagochi.this.isAlive()) {
                if (pointEat < LOW) {
                    System.out.println("Need eat, enter 1");
                    choice();
                }
                    System.out.println("Want eat = " + pointEat);
                    pointEat--;
            }
        }
    }

    public class DefectSleep extends Thread {

        @Override
        public void run() {
            while (Tamagochi.this.isAlive()) {
                if (pointSleep < LOW) {
                    System.out.println("Need sleep, enter 2");
                    choice();
                }
                    System.out.println("Want sleep = " + pointSleep);
                    pointSleep--;
            }
        }
    }

    public class DefectCrap extends Thread {

        @Override
        public void run() {
            while (Tamagochi.this.isAlive()) {
                if (pointCrap < LOW) {
                    System.out.println("Need crap, enter 3");
                    choice();
                }
                    System.out.println("Want crap = " + pointCrap);
                    pointCrap--;
            }
        }
    }

    public class DefectPlay extends Thread {

        @Override
        public void run() {
            while (Tamagochi.this.isAlive()) {
                if (pointPlay < LOW) {
                    System.out.println("Need play, enter 4");
                    choice();
                }
                    System.out.println("Want play = " + pointPlay);
                    pointPlay--;
            }
        }
    }
}
