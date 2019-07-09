package labyrinth;

public interface CheckPassingLabyrinth<ROW, COLUMN>{

    boolean checkToLeft(ROW row, COLUMN column);

    boolean checkToRight(ROW row, COLUMN column);

    boolean checkToTop(ROW row, COLUMN column);

    boolean checkToBottom(ROW row, COLUMN column);

}
