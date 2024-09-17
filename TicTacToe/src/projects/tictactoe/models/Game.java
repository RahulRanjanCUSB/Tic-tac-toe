package projects.tictactoe.models;

import projects.tictactoe.exception.DuplicateSymbolException;
import projects.tictactoe.exception.InvalidBotCountException;
import projects.tictactoe.exception.InvalidDimensionException;
import projects.tictactoe.exception.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gamestate;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;


    private Game(List<Player> players, Board board, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = board;
        this.moves = new ArrayList<Move>();
        this.gamestate = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public static class Builder() {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        public static Builder builder(){
            return new Builder();
        }


        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

        public Builder() {
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
            this.players = new ArrayList<Player>();
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy) {
            winningStrategies.add(winningStrategy);
        }

        private void validateBotCounts() {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            if (botCount > 1) {
                throw new InvalidBotCountException("Bot count has exceeded 1.");
            }

        }

        private void validateDimension() {
            if (dimension < 3 || dimension > 10) {
                throw new InvalidDimensionException("Dimension should be in between 3 to 10");
            }
        }

        private void validateNumberOfPlayers() {
            if (players.size() != dimension - 1) {
                throw new InvalidNumberOfPlayersException("Players should be one less than dimension");
            }
        }

        private void validateUniqueSymbolForAllPlayers() {
            HashSet<Character> set = new HashSet<>();
            for (Player player : players) {
                set.add(player.getSymbol().getSymbolChar());
            }
            if (set.size() != players.size()) {
                throw new DuplicateSymbolException("Every player should have unique symbol");
            }
        }

        private void validate() {
            validateBotCounts();
            validateDimension();
            validateNumberOfPlayers();
            validateUniqueSymbolForAllPlayers();
        }

        private Game build()
        {
            validate();
            return new Game(players, new Board(), winningStrategies);
        }
    }
}
