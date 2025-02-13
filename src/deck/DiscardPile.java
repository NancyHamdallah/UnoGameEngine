package deck;

import card.UnoCard;
import deck.abstractClasses.IDiscardPile;

import java.util.ArrayList;

public class DiscardPile implements IDiscardPile{
    ArrayList<UnoCard> cards;
    public DiscardPile() {
        this.cards = new ArrayList<>();
    }
    @Override
    public void addCard(UnoCard card){
        cards.add(card);
    }

    @Override
    public UnoCard getCard(){
        return cards.getLast();
    }
}
