package Encapsulation;

// Interface for Loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class for Bank Accounts
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters (Encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.05;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings account loan application for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 5000;
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current account loan application for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 10000;
    }
}

// Main class to demonstrate polymorphism
public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount account1 = new SavingsAccount("S101", "Alice", 8000);
        BankAccount account2 = new CurrentAccount("C202", "Bob", 15000);

        // Polymorphic Interest Calculation
        System.out.println("Interest for " + account1.getHolderName() + ": " + account1.calculateInterest());
        System.out.println("Interest for " + account2.getHolderName() + ": " + account2.calculateInterest());

        // Demonstrating deposit and withdraw
        account1.deposit(2000);
        account2.withdraw(3000);

        // Demonstrating Loanable interface
        Loanable loanable1 = (Loanable) account1;
        Loanable loanable2 = (Loanable) account2;

        loanable1.applyForLoan(10000);
        System.out.println("Loan Eligibility (Savings): " + loanable1.calculateLoanEligibility());

        loanable2.applyForLoan(20000);
        System.out.println("Loan Eligibility (Current): " + loanable2.calculateLoanEligibility());
    }
}

