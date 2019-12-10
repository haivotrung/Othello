import java.util.List;

public abstract class Board implements Cloneable {

    protected final int width;
    protected final int size;
    protected Color[][] contents;

    public Board(int width) {
        this.width = width;
        this.size = this.width * this.width;
    }

    public int getWidth() {
        return width;
    }
    public int getSize() {
        return size;
    }
    public Color[][] getContents() {
        return contents;
    }


    public abstract boolean set(Color c, Coordinate coord);
    public abstract Color get(Coordinate coord);

    public abstract void initialize();

    public abstract int countValidMoves(Color c);
    public abstract List<Coordinate> getValidMoves(Color c);

    public Color winner() {
        Color winner = Color.EMPTY;

        int blackCount = this.countPieces(Color.B);
        int whiteCount = this.countPieces(Color.W);

        if (blackCount == whiteCount) {
            winner = Color.EMPTY;
        } else if (blackCount > whiteCount){
            winner = Color.B;
        } else {
            winner = Color.W;
        }
        return winner;
    }

    public boolean isGameOver() {

        // Check if all squares on the board are occupied
        boolean isFull = true;
        for (Color[] row : contents) {
            for (Color piece : row) {
                isFull = isFull && (piece != Color.EMPTY);
            }
        }

        if (isFull) {
            // Board is full
            return true;
        } else {
            //Board isn't full
            if (this.countValidMoves(Color.B) == 0 && countValidMoves(Color.W) == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int countPieces(Color c) {
        int count = 0;
        for (Color[] row : contents) {
            for (Color piece : row) {
                if (piece == c) {
                    count++;
                }
            }
        }
        return count;
    }

    public abstract String toString();

    public String toString(Color c) {
        return toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Board)) {
            return false;
        } else {
            Board b = (Board) o;
            if (contents.length == b.contents.length) {
                for (int row = 0; row < contents.length; row++) {
                    if (contents[row].length == b.contents[row].length) {
                        for (int col = 0; col < contents[row].length; col++) {
                            if (contents[row][col] != b.contents[row][col]) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
    }

    public abstract Board clone();
}
