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
    public Direction action(IDiscardPile discardPile, Player player, Direction direction, IBasicDrawPile drawPile) {
        ArrayList<UnoCard> playerCards = player.getPlayerCards();
        ArrayList<UnoCard> allowedCards = new ArrayList<>();
        for(UnoCard card : playerCards) {
            if (card.getName() == discardPile.getCard().getName()
                    || card.getColor() == discardPile.getCard().getColor()
                    || card.getName() == CardName.WILD_DRAW_FOUR
                    || card.getName() == CardName.WILD
            ) {
                allowedCards.add(card);
            }
        }

            System.out.print("Allowed Cards to drop are: ");
            if(allowedCards.isEmpty()){
                System.out.println("No cards to drop. You have to draw a card and your turn ends.");
                playerCards.add(drawPile.drawCard());

            }
            else {
                System.out.println();
                for (int i = 0; i < allowedCards.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    allowedCards.get(i).printCard(allowedCards.get(i));
                    System.out.println();
                }

                System.out.print("Choose one of them to drop: ");
                UnoCard droppedCard = dropCard(allowedCards);
                if(playerCards.isEmpty()){
                    System.out.println("Winner Winner .. Chicken Dinner");
                    System.out.println(player.getName() + " is the winner :) ");
                    System.exit(0);
                }
                if (droppedCard.getName() == CardName.WILD_DRAW_FOUR
                        || droppedCard.getName() == CardName.WILD) {
                    System.out.println("You dropped the wild card.Choose Color: 1.RED 2.BLUE 3.GREEN 4.YELLOW");
                    int index = checkValidChoice(4);
                    switch (index) {
                        case 1:
                            droppedCard.setColor(CardColor.RED);
                            break;
                        case 2:
                            droppedCard.setColor(CardColor.BLUE);
                            break;
                        case 3:
                            droppedCard.setColor(CardColor.GREEN);
                            break;
                        case 4:
                            droppedCard.setColor(CardColor.YELLOW);
                            break;

                    }
                }
                else if(droppedCard.getName() == CardName.REVERSE){
                    direction = ReverseStrategy.getInstance().action(discardPile, player, direction, drawPile);

                }
                    //remove card from player's cardslist and add it to the discard pile
                    playerCards.remove(droppedCard);
                    discardPile.addCard(droppedCard);
                    discardPile.setChecked(false);

            }
            return direction;
        }


    public UnoCard dropCard(ArrayList<UnoCard> allowedCards){
        int index = checkValidChoice(allowedCards.size());

        return allowedCards.get(index-1);

    }
    public int checkValidChoice(int highestRange){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= highestRange) {
                    break;
                } else {
                    System.out.println("Please enter a valid number between 1 and " + highestRange);
                }
            } else {
                System.out.println("Please enter a valid number between 1 and " + highestRange);
                scanner.next();
            }
        }
        return choice;
    }
}
