package codesoft_3;

import java.util.Scanner;

public class Atm {

    // Class to represent the user's bank account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                System.out.println("Initial balance cannot be negative. Setting balance to $0.");
                this.balance = 0;
            }
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount. Please enter a positive amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrawn: $" + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient balance. Withdrawal failed.");
            } else {
                System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
            }
        }

        public void checkBalance() {
            System.out.println("Current balance: $" + balance);
        }
    }

    // Class to represent the ATM machine
    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void showMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        account.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        }
    }

    // Main method to run the ATM program
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500);  // Initialize with an initial balance of $500
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
