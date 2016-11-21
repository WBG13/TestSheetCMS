package controller.errors;

public class DocumentStatusTransitionError extends Throwable {
    private String message;

    public String GetMessage() {
        return message;
    }

    public DocumentStatusTransitionError(String message) {
        this.message = message;
    }
}
