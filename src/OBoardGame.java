import java.util.ArrayList;
import java.util.List;

public class OBoardGame extends Board {

    public OBoardGame(int width) {
        super(width);
        contents = new Color[width][width];
        for( int row = 0; row < width; row++){
            for(int col = 0; col < width; col++){
                contents[row][col] = Color.EMPTY;
            }
        }
        initialize();
    }

    public OBoardGame(OBoardGame board) {
        super(board.width);
        contents = new Color[width][width];
        for( int row = 0; row < width; row++){
            for(int col = 0; col < width; col++){
                contents[row][col] = board.contents[row][col];
            }
        }
    }

    public boolean set(Color t, Coordinate coord) {
        boolean checkTotal = false;
        boolean[] moves =  checkMove(t,coord);
        for (boolean b : moves) {
            checkTotal = checkTotal || b;
        }
        int row = coord.getRow();
        int column = coord.getCol();
        contents[row][column] = t;
        if(checkTotal) {
            if(moves[0]) {
                row = coord.getRow();
                column = coord.getCol();
                column++;
                while( row < width && column < width && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    column++;
                }
            }
            if(moves[1]) {
                row = coord.getRow();
                column = coord.getCol();
                column--;
                while( row < width && column >= 0 && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    column--;
                }
            }if(moves[2]) {
                row = coord.getRow();
                column = coord.getCol();
                row++;
                while( row >= 0 && column < width && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    row++;
                }
            }if(moves[3]) {
                row = coord.getRow();
                column = coord.getCol();
                row--;
                while( row >= 0 && column < width && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    row--;
                }
            }if(moves[4]) {
                row = coord.getRow();
                column = coord.getCol();
                column--;
                while( row < width && column >= 0 && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    column--;
                }
            }
            if(moves[5]) {
                row = coord.getRow();
                column = coord.getCol();
                column--;
                row++;
                while( row < width && column >= 0 && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    column--;
                    row++;
                }
            }if(moves[6]) {
                row = coord.getRow();
                column = coord.getCol();
                column++;
                row++;
                while( row < width && column < width && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    column++;
                    row++;
                }
            }if(moves[7]) {
                row = coord.getRow();
                column = coord.getCol();
                column--;
                row--;
                while( row >= 0 && column >= 0 && contents[row][column] == t.flip()) { // fliping opp color
                    contents[row][column] = contents[row][column].flip();
                    column--;
                    row--;
                }
            }
            return true;
        }else{
            return false;
        }
    }


    public Color get(Coordinate coord) {
        return contents[coord.getRow()][coord.getCol()];
    }

    public void initialize() {
        contents[3][3] = Color.W ;
        contents[4][4]= Color.W;
        contents[4][3]=Color.B;
        contents[3][4]=Color.B;
    }

    public int countValidMoves(Color t) {
        return getValidMoves(t).size();
    }

    public List<Coordinate> getValidMoves(Color t) {
        List <Coordinate> c = new ArrayList<Coordinate>();
        for( int row = 0; row < width; row++){
            for(int col = 0; col < width; col++){
                boolean checkTotal = false;
                Coordinate move = new Coordinate(row,col);
                for (boolean b : checkMove(t, move)) {
                    checkTotal = checkTotal || b;
                }
                if(checkTotal) {
                    c.add(move);
                }
            }
        }
        return c;
    }

    public boolean[] checkMove(Color t, Coordinate coord) {
        boolean[] retVal = new boolean [8];
        if(get(coord) != Color.EMPTY) {
            return retVal;
        } else {
            int row = coord.getRow();
            int column = coord.getCol();
            boolean oppPin = false;
            while(row < width && column+1 < width) {
                column++;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[0] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row < width && column-1 >= 0) {
                column--;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[1] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row + 1 < width && column < width) {
                row++;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[2] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row - 1 >= 0 && column < width) {
                row--;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[3] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row - 1 >= 0 && column + 1 < width) {
                column++;
                row --;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[4] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row+1 < width && column-1>= 0) {
                column--;
                row++;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[5] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row+1 < width && column+1 < width) {
                column++;
                row++;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[6] = true;
                }
            }

            row = coord.getRow();
            column = coord.getCol();
            oppPin = false;
            while(row-1 >= 0 && column-1 >= 0) {
                column--;
                row--;
                if(contents[row][column] != t && contents[row][column] != Color.EMPTY){
                    oppPin = true;
                }else if (oppPin && contents[row][column] == t) {
                    retVal[7] = true;
                }

            }
        }

        return retVal;
    }

    public String toString() {
        String b  = "  A B C D E F G H\n";
        int n = 1;
        for(Color[] setUp : contents) {
            b += n + " ";
            for(Color c : setUp ) {
                switch (c) {
                    case EMPTY:
                        b += ". ";
                        break;

                    default:
                        b +=  c + " ";
                        break;
                }
            }
            b+= "\n";
            n++;
        }
        return b;
    }

    public Board clone() {
        return new OBoardGame(this);
    }

}
