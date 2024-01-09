public class PlayRock {
    private Player player;
    private int position;
    boolean tastee7;
    int counter;
    boolean isInTheKitchen = true;
    boolean finish;
    private Board board;


    public PlayRock(Player player, Board board) {
        this.player = player;
        this.board = board;
        this.position = 0;
        this.tastee7 = false;
        this.counter = -1;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;

    }

    @Override
    public String toString() {
        return "PlayRock{" +
                "player=" + player.getName() +
                ", position=" + position +
                ", tastee7=" + tastee7 +
                ", counter=" + counter +
                ", isInTheKitchen=" + isInTheKitchen +
                ", finish=" + finish +
                '}';
    }

}

