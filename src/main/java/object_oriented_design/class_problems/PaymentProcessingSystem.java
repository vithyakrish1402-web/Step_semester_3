package object_oriented_design.class_problems;

public class PaymentProcessingSystem {

    public static Order createOrder(String orderId, Customer customer) {
        Order order = new Order(orderId, customer);
        System.out.println("Order created for " + customer.getName() + ".");
        return order;
    }

    public static boolean processOrderPayment(Order order, PaymentMethod paymentMethod) {
        if (order.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return false;
        }
        System.out.println("Payment initiated via " + paymentMethod.getMethodName() + " for " + order.getOrderId() + ".");
        boolean success = paymentMethod.processPayment(order.getTotalAmount());
        if (success) {
            order.markPaid();
            System.out.println("Payment for " + order.getOrderId() + " successful. Order status: Paid.");
            return true;
        } else {
            System.out.println("Payment for " + order.getOrderId() + " failed. Order status: Pending.");
            return false;
        }
    }

    public static void main(String[] args) {
        Customer custX = new Customer("Customer X");
        Customer custY = new Customer("Customer Y");
        Customer custZ = new Customer("Customer Z");

        Product prodA = new Product("Product A", 25.0);
        Product prodB = new Product("Product B", 50.0);
        Product prodC = new Product("Product C", 40.0);

        Order orderX = createOrder("Order X", custX);
        orderX.addItem(prodA, 2);
        orderX.addItem(prodB, 1);
        PaymentMethod cc = new CreditCardPayment("1234-5678-9012-3456", true);
        processOrderPayment(orderX, cc);

        Order orderY = new Order("Order Y", custY);
        processOrderPayment(orderY, cc);

        Order orderZ = createOrder("Order Z", custZ);
        orderZ.addItem(prodC, 1);
        PaymentMethod paypalFail = new PayPalPayment("user@example.com", false);
        processOrderPayment(orderZ, paypalFail);
    }
}
