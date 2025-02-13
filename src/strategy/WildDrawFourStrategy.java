package strategy;

import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class WildDrawFourStrategy implements IActionStrategy{
    public static WildDrawFourStrategy getInstance(){
        return new WildDrawFourStrategy();
    }
    public Direction action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        System.out.println("player: "+player.getName()+" has to draw four cards");
        player.drawCards(drawPile,4);
        discardPile.setChecked(true);

        return direction;
    }
}
