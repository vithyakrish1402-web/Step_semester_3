package advanced_oop.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccountWithdrawalSystem {

    private Map<String, Account> accounts = new LinkedHashMap<>();

    public void createSavings(String id, int initialBalance) {
        accounts.put(id, new SavingsAccount(id, initialBalance));
    }

    public void createCurrent(String id, int initialBalance) {
        accounts.put(id, new CurrentAccount(id, initialBalance));
    }

    public void processWithdraw(String id, int amount) {
        Account account = accounts.get(id);
        if (account == null) {
            System.out.println("Account not found");
        } else {
            account.withdraw(amount);
        }
    }

    public void executeCommand(String commandLine) {
        if (commandLine == null || commandLine.trim().isEmpty()) {
            return;
        }
        String[] parts = commandLine.trim().split("\\s+");
        String op = parts[0];
        if (op.equalsIgnoreCase("Savings")) {
            createSavings(parts[1], Integer.parseInt(parts[2]));
        } else if (op.equalsIgnoreCase("Current")) {
            createCurrent(parts[1], Integer.parseInt(parts[2]));
        } else if (op.equalsIgnoreCase("WITHDRAW")) {
            processWithdraw(parts[1], Integer.parseInt(parts[2]));
        }
    }

    public static void main(String[] args) {
        BankAccountWithdrawalSystem system = new BankAccountWithdrawalSystem();
        system.executeCommand("Savings S1 5000");
        system.executeCommand("WITHDRAW S1 4500");
        system.executeCommand("Current C1 2000");
        system.executeCommand("WITHDRAW C1 6000");
        system.executeCommand("WITHDRAW S1 3000");
        system.executeCommand("WITHDRAW C1 2000");
    }
}
