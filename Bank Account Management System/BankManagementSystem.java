import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(" Amount Deposited Successfully!");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(" Amount Withdrawn Successfully!");
        } else {
            System.out.println(" Insufficient Balance!");
        }
    }

    void display() {
        System.out.println("Account No: " + accountNumber +
                ", Name: " + name +
                ", Balance: ₹" + balance);
    }
}

public class BankManagementSystem {

    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new BankAccount(accNo, name, balance));
        System.out.println(" Account Created Successfully!");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();
                    BankAccount depAccount = findAccount(depAcc);
                    if (depAccount != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amount = sc.nextDouble();
                        depAccount.deposit(amount);
                    } else {
                        System.out.println(" Account Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();
                    BankAccount withAccount = findAccount(withAcc);
                    if (withAccount != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amount = sc.nextDouble();
                        withAccount.withdraw(amount);
                    } else {
                        System.out.println(" Account Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int balAcc = sc.nextInt();
                    BankAccount balAccount = findAccount(balAcc);
                    if (balAccount != null) {
                        balAccount.display();
                    } else {
                        System.out.println(" Account Not Found!");
                    }
                    break;

                case 5:
                    for (BankAccount acc : accounts) {
                        acc.display();
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}