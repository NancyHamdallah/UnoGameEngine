package strategy;

import card.CardName;
import deck.BasicDrawPile;
import deck.Direction;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public class StrategyManager {
    IDiscardPile discardPile;
    Player player;
    Direction direction;
    IBasicDrawPile basicDrawPile;
    public StrategyManager(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        this.discardPile = discardPile;
        this.player = player;
        this.direction = direction;
        this.basicDrawPile = drawPile;
    }

    public void performStrategy() {
        if(discardPile.getCard().getName().equals(CardName.SKIP)){
            SkipStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }else if(discardPile.getCard().getName().equals(CardName.WILD_DRAW_FOUR)){
            WildDrawFourStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }else if(discardPile.getCard().getName().equals(CardName.WILD)){
            WildStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }else if(discardPile.getCard().getName().equals(CardName.REVERSE)){
            ReverseStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }else if(discardPile.getCard().getName().equals(CardName.DRAW_TWO)){
            DrawTwoStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }else{
            NumberStrategy.getInstance().action(discardPile,player,direction,basicDrawPile);
        }

    }
}
