package ipplanmanager;

// Cette classe définit ton propre type d'erreur
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}