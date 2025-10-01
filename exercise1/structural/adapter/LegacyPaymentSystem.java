package exercise1.structural.adapter;

public class LegacyPaymentSystem {
    public boolean makePayment(String cardNumber, double value) {
        System.out.println("Legacy processed: " + maskCard(cardNumber) + " -> ₹" + value);
        return true;
    }

    private String maskCard(String card) {
        if (card == null || card.length() < 4) return "****";
        return "****-****-****-" + card.substring(card.length() - 4);
    }
}