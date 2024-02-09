package epicode.GestionePrenotazione.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(int id) {
        super("This id: " + id + " has not been found");
    }

    public ItemNotFoundException() {
        super("Element not found");
    }
}

