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
            CardName cardName = discardPile.getCard().getName();
            IActionStrategy strategy = StrategyFactory.getStrategy(cardName);
            if(!cardName.equals(CardName.REVERSE)) {
                direction = strategy.action(discardPile, player, direction, basicDrawPile);
            }
            else{
                direction = NumberStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
            }

        }
        else{
            direction = NumberStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }
    return direction;
    }
}
