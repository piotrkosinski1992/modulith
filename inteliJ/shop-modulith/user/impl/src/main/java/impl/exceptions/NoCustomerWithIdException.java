package impl.exceptions;

public class NoCustomerWithIdException extends RuntimeException {

    public NoCustomerWithIdException(Long id) {
        super("No customer with id: " + id);
    }
}
