package object_oriented_design.class_problems;

public class BankTransferPayment implements PaymentMethod {

    private String accountNumber;
    private boolean shouldSucceed;

    public BankTransferPayment(String accountNumber) {
        this(accountNumber, true);
    }

    public BankTransferPayment(String accountNumber, boolean shouldSucceed) {
        this.accountNumber = accountNumber;
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }

    @Override
    public String getMethodName() {
        return "Bank Transfer";
    }
}
