package deck.abstractClasses;

import deck.BasicDrawPile;

import java.util.Scanner;

public abstract class Game {

    public void play() {
        Scanner myScanner = new Scanner(System.in);
        String[] playersNames;
        System.out.print("Please enter the number of players : ");

        while (!myScanner.hasNextInt()) {
            System.out.println("That's not a valid integer. Please enter a valid number.");
            myScanner.next();
        }

        int playersNum = myScanner.nextInt();
        while( playersNum<2 || playersNum>10) {
            System.out.print("Please enter a valid number of players between 2 and 10 : ");
            playersNum = myScanner.nextInt();
        }
        playersNames = new String[playersNum];
        for(int i = 0; i < playersNum; i++) {
            System.out.print("Player "+(i+1)+" : ");
            playersNames[i] = myScanner.next();
        }

        createPlayers(playersNames);
        drawPile();
        firstPlayerTurn();
        dealCards();
        while(true){

        }



    }

    public abstract void createPlayers(String[] playersNames);
    public abstract void drawPile();
    public abstract void firstPlayerTurn();
    public abstract void dealCards();
}
