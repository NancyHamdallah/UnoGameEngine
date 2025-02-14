package exception;

public class ValidInputFormatException extends Exception{
    public ValidInputFormatException(){
        super("Invalid input format. Please enter an integer.");
    }
}
