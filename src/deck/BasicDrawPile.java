package deck;

import card.CardColor;
import card.CardName;
import card.UnoCard;

import java.util.ArrayList;
import java.util.Collections;

public class BasicDrawPile {
    private static BasicDrawPile instance;
    private ArrayList<UnoCard> cards;
    private int numCards;

    private BasicDrawPile(int numCards) {
        this.cards = new ArrayList<>(numCards);
    }

    public static BasicDrawPile getInstance() {
        if(instance == null) {
            instance = new BasicDrawPile(108);// number of cards is 108
        }
        return instance;
    }

    public void resetDrawPile(){
        for(int i = 0; i < CardColor.values().length-1; i++){
            for(int j = 0; j < CardName.values().length-2; j++){
                if(j!=0){
                    UnoCard card1 = new UnoCard(CardColor.getColor(i), CardName.getName(j));
                    this.cards.add(card1);
                }
                UnoCard card2 = new UnoCard(CardColor.getColor(i), CardName.getName(j));
                this.cards.add(card2);
            }
        }
        for(int i = CardName.values().length-2; i < CardName.values().length; i++){
            for(int j = 0; j < 4; j++){
                UnoCard card = new UnoCard(CardColor.WILD, CardName.getName(i));
                this.cards.add(card);
            }
        }
        this.numCards = this.cards.size();

    }

    public void shuffleDrawPile(){
        Collections.shuffle(this.cards);
    }

    public UnoCard drawCard(){
        this.numCards--;
        return this.cards.removeLast();
    }

    public boolean isEmpty(){
        return this.cards.isEmpty();
    }
}
