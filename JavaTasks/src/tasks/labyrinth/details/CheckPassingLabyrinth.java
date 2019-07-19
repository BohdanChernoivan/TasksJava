package tasks.labyrinth.details;

public interface CheckPassingLabyrinth<ROW, COLUMN, T>{

    boolean checkToLeft(ROW row, COLUMN column, T t);

    boolean checkToRight(ROW row, COLUMN column, T t);

    boolean checkToTop(ROW row, COLUMN column, T t);

    boolean checkToBottom(ROW row, COLUMN column, T t);

}
