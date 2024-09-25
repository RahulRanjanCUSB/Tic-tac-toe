package projects.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public int getRow() {
        return row;
    }

    public void setRow(int rows) {
        this.row = rows;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell(int rows, int col) {
        this.row = rows;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }


    public Cell(int rows, int col, Player player) {
        this.row = rows;
        this.col = col;
        this.cellState = CellState.FILLED;
        this.player = player;
    }

    public void display(){
        if(player == null) {
            System.out.print("| |");
        } else if(cellState.equals(CellState.BLOCKED)){
            System.out.print("||||");
        } else {
            System.out.print("|"+player.getSymbol().getSymbolChar()+"|");
        }
    }
}
