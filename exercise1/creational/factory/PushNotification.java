package exercise1.creational.factory;

public class PushNotification implements Notification {
    private final String deviceId;

    public PushNotification(String deviceId) {
        if (deviceId == null || deviceId.trim().isEmpty()) {
            throw new IllegalArgumentException("Device ID cannot be empty");
        }
        this.deviceId = deviceId;
    }

    @Override
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        System.out.println("Push to device " + deviceId + ": " + message);
    }
}

