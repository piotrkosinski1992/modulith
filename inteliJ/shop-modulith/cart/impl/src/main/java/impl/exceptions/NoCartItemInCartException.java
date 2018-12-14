package impl.exceptions;

public class NoCartItemInCartException extends RuntimeException {

    public NoCartItemInCartException() {
        super("deleted cart item doesn't exist");
    }
}
