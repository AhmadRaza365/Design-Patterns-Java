import java.util.Scanner;

// Proxy Design Pattern
// 12 December 2022

interface Bank {
    public void withdraw(int amount);
}

class BankAccount implements Bank {
    @Override
    public void withdraw(int amount) {
        System.out.println("Withdrawing " + amount + " from bank account.");
    }
}

class InternetBanking implements Bank {
    private BankAccount bankAccount;

    @Override
    public void withdraw(int amount) {
        System.out.println("Withdrawing using internet banking.");
        if (bankAccount == null) {
            bankAccount = new BankAccount();
        }
        bankAccount.withdraw(amount);
    }
}

class Cheque implements Bank {
    private BankAccount bankAccount;

    @Override
    public void withdraw(int amount) {
        System.out.println("Withdrawing using cheque.");
        if (bankAccount == null) {
            bankAccount = new BankAccount();
        }
        bankAccount.withdraw(amount);
    }
}

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InternetBanking internetBanking = new InternetBanking();

        System.out.println("Select option to withdraw money:");
        System.out.println("1. Internet Banking");
        System.out.println("2. Cheque");
        int option = scanner.nextInt();
        System.out.println("Enter amount to withdraw:");
        int amount = scanner.nextInt();
        if (option == 1) {
            internetBanking.withdraw(amount);
        } else if (option == 2) {
            Cheque cheque = new Cheque();
            cheque.withdraw(amount);
        } else {
            System.out.println("Invalid option.");
        }
    }

}