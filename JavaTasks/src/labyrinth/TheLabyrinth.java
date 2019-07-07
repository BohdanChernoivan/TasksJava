package labyrinth;

import java.util.Random;

public class TheLabyrinth implements LabyrinthRealization {

    private Random random = new Random();

    private String[][] array;

    public TheLabyrinth(int sizeArray) {
        array = new String[sizeArray][sizeArray];
    }

    @Override
    public void createLabyrinth() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextBoolean() ?
                        LabyrinthPoint.FREECELL.getItem() :
                        LabyrinthPoint.WALL.getItem() ;
            }
        }
    }

    @Override
    public void showLabyrinth() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public void passingTheLabyrinth() {

    }

}
