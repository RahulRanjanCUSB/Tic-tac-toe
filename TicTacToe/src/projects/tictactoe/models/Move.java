package projects.tictactoe.models;

public class Move {
    private Cell cell;
    private Player player;


    public Move(Cell cell, Player player) {
        this.player = player;
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
