package labyrinth;

public enum LabyrinthPoint {
    FREECELL("[ ]"),
    Opportunity("[*]"),
    WALL("*"),
    START("U+2386"),
    END("U+1F6AA")
    ;

    private String item;

    LabyrinthPoint(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
