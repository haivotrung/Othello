public class AI extends Player{
    public AI(String name, Color color) {
        super(name, color);
    }

    public Coordinate makeMove(Board board) {
        int MaxScore = -1;
        Coordinate BestCoord = null;

        for(Coordinate coord : board.getValidMoves(color)) {
            Board copyB = board.clone();
            copyB.set(color, coord);
            int k = copyB.countPieces(color);  // keeps track of count

            //add a try catch here
            if(k > MaxScore) {
                MaxScore = k;
                BestCoord = coord;
            }
        }

        // loop through all move that are available
        // then as we go through , we need to keep track which move gives us the most pieces
        // return the coord that result in the best move
        return BestCoord;
    }

}