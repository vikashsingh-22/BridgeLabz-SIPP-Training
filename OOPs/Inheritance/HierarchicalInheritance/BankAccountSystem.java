package Inheritance.HierarchicalInheritance;

// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass 1: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayDetails();
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass 3: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int lockInPeriod; // in months

    public FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayDetails();
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

// Main class to test the accounts
public class BankAccountSystem { 
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", 15000.0, 3.5);
        CheckingAccount ca = new CheckingAccount("CA456", 10000.0, 2000.0);
        FixedDepositAccount fda = new FixedDepositAccount("FDA789", 50000.0, 12);

        System.out.println("--- Savings Account ---");
        sa.displayAccountType();

        System.out.println("\n--- Checking Account ---");
        ca.displayAccountType();

        System.out.println("\n--- Fixed Deposit Account ---");
        fda.displayAccountType();
    }
}
