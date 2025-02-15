package deck.abstractClasses;

import card.CardColor;
import card.CardName;
import card.UnoCard;

import java.util.ArrayList;
import java.util.Collections;

public interface IBasicDrawPile {
    public void drawPile();
    public void resetDrawPile();
    public void shuffleDrawPile();
    public UnoCard drawCard();
    public ArrayList<UnoCard> drawCards(int count);
    public boolean isEmpty();
    public void addCard(UnoCard card);
    public void addCards(ArrayList<UnoCard> cards);
    public ArrayList<UnoCard> getCards();

    }



