package projects.tictactoe.strategies.winningStrategy;

import projects.tictactoe.models.Player;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(int dimension){
        return new OrderOneWinningStrategy(dimension);
    }
}
