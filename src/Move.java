import java.util.Scanner;

public class Move {

    public static void DoMove(PlayRock playRock, Board board, String diceResult) {
        String x = diceResult;

        switch (x) {
            case "Dest": {

                Player player = playRock.getPlayer();
                PlayRock[] availableRocks = player.getPlayRocks();
                int rockNumber;
                if (choice == 1) {
                    board.setPieceInPlayerKitchen(0, playRock);
                    playRock.setPosition(0);
                    board.printBoard();
                    System.out.println("sahozy : choose play rock to move (10)  ");

                    for (int i = 0; i < availableRocks.length; i++) {
                        if (!availableRocks[i].finish && availableRocks[i].getPosition() != -1) {
                            System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i]);
                        }
                    }
                    rockNumber = scanner.nextInt() - 1;
                    if (player.getPlayRocks()[rockNumber].isInTheKitchen) {
                        board.movePlayRockInKitchen(player.getPlayRocks()[rockNumber], 10, board.getPlayerKitchen(player.getPlayRocks()[rockNumber]));
                    } else {
                        board.movePlayRockInPath(player.getPlayRocks()[rockNumber], 10, board.getPath());
                    }


                } else if (choice == 2) {
                    for (int i = 0; i < availableRocks.length; i++) {
                        if (!availableRocks[i].finish && availableRocks[i].getPosition() != -1) {
                            System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i]);
                        }
                    }
                    System.out.println("sahozy : choose play rock to move (1)  ");
                    rockNumber = scanner.nextInt() - 1;
                    if (player.getPlayRocks()[rockNumber].isInTheKitchen) {
                        board.movePlayRockInKitchen(player.getPlayRocks()[rockNumber], 1, board.getPlayerKitchen(player.getPlayRocks()[rockNumber]));
                    } else {
                        board.movePlayRockInPath(player.getPlayRocks()[rockNumber], 1, board.getPath());
                    }
                    board.printBoard();
                    for (int i = 0; i < availableRocks.length; i++) {
                        if (!availableRocks[i].finish && availableRocks[i].getPosition() != -1) {
                            System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i]);
                        }
                    }
                    System.out.println("sahozy : choose play rock to move (10)  ");
                    rockNumber = scanner.nextInt() - 1;
                    if (player.getPlayRocks()[rockNumber].isInTheKitchen) {

                        board.movePlayRockInKitchen(player.getPlayRocks()[rockNumber], 10, board.getPlayerKitchen(player.getPlayRocks()[rockNumber]));
                    } else {
                        board.movePlayRockInPath(player.getPlayRocks()[rockNumber], 10, board.getPath());
                    }
                    board.printBoard();
                }
            }
            break;
            case "Bunja": {
                System.out.println("You rolled a " + diceResult + "! Choose an option:");
                System.out.println("1. Add a new rock to the board");
                System.out.println("2. Move an available rock 1 position");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                if (choice == 1) {
                    board.setPieceInPlayerKitchen(0, playRock);
                    playRock.setPosition(0);
                    board.printBoard();
                    System.out.println("sahozy : choose play rock to move (10)  ");
                    Player player = playRock.getPlayer();
                    PlayRock[] availableRocks = player.getPlayRocks();
                    for (int i = 0; i < availableRocks.length; i++) {
                        if (!availableRocks[i].finish && availableRocks[i].getPosition() != -1) {
                            System.out.println("Rock " + (i + 1) + ": Position " + availableRocks[i]);
                        }
                    }
                    int rockNumber = scanner.nextInt() - 1;
                    if (player.getPlayRocks()[rockNumber].isInTheKitchen) {
                        board.movePlayRockInKitchen(player.getPlayRocks()[rockNumber], 10, board.getPlayerKitchen(player.getPlayRocks()[rockNumber]));
                    } else {
                        board.movePlayRockInPath(player.getPlayRocks()[rockNumber], 10, board.getPath());
                    }

                } else if (choice == 2) {
                    // Move the passed playRock 1 position
                    if (playRock.isInTheKitchen) {
                        board.movePlayRockInKitchen(playRock, 11, board.getPlayerKitchen(playRock));
                    } else {
                        board.movePlayRockInPath(playRock, 11, board.getPath());
                    }
                } else {
                    System.out.println("Invalid choice!");
                }
            }
            break;
            case "Duwag":
                if (playRock.isInTheKitchen) {
                    System.out.println("fffffffffffffffff");
                    board.movePlayRockInKitchen(playRock, 2, board.getPlayerKitchen(playRock));
                } else {
                    System.out.println("gggggggggggggggggg");
                    board.movePlayRockInPath(playRock, 2, board.getPath());
                }
                break;
            case "Thalatha":
                if (playRock.isInTheKitchen) {
                    System.out.println(playRock.getPosition());
                    board.movePlayRockInKitchen(playRock, 3, board.getPlayerKitchen(playRock));
                    System.out.println(playRock.getPosition());
                } else {
                    board.movePlayRockInPath(playRock, 3, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 3);
                break;
            case "Arba'a":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 4, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 4, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 4);
                break;
            case "Bara":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 12, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 12, board.getPath());
                }
                //playRock.setPosition(playRock.getPosition() + 12);
                break;
            case "Shakka":
                if (playRock.isInTheKitchen) {
                    board.movePlayRockInKitchen(playRock, 6, board.getPlayerKitchen(playRock));
                } else {
                    board.movePlayRockInPath(playRock, 6, board.getPath());
                }
                //   playRock.setPosition(playRock.getPosition() + 6);
                break;
        }
    }

}

