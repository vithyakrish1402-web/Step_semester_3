package advanced_oop.class_problems;

public class CurrentAccount extends Account {

    public CurrentAccount(String id, int initialBalance) {
        super(id, initialBalance);
    }

    @Override
    public void withdraw(int amount) {
        if (getBalance() - amount < -5000) {
            System.out.println(getId() + " rejected: overdraft limit 5000");
        } else {
            setBalance(getBalance() - amount);
            System.out.println(getId() + " balance " + getBalance());
        }
    }
}
