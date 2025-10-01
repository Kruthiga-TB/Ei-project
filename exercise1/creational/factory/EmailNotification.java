package exercise1.creational.factory;

public class EmailNotification implements Notification {
    private final String email;

    public EmailNotification(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    @Override
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        System.out.println("  Email to " + email + ": " + message);
    }
}