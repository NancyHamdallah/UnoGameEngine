package deck;

import card.UnoCard;
import deck.abstractClasses.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicUnoGame extends Game {
    private Player[] players;
    private BasicDrawPile drawPile;
    private DiscardPile discardPile;
    @Override
    public void play() {
        super.play();
    }

    @Override
    public void createPlayers(String[] playersNames) {
        int cardsCount = 7;
        this.players = new Player[playersNames.length];
        for(int i = 0; i < playersNames.length; i++) {
            players[i] = new Player(playersNames[i],cardsCount);
        }
    }

    @Override
    public void drawPile() {
        this.drawPile = BasicDrawPile.getInstance();
        drawPile.resetDrawPile();
        drawPile.shuffleDrawPile();
    }

    @Override
    public void firstPlayerTurn() {
        Map<String,Integer> playersCards = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            UnoCard playerCard = drawPile.drawCard();
            players[i].setCheckTurnCard(playerCard);
            playersCards.put(players[i].getName(), playerCard.getValue());
        }
        ////////////// loop to find max value and if two are equal then re-draw cards
    }

    @Override
    public void dealCards() {

    }
}
