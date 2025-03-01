package deck.abstractClasses;

import card.UnoCard;
import player.Player;
import player.abstractclasses.IInputHandling;
import player.abstractclasses.IPlayerManagement;

public abstract class Game {
    protected IInputHandling inputHandling;
    protected IPlayerManagement playerManagement;
    protected IBasicDrawPile drawPile;
    protected Player[] players;
    protected int playerIndex;
    public Game(IInputHandling inputHandling, IPlayerManagement iPlayerManagement, IBasicDrawPile drawPile) {
        this.inputHandling = inputHandling;
        this.playerManagement = iPlayerManagement;
        this.drawPile = drawPile;

    }
    public void play()  {
        this.drawPile = playerManagement.getDrawPile();
        players = playerManagement.createPlayers(inputHandling.getPlayersNames());

        playerIndex = playerManagement.firstPlayerTurn();
        System.out.println("First Player is " + players[playerIndex].getName());
    }

    public IPlayerManagement getPlayerManagement() {
        return playerManagement;
    }

    public void setPlayerManagement(IPlayerManagement playerManagement) {
        this.playerManagement = playerManagement;
    }

    public IInputHandling getInputHandling() {
        return inputHandling;
    }

    public void setInputHandling(IInputHandling inputHandling) {
        this.inputHandling = inputHandling;
    }

    public Player[] getPlayers() {
        return players;
    }

    public abstract void dealCards() throws InterruptedException;
    public abstract UnoCard firstCardOnDiscardPile();

}
