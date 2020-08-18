package exception;

public class CantFindUserException extends Exception{

    public CantFindUserException(String message){
        super(message);
    }
}
