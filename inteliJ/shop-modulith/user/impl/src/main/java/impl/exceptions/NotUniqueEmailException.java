package impl.exceptions;

public class NotUniqueEmailException extends RuntimeException {
    public NotUniqueEmailException(String email) {
        super("Email exist in database:" + email);
    }
}
