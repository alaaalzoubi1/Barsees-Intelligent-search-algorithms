public class Player {
    private String name;
    private static PlayRock[] playRocks;
    private Board board;
    int id;

    public Player(String name, Board board,int id) {
        this.name = name;
        this.board = board;
        this.playRocks = new PlayRock[4];
        this.id = id;
        for (int i = 0; i < 4; i++) {
            playRocks[i] = new PlayRock(this, board);
        }
    }

    public String getName() {
        return name;
    }

    public static PlayRock[] getPlayRocks() {
        return playRocks;
    }
    public static boolean hasWon() {
        for (PlayRock rock : getPlayRocks()) {
            if (!rock.finish) {
                return false;
            }
        }
        return true;
    }
}



