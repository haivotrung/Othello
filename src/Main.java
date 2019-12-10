import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board b1 = new OBoardGame (8);
        System.out.print(b1 + "\n");
        System.out.print("Would you like to play as Black or White? (Input B/W)\n");

        Scanner sc = new Scanner(System.in);
        Player Human;
        Player AI;
        Player player1 = null;
        Player player2 = null;
        int passCount = 0;

        while (!sc.hasNext("[BbWw]")){
            System.out.println("Invalid input");
            sc.nextLine();
        }

        String userC = sc.nextLine();
        System.out.println("Thanks! Got it, the input is: " + userC);

        if (userC.matches("[Bb]")) {
            player1 = Human = new HumanPlayer( "Human", Color.B);
            player2 = AI = new AI("Computer", Color.W);
        } else if (userC.matches("[Ww]")){
            player2 = Human = new HumanPlayer("Human", Color.W);
            player1 = AI = new AI("Computer", Color.B);
        }

        while(!b1.isGameOver() && (passCount!=2)) {
            passCount = 0;
            try {
                System.out.println(player1.getName() + " it's your turn");
                b1.set(player1.getColor(), player1.makeMove(b1));
                System.out.println(b1);
                passCount = 0;
            } catch (Exception e) {
                System.out.println(player1.getName() +" passed\n");
                passCount++;
            }

            try {
                System.out.println(player2.getName() + " it's your turn");
                b1.set(player2.getColor(), player2.makeMove(b1));
                System.out.println(b1);
                passCount = 0;
            } catch (Exception e) {
                System.out.println(player2.getName() +" passed\n");
                passCount++;
            }
        }

        System.out.println(b1.winner()+ " is the winner\n");
        System.out.println(b1.countPieces(Color.B) + " is what Black had");
        System.out.println(b1.countPieces(Color.W) + " is what White had");

        sc.close();
    }
}