package tasks.labyrinth.logic;

import tasks.labyrinth.details.CheckPassingLabyrinth;
import tasks.labyrinth.details.LabyrinthPoint;
import tasks.labyrinth.base.LabyrinthRealization;

import java.util.Random;

public class TheLabyrinthRealization extends LabyrinthRealization implements CheckPassingLabyrinth<Integer, Integer, LabyrinthPoint> {

    private Random random = new Random();

    private String[][] array;

    private int row = 0;
    private int column = 0;

    public TheLabyrinthRealization(int sizeArray) {
        array = new String[sizeArray][sizeArray];
    }

    @Override
    public void createLabyrinth() {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextBoolean() ?
                        LabyrinthPoint.FREE_WAY.getItem() :
                        LabyrinthPoint.WALL.getItem();
            }
        }

        createRandomCharInArray(array.length-1, LabyrinthPoint.ENTRY);
        createRandomCharInArray(array.length-1, LabyrinthPoint.MINOTAUR);
        createRandomCharInArray(array.length-1, LabyrinthPoint.EXIT);

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

    /**
     * does not always work correctly
     */
    @Override
    public boolean passingTheLabyrinth() {

        foundEntry();

        row:
        for (int i = row; i < array.length; i++) {
            column:
            for (int j = column; j < array[i].length; j++) {

                if (checkToLeft(i,j, LabyrinthPoint.FREE_WAY)) {
                    System.out.println("LEFT");
                    array[i][j - 1] = LabyrinthPoint.THESEUS.getItem();
                    j -= 2;
                    continue column;
                } else if (checkToTop(i, j, LabyrinthPoint.FREE_WAY)) {
                    System.out.println("TOP");
                    array[i - 1][j] = LabyrinthPoint.THESEUS.getItem();
                    i -= 2;
                    continue row;
                } else if (checkToRight(i, j, LabyrinthPoint.FREE_WAY)) {
                    System.out.println("RIGHT");
                    array[i][j + 1] = LabyrinthPoint.THESEUS.getItem();
                    continue column;
                }
                if (checkToBottom(i, j, LabyrinthPoint.FREE_WAY)) {
                    System.out.println("BOTTOM");
                    array[i + 1][j] = LabyrinthPoint.THESEUS.getItem();
                    j--;
                    continue row;
                } else {
                    System.out.println("EXIT");
                    System.out.println(array[i][j]);
                    return false;
                }
            }
        }

        return false;
    }

    private void createRandomCharInArray(int maxSizeArray ,LabyrinthPoint labyrinthPoint) {

        int rndRow = random.nextInt(maxSizeArray);
        int rndColumn = random.nextInt(maxSizeArray);

        array[rndRow][rndColumn] = labyrinthPoint.getItem();
    }


    @Override
    public boolean checkToLeft(Integer row, Integer column, LabyrinthPoint labyrinthPoint) {
        column -= 1;
        if (column - 1 >= 0) {
            if (array[row][column].equals(labyrinthPoint.getItem())) {
                return true;
            } else if (array[row][column].equals(LabyrinthPoint.MINOTAUR.getItem())) {
                System.out.println("You LOSE");
                return false;
            } else if (array[row][column].equals(LabyrinthPoint.EXIT.getItem())) {
                System.out.println("You WIN");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean checkToRight(Integer row, Integer column, LabyrinthPoint labyrinthPoint) {
        column += 1;
        if (column <= array.length - 1) {
            if (array[row][column].equals(labyrinthPoint.getItem())) {
                return true;
            } else if (array[row][column].equals(LabyrinthPoint.MINOTAUR.getItem())) {
                System.out.println("You LOSE");
                return false;
            } else if (array[row][column].equals(LabyrinthPoint.EXIT.getItem())) {
                System.out.println("You WIN");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean checkToTop(Integer row, Integer column, LabyrinthPoint labyrinthPoint) {
        row -= 1;
        if (row >= 0) {
            if (array[row][column].equals(labyrinthPoint.getItem())) {
                return true;
            } else if (array[row][column].equals(LabyrinthPoint.MINOTAUR.getItem())) {
                System.out.println("You LOSE");
                return false;
            } else if (array[row][column].equals(LabyrinthPoint.EXIT.getItem())) {
                System.out.println("You WIN");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean checkToBottom(Integer row, Integer column, LabyrinthPoint labyrinthPoint) {
        row += 1;
        if (row <= array.length - 1) {
            if (array[row][column].equals(labyrinthPoint.getItem())) {
                return true;
            } else if (array[row][column].equals(LabyrinthPoint.MINOTAUR.getItem())) {
                System.out.println("You LOSE");
                return false;
            } else if (array[row][column].equals(LabyrinthPoint.EXIT.getItem())) {
                System.out.println("You WIN");
                return false;
            }
        }
        return false;
    }

    private void foundEntry() {
        found:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].equals(LabyrinthPoint.ENTRY.getItem())) {
                    row = i;
                    column = j;
                    break found;
                }
            }
        }
    }
}
