import java.util.*;
import java.util.Arrays;

public class State {
    private Board board;
    private Player currentPlayer;
    private Player otherPlayer;
    private boolean isPlayer1Turn;
    private DiceRolls diceRolls;

    public State(Board board, Player player1, Player player2, boolean isPlayer1Turn, DiceRolls diceRolls) {
        this.board = new Board(board.getPath().length, board.getPlayerKitchen(null).length); // Assuming null can be used to get kitchen size
        this.currentPlayer = isPlayer1Turn ? player1 : player2;
        this.otherPlayer = isPlayer1Turn ? player2 : player1;
        this.isPlayer1Turn = isPlayer1Turn;
        this.diceRolls = diceRolls;

    }

    private void copyBoardState(Board originalBoard, Board newBoard) {
        copyPlayRocks(originalBoard.getPath(), this.board.getPath());
        copyPlayRocks(originalBoard.getPlayerKitchen(new PlayRock(currentPlayer, null)), this.board.getPlayerKitchen(new PlayRock(currentPlayer, null)));
        copyPlayRocks(originalBoard.getPlayerKitchen(new PlayRock(otherPlayer, null)), this.board.getPlayerKitchen(new PlayRock(otherPlayer, null)));
    }

    private void copyPlayRocks(PlayRock[] original, PlayRock[] copy) {
        for (int i = 0; i < original.length; i++) {
            if (original[i] != null) {
                copy[i] = new PlayRock(original[i].getPlayer(), this.board);
                copy[i].setPosition(original[i].getPosition());
                copy[i].tastee7 = original[i].tastee7;
                copy[i].counter = original[i].counter;
                copy[i].isInTheKitchen = original[i].isInTheKitchen;
                copy[i].finish = original[i].finish;
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public boolean isPlayer1Turn() {
        return isPlayer1Turn;
    }

    public DiceRolls getDiceRolls() {
        return diceRolls;
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(currentPlayer, otherPlayer, isPlayer1Turn, diceRolls);
        result = 31 * result + Arrays.hashCode(board.getPath());
        result = 31 * result + Arrays.hashCode(board.getPlayerKitchen(new PlayRock(currentPlayer, null)));
        result = 31 * result + Arrays.hashCode(board.getPlayerKitchen(new PlayRock(otherPlayer, null)));
        return result;
    }
    public List<State> getNextStates() {
        List<State> successors = new ArrayList<>();

        // Assuming diceRolls is the result of the last dice roll and determines the possible moves
        String diceResult = diceRolls.countOnesAndNameState();
        int steps = convertDiceResultToSteps(diceResult); // This function needs to be defined to convert dice result to steps

        // Generate moves for current player's rocks
        for (PlayRock rock : currentPlayer.getPlayRocks()) {
            // Check if the rock can make a valid move
            if (canMoveRock(rock, steps)) { // This function needs to be defined to check if the rock can move
                // Create a copy of the board to modify
                Board newBoard = new Board(board.getPath().length, board.getPlayerKitchen(null).length);
                copyBoardState(this.board, newBoard);

                // Create a new state representing the move
                if (rock.isInTheKitchen) {
                    newBoard.movePlayRockInKitchen(rock, steps, newBoard.getPlayerKitchen(rock));
                } else {
                    newBoard.movePlayRockInPath(rock, steps, newBoard.getPath());
                }

                // Switch turns
                boolean nextPlayerTurn = !this.isPlayer1Turn; // Assuming a two-player game
                Player nextPlayer = nextPlayerTurn ? currentPlayer : otherPlayer;

                // Create the new state and add it to the list of successors
                State successorState = new State(newBoard, currentPlayer, otherPlayer, nextPlayerTurn, diceRolls);
                successors.add(successorState);
            }
        }

        return successors;
    }
    private int convertDiceResultToSteps(String diceResult) {
        // Mapping dice results to steps
        switch (diceResult) {
            case "Dest":
                return 1;
            case "Duwag":
                return 2;
            case "Thalatha":
                return 3;
            case "Arba'a":
                return 4;
            case "Bara":
                return 12;
            case "Shakka":
                return 6;
            case "Bunja":
                // Assuming Bunja allows a specific move, e.g., 5 steps
                return 5;
            default:
                // If the dice result is not recognized, no steps are allowed
                return 0;
        }
    }
    private boolean canMoveRock(PlayRock rock, int steps) {
        // Check if the rock has finished the game
        if (rock.finish) {
            return false;
        }

        // Check if the rock is in the kitchen and if it can exit or move within the kitchen
        if (rock.isInTheKitchen) {
            // Check the specific rules for moving a rock in the kitchen
            // For example, if a rock can only exit the kitchen with an exact roll
            if (rock.getPosition() + steps <= board.getPlayerKitchen(rock).length) {
                return true; // The rock can move within or exit the kitchen
            }
        } else {
            // Check if the rock can move on the path without exceeding the board limits
            // Assuming the path length is a property of the board
            if (rock.counter + steps <= board.getPath().length) {
                return true; // The rock can move on the path
            }
        }

        // If none of the above conditions are met, the rock cannot move
        return false;
    }
}

    // Other methods to manipulate the state, check for end conditions, generate successors, etc.

