import java.util.Scanner;

public class Game {
    private boolean turn;
    private Scanner scanner;
    private Board board;
    private Player player1;
    private Player player2;

    public Game() {
        this.turn = true;
        this.scanner = new Scanner(System.in);
        this.board = new Board(12, 4);
        this.player1 = new Player("EMPLOYEE", board, 1);
        this.player2 = new Player("THE Arsis", board, 2);
    }

    public void run() {
        while (true) {
            Player currentPlayer = turn ? player1 : player2;
            Player otherPlayer = turn ? player2 : player1;
            turn = !turn;
            if (currentPlayer.hasWon(currentPlayer.getPlayRocks())) {
                scanner.close();
                System.out.println("sahozy : "+currentPlayer.getName() + " has won the game!");
                break;
            }
            System.out.println("sahozy : Press 1 to roll the dice or 0 to exit : player : " + currentPlayer.getName());
            int input = scanner.nextInt();

            if (input == 0) {
                break;
            } else if (input == 1) {
                handleDiceRollAndMove(currentPlayer,otherPlayer);
            } else {
                System.out.println("sahozy : Invalid input!");
            }

            turn = !turn;
        }

        scanner.close();
        System.out.println("sahozy : Game over. Thank you for playing!");
    }

    private void handleDiceRollAndMove(Player currentPlayer,Player otherPlayer) {
        DiceRolls rand = new DiceRolls();
        rand.rollDice();
        rand.printState();

        PlayRock[] availableRocks = currentPlayer.getPlayRocks();
        System.out.println("sahozy : Available rocks for " + currentPlayer.getName() + ":");
        for (int i = 0; i < availableRocks.length; i++) {
            if (!availableRocks[i].finish) {
                System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i].getPosition());
            }
        }

        System.out.println("sahozy : Choose a rock number to move:");
        int rockNumber = scanner.nextInt();
        if (rockNumber >= 1 && rockNumber <= availableRocks.length) {
            String diceResult = rand.countOnesAndNameState();
            Move.DoMove(availableRocks[rockNumber - 1], board, diceResult);
            boolean x = Rules.kill(board,availableRocks[rockNumber - 1], otherPlayer.getPlayRocks());
            System.out.println("counter : " + x);
            board.printBoard();
        } else {
            System.out.println("Invalid rock number!");
        }

    }
}