package impl.exceptions;

public class NotUniqueUnsernameException extends RuntimeException {

    public NotUniqueUnsernameException(String username) {
        super("Customer with username " + username + " already exists");
    }
}
