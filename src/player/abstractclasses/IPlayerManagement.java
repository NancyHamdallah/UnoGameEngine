package player.abstractclasses;

import deck.abstractClasses.IBasicDrawPile;
import player.Player;

public interface IPlayerManagement {
    public Player[] createPlayers(String[] playersNames);
    public String firstPlayerTurn();
    public IBasicDrawPile getDrawPile();
}
