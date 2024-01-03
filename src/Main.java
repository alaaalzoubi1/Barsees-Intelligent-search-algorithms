// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      Board board = new Board(12,4);

      DiceRolls rand = new DiceRolls();
      rand.rollDice();
      rand.printState();
      Player player1 = new Player("alaa",board,1);
      Player player2 = new Player("aamir",board,2);
      PlayRock[] x = player1.getPlayRocks();
      PlayRock[] y = player2.getPlayRocks();
      board.setPieceInPlayerKitchen(0,x[1]);
      board.setPieceInPlayerKitchen(0,y[2]);
      board.printBoard();
      System.out.println(board.getPath().length);
      for (int i = 0; i < 10; i++) {
        try {
          Move.DoMove(player1.getPlayRocks()[1],board );
          board.printBoard();
//          System.out.println("Iteration: " + i);
//          System.out.println("counter : " + player1.getPlayRocks()[1].counter);
//          System.out.println("ts : " + player1.getPlayRocks()[1].tastee7);
//          System.out.println("inth : " + player1.getPlayRocks()[1].isInTheKitchen);
          Thread.sleep(1000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }




        }
    }
