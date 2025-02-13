package deck;

import card.UnoCard;
import deck.abstractClasses.IDiscardPile;

import java.util.ArrayList;

public class DiscardPile implements IDiscardPile{
    private ArrayList<UnoCard> cards;
    private boolean isChecked;
    public DiscardPile() {
        this.cards = new ArrayList<>();
        isChecked = false;
    }
    @Override
    public void addCard(UnoCard card){
        cards.addLast(card);
    }

    @Override
    public UnoCard getCard(){
        return cards.getLast();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public ArrayList<UnoCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<UnoCard> cards) {
        this.cards = cards;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


}
