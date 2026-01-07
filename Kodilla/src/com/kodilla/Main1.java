package com.kodilla;

abstract class BankTransaction {

    public final void runTransaction() {
        askForCard();
        askForPin();
        askForAmount();

        bankAcceptsRequest();     // BANK
        checkAccountBalance();    // BANK
        confirmWithdrawal();      // BANK

        dispenseCash();
        thankCustomer();
    }

    // ATM steps (implemented by subclass)
    protected abstract void askForCard();
    protected abstract void askForPin();
    protected abstract void askForAmount();
    protected abstract void dispenseCash();
    protected abstract void thankCustomer();

    // Bank steps (always the same)
    protected void bankAcceptsRequest() {
        System.out.println("Bank: Withdrawal request accepted.");
    }

    protected void checkAccountBalance() {
        System.out.println("Bank: Checking account balance.");
    }

    protected void confirmWithdrawal() {
        System.out.println("Bank: Withdrawal approved.");
    }
}

class ATMTransaction extends BankTransaction {

    @Override
    protected void askForCard() {
        System.out.println("ATM: Please insert your card.");
    }

    @Override
    protected void askForPin() {
        System.out.println("ATM: Please enter your PIN.");
    }

    @Override
    protected void askForAmount() {
        System.out.println("ATM: Please enter the amount to withdraw.");
    }

    @Override
    protected void dispenseCash() {
        System.out.println("ATM: Dispensing cash.");
    }

    @Override
    protected void thankCustomer() {
        System.out.println("ATM: Thank you for using our bank.");
    }
}

public class Main1 {
    public static void main(String[] args) {
        BankTransaction transaction = new ATMTransaction();
        transaction.runTransaction();
    }
}
