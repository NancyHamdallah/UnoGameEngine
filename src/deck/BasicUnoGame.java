package deck;

import card.CardName;
import card.UnoCard;
import deck.abstractClasses.Game;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;
import player.PlayerManagementImpl;
import player.abstractclasses.IInputHandling;
import player.abstractclasses.IPlayerManagement;
import strategy.StrategyManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicUnoGame extends Game {

    private IDiscardPile discardPile;
    private Direction direction;
    public BasicUnoGame(IInputHandling inputHandling, IPlayerManagement iPlayerManagement,IBasicDrawPile drawPile) {
        super(inputHandling, iPlayerManagement, drawPile);
        direction = Direction.CLOCKWISE;

    }
    @Override
    public void play() throws InterruptedException {

        super.play();
        dealCards();
        UnoCard firstCard = firstCardOnDiscardPile();
        // rule : if first card is WILD_DRAW_FOUR then re-draw
        while (firstCard.getName().equals(CardName.WILD_DRAW_FOUR)) {
            firstCard = firstCardOnDiscardPile();
        }
        while(true){
            Player currentPlayer = this.players[playerIndex];

            UnoCard discardCard = discardPile.getCard();
            System.out.print("Discard Card : " );
            discardCard.printCard(discardCard);
            System.out.println();
            System.out.print("Player " + currentPlayer.getName() + " cards are : ");
            currentPlayer.viewPlayerCards();
            System.out.println();
            StrategyManager strategyManager = new StrategyManager(discardPile,currentPlayer,direction,drawPile);
            direction = strategyManager.performStrategy();
            //discardPile.setChecked(!discardPile.isChecked());
            updatePlayerTurn();



        }



    }


    private void updatePlayerTurn() {

        // Update the player index based on the direction of play
        if (direction == Direction.CLOCKWISE) {
            // Move to the next player (move forward in the array)
            playerIndex = (playerIndex + 1) % players.length;
        } else if (direction == Direction.COUNTERCLOCKWISE) {
            // Move to the previous player (move backward in the array)
            playerIndex = (playerIndex - 1 + players.length) % players.length;
        }
    }
    @Override
    public void dealCards() {

        for(int i = 0;i< players.length;i++){
            ArrayList<UnoCard> cards = players[i].getPlayerCards();
            if(cards==null){
                cards = new ArrayList<>();
            }
            for(int j = 0;j<players[i].getCardsCount();j++){
                cards.add(this.drawPile.drawCard());
            }
            players[i].setPlayerCards(cards);

        }
    }

    public UnoCard firstCardOnDiscardPile() {
        this.discardPile = new DiscardPile();
        UnoCard firstUnoCard = drawPile.drawCard();
        while(!firstUnoCard.isValidFirstCard()){
            drawPile.addCard(firstUnoCard);
            firstUnoCard = drawPile.drawCard();

        }

        discardPile.addCard(firstUnoCard);
        //System.out.print("Discard Card : ");
        //firstUnoCard.printCard(firstUnoCard);
        System.out.println();
        return firstUnoCard;
    }

}
