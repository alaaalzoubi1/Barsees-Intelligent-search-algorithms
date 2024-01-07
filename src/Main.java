import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Create a Scanner object
    Board board = new Board(12,4);
//
//      DiceRolls rand = new DiceRolls();
//      rand.rollDice();
//      rand.printState();
    Player player1 = new Player("EMPLOYEE",board,1);
    Player player2 = new Player("THE BOSS",board,2);
    PlayRock[] x = player1.getPlayRocks();
    PlayRock[] y = player2.getPlayRocks();
    board.setPieceInPlayerKitchen(0,x[1]);
    board.setPieceInPlayerKitchen(0,y[2]);
    board.printBoard();
    System.out.println(board.getPath().length);
    while(true){
      System.out.println("Press 1 to roll the dice or 0 to exit");
      int input = scanner.nextInt();// Read user input
      if (input == 0) {
        break; // Exit the loop if 0 is entered
      }
      else if (input == 1) {
        DiceRolls rand = new DiceRolls();
        rand.rollDice();
        rand.printState(); // This will show the dice result

        // Assuming you want to move for player1, display available rocks
        PlayRock[] availableRocks = player2.getPlayRocks();
        System.out.println("Available rocks for " + player1.getName() + ":");
        for (int i = 0; i < availableRocks.length; i++) {
          System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i].getPosition());
        }

        // Ask the user to choose a rock to move
        System.out.println("Choose a rock number to move:");
        int rockNumber = scanner.nextInt();
        if (rockNumber >= 1 && rockNumber <= availableRocks.length) {

          String diceResult = rand.countOnesAndNameState();
          Move.DoMove(availableRocks[rockNumber - 1], board, diceResult);

          board.printBoard(); // Print the updated board state
        } else {
          System.out.println("Invalid rock number!");
        }
      } else {
        System.out.println("Invalid input!");
      }

    }
    scanner.close(); // Close the scanner when it's no longer needed
    System.out.println("Game over. Thank you for playing!");

//    }
//      for (int i = 0; i < 10; i++) {
//        try {
//          Move.DoMove(player2.getPlayRocks()[1],board );
//          board.printBoard();
//          Thread.sleep(1000); // Sleep for 5 seconds
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
//
//
//
//
//        }
  }
}
