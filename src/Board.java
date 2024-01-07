public class Board {
    private PlayRock[] path;
    private PlayRock[] player1Kitchen;
    private PlayRock[] player2Kitchen;

    public Board(int pathSize, int kitchenSize) {
        this.path = new PlayRock[pathSize];
        this.player1Kitchen = new PlayRock[kitchenSize];
        this.player2Kitchen = new PlayRock[kitchenSize];
    }


    public PlayRock[] getPath() {
        return path;
    }

    public PlayRock[] getPlayerKitchen(PlayRock playRock) {
        if (playRock.getPlayer().id == 1) {
            return player1Kitchen;
        }
        else {
            return player2Kitchen;
        }


    }



    public void setPieceInPath(int position,PlayRock playRock) {
        path[position] = playRock;
    }


    public void removePieceFromPath(int position) {
        path[position] = null;
    }

    public void setPieceInPlayerKitchen(int position,PlayRock playRock) {
        if (playRock.getPlayer().id == 1) {
            player1Kitchen[position] =playRock;
        }
        else {
            player2Kitchen[position] = playRock;
        }

    }


    public void removePieceFromPlayerKitchen(int position,PlayRock playRock) {
        if (playRock.getPlayer().id == 1) {
            player1Kitchen[position] =null;
        }
        else {
            player2Kitchen[position] = null;
        }
    }


    public void printBoard() {
        System.out.println("Path:");
        for (int i = 0; i < path.length; i++) {
            System.out.print("Position " + i + ": ");
            if (path[i] != null) {
                System.out.println(path[i].getPlayer().getName());
            } else {
                System.out.println("Empty");
            }
        }

        System.out.println("Player 1's Kitchen:");
        for (int i = 0; i < player1Kitchen.length; i++) {
            System.out.print("Position " + i + ": ");
            if (player1Kitchen[i] != null) {
                System.out.println(player1Kitchen[i].getPlayer().getName());
            } else {
                System.out.println("Empty");
            }
        }

        System.out.println("Player 2's Kitchen:");
        for (int i = 0; i < player2Kitchen.length; i++) {
            System.out.print("Position " + i + ": ");
            if (player2Kitchen[i] != null) {
                System.out.println(player2Kitchen[i].getPlayer().getName());
            } else {
                System.out.println("Empty");
            }
        }
    }
    public void movePlayRockInKitchen(PlayRock playRock, int totalSteps, PlayRock[] road) {
        if (playRock.tastee7) {
            if (isMatbokh(playRock,totalSteps))
            {
                playRock.finish = true;
                removePieceFromPlayerKitchen(playRock.getPosition(),playRock);
                System.out.println("مبروك عليك ربع مليون دولار");
//                System.exit(0);
            }
            setPieceInPlayerKitchen(playRock.getPosition()+totalSteps ,playRock);

            if (playRock.getPosition() >= 0 && playRock.getPosition() <= (road.length-1)) {
                removePieceFromPlayerKitchen(playRock.getPosition(),playRock);
            }
            playRock.setPosition(playRock.getPosition()+totalSteps);
        }
        else {
            if (totalSteps >= road.length - playRock.getPosition()) {
                removePieceFromPlayerKitchen(playRock.getPosition(),playRock);
                int steps = totalSteps + playRock.getPosition() - (road.length-1);

                if (playRock.getPlayer().id == 1) {
                    playRock.setPosition(-1);
                    movePlayRockInPath(playRock, steps, path);
                }
                else {
                    playRock.setPosition(((path.length)/2)-1);
                    movePlayRockInPath(playRock,steps,path);
                }
                playRock.isInTheKitchen = false;
            }
        else {
            setPieceInPlayerKitchen(playRock.getPosition()+totalSteps,playRock);
            removePieceFromPlayerKitchen(playRock.getPosition(),playRock);
            playRock.setPosition(playRock.getPosition()+totalSteps);
        }
        }

    }
    public void movePlayRockInPath(PlayRock playRock, int totalSteps, PlayRock[] road)
    {
        if (playRock.getPosition()+totalSteps > road.length-1)
        {

            int restOfSteps = playRock.getPosition()+totalSteps - (road.length-1);
            System.out.println("rest : " + ( playRock.getPosition()+totalSteps - (road.length)));
            removePieceFromPath(playRock.getPosition());
            setPieceInPath(restOfSteps,playRock);
            playRock.setPosition(restOfSteps);
            playRock.counter += totalSteps;
        }
        else {
        System.out.println("counter : " +playRock.counter);
        if(playRock.counter >= path.length - 1)
        {
            playRock.tastee7=true;
            playRock.isInTheKitchen=true;
            removePieceFromPath(playRock.getPosition());
            int steps = playRock.counter + totalSteps - (road.length);
            playRock.setPosition(-1);
            movePlayRockInKitchen(playRock,steps, path);
        }
        else {

            System.out.println("ttttttttttttt : " + playRock.getPosition());
            playRock.counter += totalSteps;
            setPieceInPath(playRock.getPosition()+totalSteps,playRock);
            if (playRock.getPosition() >= 0 && playRock.getPosition() <= (road.length-1)) {
                removePieceFromPath(playRock.getPosition());
            }
            playRock.setPosition(playRock.getPosition()+totalSteps);
        }
        }
    }
    public boolean isMatbokh(PlayRock playRock,int totalSteps)
    {
        if (playRock.getPosition()+totalSteps == getPlayerKitchen(playRock).length){
            return true;
        }
        return false;
    }

}
