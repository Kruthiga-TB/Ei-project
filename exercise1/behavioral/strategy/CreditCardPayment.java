package exercise1.behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be empty");
        }
        String digits = cardNumber.replaceAll("[^0-9]", "");
        if (digits.length() < 13 || digits.length() > 19) {
            throw new IllegalArgumentException("Card number must be 13-19 digits");
        }
        this.cardNumber = digits;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > 50000) {
            throw new IllegalArgumentException("Amount cannot exceed 50000");
        }
        System.out.println("Processing credit card payment: " + maskCard() + " for amount: " + amount);
        return true;
    }

    private String maskCard() {
        if (cardNumber.length() < 4) return "****";
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}