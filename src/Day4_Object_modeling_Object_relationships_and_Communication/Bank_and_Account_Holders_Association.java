import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private double balance;
    private Bank bank; 
    public Customer(String name, double initialBalance, Bank bank) {
        this.name = name;
        this.balance = initialBalance;
        this.bank = bank;
    }

    public void viewBalance() {
        System.out.println(name + "'s Balance:" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(name + " deposited :" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(name + " withdrew :" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public String getName() {
        return name;
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(String customerName, double initialBalance) {
        Customer customer = new Customer(customerName, initialBalance, this);
        customers.add(customer);
        System.out.println("Account opened for " + customerName + " in " + bankName);
    }

    public void showAllCustomers() {
        System.out.println("Customers in " + bankName + ":");
        for (Customer c : customers) {
            System.out.println("- " + c.getName());
        }
    }
}

public class Bank_and_Account_Holders_Association {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank of India");

        bank1.openAccount("Vikash", 5000);
        bank1.openAccount("sumit", 8000);

        System.out.println();
        bank1.showAllCustomers();

        System.out.println();
        Customer customer1 = new Customer("Rahul", 10000, bank1);
        customer1.viewBalance();
        customer1.deposit(2000);
        customer1.withdraw(5000);
        customer1.viewBalance();
    }
}
