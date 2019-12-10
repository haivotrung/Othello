public abstract class Player {

    protected final String name;

    protected Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void swapColor() {
        color = color.flip();
    }

    public String getName() {
        return name;
    }

    public abstract Coordinate makeMove(Board board);
}
