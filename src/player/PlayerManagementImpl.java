package player;

import card.UnoCard;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.abstractclasses.IPlayerManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerManagementImpl implements IPlayerManagement {
    private Player[] players;
    private IBasicDrawPile basicDrawPile;
    public PlayerManagementImpl(int playersNum,IBasicDrawPile basicDrawPile) {
        this.players = new Player[playersNum];
        this.basicDrawPile = basicDrawPile;


    }


    @Override
    public Player[] createPlayers(String[] playersNames) {
        int cardsCount = 7;
        this.players = new Player[playersNames.length];
        for(int i = 0; i < playersNames.length; i++) {
            this.players[i] = new Player(playersNames[i],cardsCount);
        }
        return this.players;
    }

    @Override
    public int firstPlayerTurn() {
        this.basicDrawPile.resetDrawPile();
        this.basicDrawPile.shuffleDrawPile();
        int count = 0;
        int playerIndex=0;
        ArrayList<UnoCard> checkCards = new ArrayList<>();
        Map<String, Integer> mapCards = new HashMap<>();
        while(true) {
            int max = 0;

            for (int i = 0; i < players.length; i++) {
                UnoCard playerCard = this.basicDrawPile.drawCard();
                System.out.print(players[i].getName() + " card is : ");
                playerCard.printCard(playerCard);
                System.out.println();
                players[i].setCheckTurnCard(playerCard);
                mapCards.put(players[i].getName(), playerCard.getValue());

            }
            ////////////// loop to find max value and if two are equal then re-deal cards
            for (int i = 0; i < players.length; i++) {
                if(max<mapCards.get(players[i].getName())) {
                    max = mapCards.get(players[i].getName());
                    playerIndex = i;
                }

            }

            //loop to find if there are more than card equals the max then re-deal cards
            for (int mapValue : mapCards.values()) {
                if (mapValue == max) {
                    count++;
                }
            }
            if (count == 1) {
                for(int i = 0; i < players.length; i++) {
                    checkCards.add(players[i].getCheckTurnCard());
                }
                this.basicDrawPile.addCards(checkCards);
                break;
            }
            //clear the map and get back the cards to the pile to re-deal the cards
            System.out.println("Some cards are the same.. re-deal cards ...");
            mapCards.clear();
            //get the cards back to draw pile
            for(int i = 0; i < players.length; i++) {
                checkCards.add(players[i].getCheckTurnCard());
            }
            this.basicDrawPile.addCards(checkCards);
            count = 0 ;
        }

        return playerIndex;
    }

    public IBasicDrawPile getDrawPile() {
        return this.basicDrawPile;
    }

    public void setBasicDrawPile(IBasicDrawPile basicDrawPile) {
        this.basicDrawPile = basicDrawPile;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
