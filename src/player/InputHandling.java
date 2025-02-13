package player;

import player.abstractclasses.IInputHandling;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputHandling implements IInputHandling {
    private static InputHandling instance;
    private Scanner myScanner;
    private int playersNum;
    private String[] playersNames;

    private InputHandling(){
        this.myScanner = new Scanner(System.in);
        Set<String> uniqueNames = new HashSet<>();


        System.out.print("Please enter the number of players : ");

        while (!myScanner.hasNextInt()) {
            System.out.println("That's not a valid integer. Please enter a valid number.");
            myScanner.next();
        }

        this.playersNum = myScanner.nextInt();
        while( playersNum<2 || playersNum>10) {
            System.out.print("Please enter a valid number of players between 2 and 10 : ");
            playersNum = myScanner.nextInt();
        }
        playersNames = new String[playersNum];
        for(int i = 0; i < playersNum; i++) {
            System.out.print("Player " + (i + 1) + " : ");
            playersNames[i] = myScanner.next().trim();
            while(uniqueNames.contains(playersNames[i])) {
                System.out.println("Name already in use");
                System.out.print("Player " + (i + 1) + " : ");
                playersNames[i] = myScanner.next().trim();

            }
            uniqueNames.add(playersNames[i]);

        }

    }

    public static InputHandling getInstance(){
        if(instance == null) {
            instance = new InputHandling();
        }
        return instance;
    }

    public int getPlayersNum() {
        return this.playersNum;
    }

    public void setPlayersNum(int playersNum) {
        this.playersNum = playersNum;
    }

    public String[] getPlayersNames() {
        return this.playersNames;
    }

    public void setPlayersNames(String[] playersNames) {
        this.playersNames = playersNames;
    }
}


