package strategy;

import card.CardColor;
import card.CardName;
import card.UnoCard;
import deck.BasicDrawPile;
import deck.Direction;
import deck.DiscardPile;
import deck.abstractClasses.IBasicDrawPile;
import deck.abstractClasses.IDiscardPile;
import player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberStrategy implements IActionStrategy{
    public static NumberStrategy getInstance(){
        return new NumberStrategy();
    }
    public void action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        ArrayList<UnoCard> playerCards = player.getPlayerCards();
        for(UnoCard card : playerCards){
            if(card.getName() == discardPile.getCard().getName()
            || card.getColor() == discardPile.getCard().getColor() ){
                playerCards.remove(card);
                player.setCardsCount(playerCards.size());
                discardPile.addCard(card);
            }
            else if( card.getName() == CardName.WILD_DRAW_FOUR){
                playerCards.remove(card);
                player.setCardsCount(playerCards.size());
                discardPile.addCard(card);
                System.out.print("Choose color : 1.Blue 2.Red 3.Yellow 4.Green ");
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                while(!sc.hasNextInt()){
                    System.out.println(("Please enter a number between 1 and 4");
                    num = sc.nextInt();
                }
                switch(num){
                    case 1: 
                }
            }
        }
    }
}
