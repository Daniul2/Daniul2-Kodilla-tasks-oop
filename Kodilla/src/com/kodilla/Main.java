package com.kodilla;

interface ATM {
    void deposit(double amount);
    void withdraw(double amount);

    default void connectToBank() {
    }

    static void endSession() {
        System.out.println("ATM session ended.");
    }
}

class ATMImpl implements ATM {
    private double balance;

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ". Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Balance: " + balance);
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ". Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATMImpl();

        atm.connectToBank();

        atm.deposit(200);
        atm.withdraw(50);

        ATM.endSession();
    }
}
