package object_oriented_design.class_problems;

public class PayPalPayment implements PaymentMethod {

    private String email;
    private boolean shouldSucceed;

    public PayPalPayment(String email) {
        this(email, true);
    }

    public PayPalPayment(String email, boolean shouldSucceed) {
        this.email = email;
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }

    @Override
    public String getMethodName() {
        return "PayPal";
    }
}
