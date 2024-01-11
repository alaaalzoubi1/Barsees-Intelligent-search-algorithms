import java.util.Scanner;

public class Move {

    public static void DoMove(PlayRock playRock, Board board, String diceResult) {
        String x = diceResult;
        switch (x) {
            case "Dest": {
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 10, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 10, board.getPath());
                }
            }
            break;
            case "Bunja": {
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 25, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 25, board.getPath());
                }
            }
            break;
            case "Duwag":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 2, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 2, board.getPath());
                }
                break;
            case "Thalatha":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 3, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 3, board.getPath());
                }
                break;
            case "Arba'a":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 4, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 4, board.getPath());
                }
                break;
            case "Bara":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 12, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 12, board.getPath());
                }
                break;
            case "Shakka":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 6, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 6, board.getPath());
                }
                break;
        }
    }

    public static void Uncle(PlayRock playRock, Board board, int choice) {

        if (choice == 1) {//new piece of cake
            board.setPieceInPlayerKitchen(0, playRock);
            playRock.setPosition(0);
            board.printBoard();

        } else if (choice == 2) {//move one
            if (playRock.isInTheKitchen) {
                board.movePlayRockInKitchen(playRock, 1, board.getPlayerKitchen(playRock));
            } else {
                board.movePlayRockInPath(playRock, 1, board.getPath());
            }
        }

    }
}


