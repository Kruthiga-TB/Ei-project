package exercise1.creational.factory;

public class NotificationFactory {
    public Notification createNotification(String type, String recipient) {
        if (type == null || recipient == null) {
            throw new IllegalArgumentException("Type and recipient cannot be null");
        }

        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification(recipient);
            case "sms":
                return new SMSNotification(recipient);
            case "push":
                return new PushNotification(recipient);
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}