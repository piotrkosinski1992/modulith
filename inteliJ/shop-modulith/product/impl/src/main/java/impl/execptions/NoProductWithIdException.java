package impl.execptions;

public class NoProductWithIdException extends RuntimeException {

    public NoProductWithIdException(Long id) {
        super("No product with id: " + id);
    }
}
