package strategy;

import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class DrawTwoStrategy implements IActionStrategy{
    public static DrawTwoStrategy getInstance(){
        return new DrawTwoStrategy();
    }
    public Direction action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        System.out.println("player:"+player.getName()+" has to draw two cards");
        player.drawCards(drawPile,2);
        discardPile.setChecked(true);
        return direction;
    }
}

