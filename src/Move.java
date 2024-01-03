public class Move {
//    Board board;
//    PlayRock playRock;

//    public Move(Board board, PlayRock playRock) {
//        this.board = board;
//        this.playRock = playRock;
//    }
    public static void DoMove(PlayRock playRock, Board board)
    {
        String x = "Duwag";
        DiceRolls diceRolls = new DiceRolls();
        diceRolls.countOnesAndNameState();
        switch (x)
        {
            case "dest" :
//                if (playRock.getPosition() == 0) {
//                    playRock.setPosition(playRock.getPosition() + 10);
//                } else {
//                    playRock.setPosition(playRock.getPosition() + 10);
//                    if (playRock.getPosition() >= board.getPath().length) {
//                        playRock.setPosition(0);
//                        if (playRock.getPlayer().getName().equals("Player 1")) {
//                            board.setPieceInPlayer1Kitchen(0, playRock);
//                        } else {
//                            board.setPieceInPlayer2Kitchen(0, playRock);
//                        }
//                    }
//                }
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
                playRock.setPosition(playRock.getPosition() + 3);
                break;
            case  "Arba'a" :
                playRock.setPosition(playRock.getPosition() + 4);
                break;
            case  "Bunja" :
                playRock.setPosition(playRock.getPosition() + 24);
                break;
            case  "Bara" :
                playRock.setPosition(playRock.getPosition() + 12);
                break;
            case  "Shakka" :
                playRock.setPosition(playRock.getPosition() + 6);
                break;
        }
    }
}
