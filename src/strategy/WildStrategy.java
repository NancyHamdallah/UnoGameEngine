package strategy;

import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class WildStrategy implements IActionStrategy{
    public static WildStrategy getInstance(){
        return new WildStrategy();
    }
    public void action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        System.out.println("Wild Strategy");
    }
}
