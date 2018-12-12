package impl.exceptions;

public class NoCustomerWithUsernameException extends RuntimeException {

    public NoCustomerWithUsernameException(String username) {
        super("No user with username: " + username);
    }
}
