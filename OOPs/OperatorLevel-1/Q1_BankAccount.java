// Q1_BankAccount.java
// Sample Program 1: Bank Account System
// Demonstrates static, this, final, and instanceof best practices

public class Q1_BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;

    public Q1_BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        Q1_BankAccount acc1 = new Q1_BankAccount("Alice", 1001);
        Q1_BankAccount acc2 = new Q1_BankAccount("Bob", 1002);
        Object obj = acc1;
        if (obj instanceof Q1_BankAccount) {
            ((Q1_BankAccount) obj).displayDetails();
        }
        System.out.println("Total Accounts: " + Q1_BankAccount.getTotalAccounts());
    }
}
