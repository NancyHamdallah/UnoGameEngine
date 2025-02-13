package strategy;

import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class ReverseStrategy implements IActionStrategy{
    public static ReverseStrategy getInstance(){
        return new ReverseStrategy();
    }
    public void action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        System.out.println();
        System.out.println("Direction is reversed");
        if (direction == Direction.CLOCKWISE) {
            direction = Direction.COUNTERCLOCKWISE;
        } else if (direction == Direction.COUNTERCLOCKWISE) {
            direction = Direction.CLOCKWISE;
        }

    }
}
