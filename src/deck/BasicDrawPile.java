package deck;

import card.CardColor;
import card.CardName;
import card.UnoCard;
import deck.abstractClasses.IBasicDrawPile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicDrawPile implements IBasicDrawPile {
    private static BasicDrawPile instance;
    private ArrayList<UnoCard> cards;
    private int numCards;

    private BasicDrawPile(int numCards) {
        this.cards = new ArrayList<>(numCards);
        this.numCards = numCards;
    }
    public static BasicDrawPile getInstance() {
        if(instance == null) {
            instance = new BasicDrawPile(108);// number of cards is 108

        }
        return instance;
    }

    public void drawPile() {
        instance.resetDrawPile();
        instance.shuffleDrawPile();
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

    public ArrayList<UnoCard> drawCards(int count){
        ArrayList<UnoCard> cards = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            cards.add(this.drawCard());
        }
        return cards;
    }
    public boolean isEmpty(){
        return this.cards.isEmpty();
    }
    public void addCard(UnoCard card){
        this.cards.addFirst(card);
        this.numCards++;
    }
    public void addCards(ArrayList<UnoCard> cards){
        for(UnoCard card : cards){
            this.cards.addFirst(card);
            this.numCards++;
        }

    }

    public ArrayList<UnoCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<UnoCard> cards) {
        this.cards = cards;
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }
}
