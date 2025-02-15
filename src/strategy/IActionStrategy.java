package strategy;

import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

public interface IActionStrategy {
    Direction action(IDiscardPile discardPile, Player player
            , Direction direction, IBasicDrawPile drawPile);
}

