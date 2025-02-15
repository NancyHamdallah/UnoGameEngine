package player.abstractclasses;

import deck.abstractClasses.IBasicDrawPile;
import player.Player;

public interface IPlayerManagement {
    public Player[] createPlayers(String[] playersNames);
    public int firstPlayerTurn();
    public IBasicDrawPile getDrawPile();
}




