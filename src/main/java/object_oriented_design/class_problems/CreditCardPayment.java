package object_oriented_design.class_problems;

public class CreditCardPayment implements PaymentMethod {

    private String cardNumber;
    private boolean shouldSucceed;

    public CreditCardPayment(String cardNumber) {
        this(cardNumber, true);
    }

    public CreditCardPayment(String cardNumber, boolean shouldSucceed) {
        this.cardNumber = cardNumber;
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }

    @Override
    public String getMethodName() {
        return "Credit Card";
    }
}
