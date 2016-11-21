package controller.errors;

public class DocumentValidationError extends Throwable {
    private String message;

    public String GetMessage() {
        return message;
    }

    public DocumentValidationError(String message) {
        this.message = message;
    }
}
