package deck.abstractClasses;

import card.UnoCard;

public interface IDiscardPile {

    void addCard(UnoCard card);
    UnoCard getCard();
    boolean isChecked();
    void setChecked(boolean checked);
}
