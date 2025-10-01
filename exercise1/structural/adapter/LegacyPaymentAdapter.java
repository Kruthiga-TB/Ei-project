package exercise1.structural.adapter;

public class LegacyPaymentAdapter implements ModernPayment {
    private final LegacyPaymentSystem legacy;

    public LegacyPaymentAdapter(LegacyPaymentSystem legacy) {
        if (legacy == null) {
            throw new IllegalArgumentException("Legacy system cannot be null");
        }
        this.legacy = legacy;
    }

    @Override
    public boolean pay(String accountId, double amount) {
        // Input validation
        if (accountId == null || accountId.trim().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be empty");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > 50000) {
            throw new IllegalArgumentException("Amount cannot exceed ₹50,000");
        }

        // Adapt the account ID format (remove non-digits)
        String digits = accountId.replaceAll("[^0-9]", "");

        if (digits.length() < 13 || digits.length() > 19) {
            throw new IllegalArgumentException("Invalid card number length");
        }

        // Use legacy system with adapted input
        return legacy.makePayment(digits, amount);
    }
}