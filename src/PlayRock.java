public class PlayRock {
    private Player player;
    private int position;
    boolean tastee7;
    int counter;
    boolean isInTheKitchen = true;
    boolean finish;
    private Board board;

    public PlayRock(Player player, Board board){
        this.player = player;
        this.board = board;
        this.position = 0;
        this.tastee7=false;
        this.counter=0;
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
}
