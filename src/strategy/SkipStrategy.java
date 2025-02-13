package strategy;

import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class SkipStrategy implements IActionStrategy {

    public static SkipStrategy getInstance(){
        return new SkipStrategy();
    }
    public void action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        System.out.println("Turn is skipped");
    }
}
