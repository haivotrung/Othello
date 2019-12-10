public class Coordinate implements Comparable<Coordinate>, Cloneable {

    /**
     * The - <i>you guessed it!</i> - row component of the coordinate.
     */
    private int row;

    /**
     * The <i>*gasp*</i> column component of the coordinate.
     */
    private int col;

    public Coordinate(int row, int column) {
        this.row = row;
        this.col = column;
    }

    public Coordinate(Coordinate that) {
        this.row = that.row;
        this.col = that.col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Coordinate)) {
            return false;
        } else {
            Coordinate c = (Coordinate) o;
            return row == c.row && col == c.col;
        }
    }

    public int compareTo(Coordinate o) {

        // Outer if-else-if block compares row numbers
        if (this.row > o.row) {
            return 1;

        } else if (this.row < o.row) {
            return -1;

        } else {

            // Inner if-else-if block compares column numbers
            if (this.col > o.col) {
                return 1;
            } else if (this.col < o.col) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public Coordinate clone() {
        return new Coordinate(this);
    }
}
