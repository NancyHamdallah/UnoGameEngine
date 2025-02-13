package deck.abstractClasses;

import card.UnoCard;

public interface IDiscardPile {
    public void addCard(UnoCard card);
    public UnoCard getCard();
}
