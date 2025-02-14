package exception;

public class ValidNumberOfPlayersException extends Exception{
    public ValidNumberOfPlayersException(){
        super("Invalid number of players. please enter a number between 2-10");
    }
}
