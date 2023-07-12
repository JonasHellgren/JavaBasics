package pluralsight_new_in_java17.java17_best_practices.m4objectsAfter.src;

public class BankAccount {

    private double balance;
    private double interest;

    BankAccount() {

    }

    BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Starting balance can't be less than 0");
        }
        this.balance = balance;
    }

    BankAccount(double balance, double interest) {
        if (interest < 0) {
            throw new IllegalArgumentException("Interest rate can't be less than 0");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Starting balance can't be less than 0");
        }
        this.balance = balance;
        this.interest = interest;
    }
}
