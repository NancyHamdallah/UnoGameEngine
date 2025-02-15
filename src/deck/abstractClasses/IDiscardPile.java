package deck.abstractClasses;

import card.UnoCard;

import java.util.ArrayList;

public interface IDiscardPile {

    void addCard(UnoCard card);
    UnoCard getCard();
    ArrayList<UnoCard> getCards();
    boolean isChecked();
    void setChecked(boolean checked);
}


