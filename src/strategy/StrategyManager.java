package strategy;

import card.CardName;
import deck.BasicDrawPile;
import deck.Direction;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class StrategyManager {
    private IDiscardPile discardPile;
    private Player player;
    private Direction direction;
    private IBasicDrawPile basicDrawPile;
    public StrategyManager(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        this.discardPile = discardPile;
        this.player = player;
        this.direction = direction;
        this.basicDrawPile = drawPile;
    }

    public Direction performStrategy() {
        if(!discardPile.isChecked()) {
            if (discardPile.getCard().getName().equals(CardName.SKIP)) {
                direction = SkipStrategy.getInstance().action(discardPile, player, direction, basicDrawPile);
            } else if (discardPile.getCard().getName().equals(CardName.WILD_DRAW_FOUR)) {
                direction = WildDrawFourStrategy.getInstance().action(discardPile, player, direction, basicDrawPile);
            } else if (discardPile.getCard().getName().equals(CardName.WILD)) {
                direction = WildStrategy.getInstance().action(discardPile, player, direction, basicDrawPile);
            //} else if (discardPile.getCard().getName().equals(CardName.REVERSE)) {
               // direction = ReverseStrategy.getInstance().action(discardPile, player, direction, basicDrawPile);
            } else if (discardPile.getCard().getName().equals(CardName.DRAW_TWO)) {
                direction = DrawTwoStrategy.getInstance().action(discardPile, player, direction, basicDrawPile);
            } else {
                direction = NumberStrategy.getInstance().action(discardPile, player, direction, basicDrawPile);
            }
        }
        else{
            direction = NumberStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }
    return direction;
    }
}
