package tasks.labyrinth.details;

public enum LabyrinthPoint {
    FREE_WAY(" "),
    //    PASSAGE("[*]"),
    WALL("*"),
    ENTRY("\u2386"),
    EXIT("\uD83D\uDEAA"),
    THESEUS("\uD83D\uDEB6"),
    MINOTAUR("\uD800\uDDEB")
    ;

    private String item;

    LabyrinthPoint(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
