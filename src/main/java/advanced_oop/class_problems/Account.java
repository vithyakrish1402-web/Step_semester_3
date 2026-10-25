package advanced_oop.class_problems;

public abstract class Account {

    private String id;
    private int balance;

    public Account(String id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public abstract void withdraw(int amount);
}
