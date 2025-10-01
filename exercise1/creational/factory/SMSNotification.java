package exercise1.creational.factory;

public class SMSNotification implements Notification {
    private final String phoneNumber;

    public SMSNotification(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        if (message.length() > 160) {
            throw new IllegalArgumentException("SMS message too long (max 160 characters)");
        }
        System.out.println("SMS to " + phoneNumber + ": " + message);
    }

}
