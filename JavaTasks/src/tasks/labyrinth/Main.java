package tasks.labyrinth;

import tasks.labyrinth.logic.TheLabyrinthRealization;

public class Main {
    public static void main(String[] args) {

        System.out.println("Theseus, good luck");

        TheLabyrinthRealization theLabyrinth = new TheLabyrinthRealization(15);

        theLabyrinth.createLabyrinth();

        theLabyrinth.showLabyrinth();

        System.out.println();

        System.out.println(theLabyrinth.passingTheLabyrinth());

        theLabyrinth.showLabyrinth();
    }
}
