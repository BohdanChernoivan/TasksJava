package labyrinth;

import labyrinth.base.LabyrinthRealization;

import java.util.Random;

public class TheLabyrinthRealization extends LabyrinthRealization implements CheckPassingLabyrinth<Integer, Integer> {

    private Random random = new Random();

    private String[][] array;

    private int num1 = 0;
    private int num2 = 0;

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

    @Override
    public boolean passingTheLabyrinth() {

        foundEntry();
// TODO: RIGHT, LEFT
        row:
        for (int i = num1; i < array.length; i++) {
            column:
            for (int j = num2; j < array[i].length; j++) {

                System.out.println(array[i][j]);

                System.out.println("NUM111 = " + i + " " + j);
                if (checkToTop(i,j)) {
                    System.out.println("NUM333 = " + (i -1) + " " + j);
                    array[i - 1][j] = LabyrinthPoint.THESEUS.getItem();
                    i -= 2;
                    continue row;
                } else {
                    return false;
                }

//                if(checkToBottom(i,j)) {
//                    System.out.println("BOTTOM");
//                    array[i + 1][j] = LabyrinthPoint.THESEUS.getItem();
//                    j -= 1;
//                    continue column;
//                } else if (checkToRight(i,j)) {
//                    System.out.println("RIGHT");
//                    array[i][j + 1] = LabyrinthPoint.THESEUS.getItem();
//                    continue column;
//                } else if (checkToTop(i,j)) {
//                    System.out.println("TOP");
//                    array[i - 1][j] = LabyrinthPoint.THESEUS.getItem();
//                i -= 2;
//                    continue row;
//                } else if (checkToLeft(i,j)) {
//                    System.out.println("LEFT");
//                    array[i][j - 1] = LabyrinthPoint.THESEUS.getItem();
//                    j -= 2;
//                    continue column;
//                } else {
//                    System.out.println("EXIT");
//                    System.out.println(array[i][j]);
//                    return false;
//                }
            }
        }
        System.out.println("NONONO");
        return false;
    }

    private void createRandomCharInArray(int maxSizeArray ,LabyrinthPoint labyrinthPoint) {

        int num1 = random.nextInt(maxSizeArray);
        int num2 = random.nextInt(maxSizeArray);

        array[num1][num2] = labyrinthPoint.getItem();
    }


    @Override
    public boolean checkToLeft(Integer row, Integer column) {
        column -= 1;
        if (column - 1 >= 0) {
            if (array[row][column].equals(LabyrinthPoint.FREE_WAY.getItem())) {
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
    public boolean checkToRight(Integer row, Integer column) {
        column += 1;
        if (column <= array.length - 1) {
            if (array[row][column].equals(LabyrinthPoint.FREE_WAY.getItem())) {
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
    public boolean checkToTop(Integer row, Integer column) {
        row -= 1;
        if (row >= 0) {
            if (array[row][column].equals(LabyrinthPoint.FREE_WAY.getItem())) {
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
    public boolean checkToBottom(Integer row, Integer column) {
        row += 1;
        if (row <= array.length - 1) {
            if (array[row][column].equals(LabyrinthPoint.FREE_WAY.getItem())) {
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
                    num1 = i;
                    num2 = j;
                    break found;
                }
            }
        }
    }
}
