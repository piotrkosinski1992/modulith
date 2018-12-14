package impl.exceptions;

public class NoProductWithIdException extends RuntimeException {

    public NoProductWithIdException(Long productId) {
        super("No product with id: " + productId);
    }
}
