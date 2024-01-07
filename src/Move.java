import java.util.Scanner;

public class Move {
//    Board board;
//    PlayRock playRock;

    //    public Move(Board board, PlayRock playRock) {
//        this.board = board;
//        this.playRock = playRock;
//    }
    public static void DoMove(PlayRock playRock, Board board,String diceResult)
    {
        DiceRolls diceRolls = new DiceRolls();
        String x =  diceRolls.countOnesAndNameState();

        if (x.equals("Dest") || x.equals("Bunja")) {
            System.out.println("You rolled a " + diceResult + "! Choose an option:");
            System.out.println("1. Add a new rock to the board");
            System.out.println("2. Move an available rock 1 position");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Logic to add a new rock to the board
                // This could involve checking if there is a rock available to enter the board
                // and updating the board state accordingly
            } else if (choice == 2) {
                // Move the passed playRock 1 position
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 1, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 1, board.getPath());
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
        else{ switch (x)
        {
            case "dest" :
                if(playRock.isInTheKitchen)
                {
                    board.movePlayRockInKitchen(playRock,10, board.getPlayerKitchen(playRock));
                }
                else {
                    board.movePlayRockInPath(playRock,10, board.getPath());
                }
            case "Duwag" :
                if(playRock.isInTheKitchen)
                {
                    board.movePlayRockInKitchen(playRock,2, board.getPlayerKitchen(playRock));
                }
                else {
                    board.movePlayRockInPath(playRock,2, board.getPath());
                }
                break;
            case  "Thalatha" :
                if(playRock.isInTheKitchen)
                {
                    board.movePlayRockInKitchen(playRock,3, board.getPlayerKitchen(playRock));
                }
                else {
                    board.movePlayRockInPath(playRock,3, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 3);
                break;
            case  "Arba'a" :
                if(playRock.isInTheKitchen)
                {
                    board.movePlayRockInKitchen(playRock,4, board.getPlayerKitchen(playRock));
                }
                else {
                    board.movePlayRockInPath(playRock,4, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 4);
                break;
            case  "Bunja" :
                if(playRock.isInTheKitchen)
                {
                    board.movePlayRockInKitchen(playRock,24, board.getPlayerKitchen(playRock));
                }
                else {
                    board.movePlayRockInPath(playRock,24, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 24);
                break;
            case  "Bara" :
                if(playRock.isInTheKitchen)
                {
                    board.movePlayRockInKitchen(playRock,12, board.getPlayerKitchen(playRock));
                }
                else {
                    board.movePlayRockInPath(playRock,12, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 12);
                break;
            case  "Shakka" :if(playRock.isInTheKitchen)
            {
                board.movePlayRockInKitchen(playRock,6, board.getPlayerKitchen(playRock));
            }
            else {
                board.movePlayRockInPath(playRock,6, board.getPath());
            }
                //   playRock.setPosition(playRock.getPosition() + 6);
                break;
        }}

    }

}
