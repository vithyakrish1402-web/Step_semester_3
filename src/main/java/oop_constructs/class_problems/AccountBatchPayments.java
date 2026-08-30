package oop_constructs.class_problems;

class FeeAccount {
    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class AccountBatchPayments {

    public static void processPayment(FeeAccount account, double amount) {
        account.pay(amount);
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        int hostelCount = 0;
        int dayScholarCount = 0;
        double amount = 60000;

        for (int i = 0; i < accounts.length; i++) {
            FeeAccount account = accounts[i];
            processPayment(account, amount);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else if (account instanceof FeeAccount) {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
