package bo.edu.ucbcba.group1v2.exceptions;

/**
 * Created by Usuario on 12/05/2016.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super("Validation error: " + message);
    }
}
