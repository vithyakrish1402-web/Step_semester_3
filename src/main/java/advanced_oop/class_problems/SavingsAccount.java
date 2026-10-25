package advanced_oop.class_problems;

public class SavingsAccount extends Account {

    public SavingsAccount(String id, int initialBalance) {
        super(id, initialBalance);
    }

    @Override
    public void withdraw(int amount) {
        if (getBalance() - amount < 1000) {
            System.out.println(getId() + " rejected: minimum balance 1000");
        } else {
            setBalance(getBalance() - amount);
            System.out.println(getId() + " balance " + getBalance());
        }
    }
}
