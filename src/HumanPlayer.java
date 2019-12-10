import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner sc;

    public HumanPlayer(String name, Color color) {
        super(name, color);
        sc = new Scanner(System.in);
    }

    @Override
    public Coordinate makeMove(Board board) {
        int row = -1;
        int col = -1;
        String command;
        String[] parts;

        while (row < 0 || col < 0 || row >= board.getWidth() || col >= board.getWidth()) {

            // Get input
            command = sc.nextLine();
            parts = command.replaceAll("\\s+|,|(|)", "").toUpperCase().split("");

            // Input uses A-H for column name, and 1-8 for row name (Ex: upper-left corner is "A1", and lower-right corner is "H8")
            if (command.matches("[a-zA-Z][1-" + board.getWidth() + "]")) {

                String[] colLabels = "ABCDEFGH".substring(0, board.getWidth()).split("");
                for (int c = 0; c < colLabels.length; c++) {
                    if (parts[0].equals(colLabels[c])) {
                        col = c;
                    }
                }

                row = Integer.parseInt(parts[1]) - 1;
//            } else if (command.matches("Uu")) {
            } else{
                System.out.println("Invalid input");
                break;
            }
        }

        return new Coordinate(row, col);
    }
}