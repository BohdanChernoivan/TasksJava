import labyrinth.TheLabyrinth;


public class Main {
    public static void main(String[] args) {

        System.out.println("Theseus, good luck");

        TheLabyrinth theLabyrinth = new TheLabyrinth(15);

        theLabyrinth.createLabyrinth();

        theLabyrinth.showLabyrinth();
    }
}
