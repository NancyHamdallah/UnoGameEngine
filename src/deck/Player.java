package deck;

import card.UnoCard;

import java.util.ArrayList;

public class Player {
    private String name;
    private int cardsCount ;
    private ArrayList<UnoCard> playerCards;
    private UnoCard checkTurnCard;

    public Player(String name, int cardsCount) {
        this.name = name;
        this.cardsCount =  cardsCount;
    }

    public void drawCard(BasicDrawPile basicDrawPile) {
        UnoCard card = basicDrawPile.drawCard();
        playerCards.add(card);
        cardsCount++;
    }

    public void viewPlayerCards() {
        for(UnoCard card : playerCards) {
            card.printCard(card);
        }
    }

    public ArrayList<UnoCard> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<UnoCard> playerCards) {
        this.playerCards = playerCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardsCount() {
        return cardsCount;
    }

    public void setCardsCount(int cardsCount) {
        this.cardsCount = cardsCount;
    }

    public UnoCard getCheckTurnCard() {
        return checkTurnCard;
    }

    public void setCheckTurnCard(UnoCard checkTurnCard) {
        this.checkTurnCard = checkTurnCard;
    }
}
