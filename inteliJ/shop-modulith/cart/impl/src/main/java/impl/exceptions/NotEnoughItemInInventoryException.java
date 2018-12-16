package impl.exceptions;

public class NotEnoughItemInInventoryException extends RuntimeException {

    public NotEnoughItemInInventoryException() {
        super("there is not enough item in inventory: ");
    }
}
