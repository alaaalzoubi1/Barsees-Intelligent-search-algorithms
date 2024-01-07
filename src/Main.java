//import java.util.Scanner;
////
////// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
////// then press Enter. You can now see whitespace characters in your code.
////public class Main {
////  public static void main(String[] args) {
////    boolean turn = true;
////    Scanner scanner = new Scanner(System.in); // Create a Scanner object
////    Board board = new Board(12,4);
////
////    Player player1 = new Player("EMPLOYEE",board,1);
////    Player player2 = new Player("THE Arsis",board,2);
////    System.out.println(board.getPath().length);
////    while(true) {
////      if (turn) {
////        System.out.println("Press 1 to roll the dice or 0 to exit : player : " + player2.getName());
////        int input = scanner.nextInt();// Read user input
////        if (input == 0) {
////          break; // Exit the loop if 0 is entered
////        } else if (input == 1) {
////          DiceRolls rand = new DiceRolls();
////          rand.rollDice();
////          rand.printState(); // This will show the dice result
////          // Assuming you want to move for player1, display available rocks
////          PlayRock[] availableRocks = player2.getPlayRocks();
////          System.out.println("Available rocks for " + player2.getName() + ":");
////          for (int i = 0; i < availableRocks.length; i++) {
////            if (!availableRocks[i].finish) {
////              System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i].getPosition());
////            }
////          }
////
////          // Ask the user to choose a rock to move
////          System.out.println("Choose a rock number to move:");
////          int rockNumber = scanner.nextInt();
////          if (rockNumber >= 1 && rockNumber <= availableRocks.length) {
////
////            String diceResult = rand.countOnesAndNameState();
////            Move.DoMove(availableRocks[rockNumber - 1], board, diceResult);
////            System.out.println("counter : " + availableRocks[rockNumber - 1].counter);
////            board.printBoard(); // Print the updated board state
////
////          } else {
////            System.out.println("Invalid rock number!");
////          }
////        } else {
////          System.out.println("Invalid input!");
////        }
////        turn = false;
////        scanner.close(); // Close the scanner when it's no longer needed
////        System.out.println("Game over. Thank you for playing!");
////      }
////      else {
////        System.out.println("Press 1 to roll the dice , player :" + player1.getName());
////        int input = scanner.nextInt();// Read user input
////        if (input == 0) {
////             break; // Exit the loop if 0 is entered
////        } else if (input == 1) {
////          DiceRolls rand = new DiceRolls();
////          rand.rollDice();
////          rand.printState(); // This will show the dice result
////          // Assuming you want to move for player1, display available rocks
////          PlayRock[] availableRocks = player1.getPlayRocks();
////          System.out.println("Available rocks for " + player1.getName() + ":");
////          for (int i = 0; i < availableRocks.length; i++) {
////          if (!availableRocks[i].finish) {
////            System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i].getPosition());
////          }
////        }
////
////        // Ask the user to choose a rock to move
////        System.out.println("Choose a rock number to move:");
////        int rockNumber = scanner.nextInt();
////        if (rockNumber >= 1 && rockNumber <= availableRocks.length) {
////
////          String diceResult = rand.countOnesAndNameState();
////          Move.DoMove(availableRocks[rockNumber - 1], board, diceResult);
////          System.out.println("counter : " + availableRocks[rockNumber - 1].counter);
////          board.printBoard(); // Print the updated board state
////
////        } else {
////          System.out.println("Invalid rock number!");
////        }
////      } else {
////        System.out.println("Invalid input!");
////      }
////
////    }
////    turn = true;
////      scanner.close(); // Close the scanner when it's no longer needed
////      System.out.println("Game over. Thank you for playing!");
////  }
////
////    }
////
////
////
////
////  }
//public class Main {
//  public static void main(String[] args) {
//    boolean turn = true; // true for player1's turn, false for player2's turn
//    Scanner scanner = new Scanner(System.in); // Create a Scanner object
//    Board board = new Board(12,4);
//
//    Player player1 = new Player("EMPLOYEE", board, 1);
//    Player player2 = new Player("THE Arsis", board, 2);
//
//    while (true) {
//      Player currentPlayer = turn ? player1 : player2;
//      System.out.println("Press 1 to roll the dice or 0 to exit : player : " + currentPlayer.getName());
//      int input = scanner.nextInt(); // Read user input
//
//      if (input == 0) {
//        break; // Exit the loop if 0 is entered
//      } else if (input == 1) {
//          DiceRolls rand = new DiceRolls();
//          rand.rollDice();
//          rand.printState(); // This will show the dice result
//          // Assuming you want to move for player1, display available rocks
//          PlayRock[] availableRocks = currentPlayer.getPlayRocks();
//          System.out.println("Available rocks for " + currentPlayer.getName() + ":");
//          for (int i = 0; i < availableRocks.length; i++) {
//            if (!availableRocks[i].finish) {
//              System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i].getPosition());
//            }
//          }
//
//          // Ask the user to choose a rock to move
//          System.out.println("Choose a rock number to move:");
//          int rockNumber = scanner.nextInt();
//          if (rockNumber >= 1 && rockNumber <= availableRocks.length) {
//
//            String diceResult = rand.countOnesAndNameState();
//            Move.DoMove(availableRocks[rockNumber - 1], board, diceResult);
//            System.out.println("counter : " + availableRocks[rockNumber - 1].counter);
//            board.printBoard(); // Print the updated board state
//
//          } else {
//            System.out.println("Invalid rock number!");
//          }
//        } else {
//          System.out.println("Invalid input!");
//        }
//      }
//
//      turn = !turn; // Switch turns
//    }
//
//    scanner.close(); // Close the scanner when it's no longer needed
//    System.out.println("Game over. Thank you for playing!");
//  }
//}
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    new Game().run();
  }
}
