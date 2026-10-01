package object_oriented_design.class_problems;

public interface PaymentMethod {
    boolean processPayment(double amount);
    String getMethodName();
}
