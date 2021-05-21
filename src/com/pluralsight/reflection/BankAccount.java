package com.pluralsight.reflection;

public class BankAccount {
    private final String id;
    private int balance;

    BankAccount(String id) {this.id=id;}
    BankAccount(String id,int balance) {this.id=id; this.balance=balance;}

    public String  getId() {return this.id;}
    public int  getBalance() {return this.balance;}
    public void deposit(int amount) {this.balance=this.balance+amount;}
    public void withdrawal(int amount) {this.balance=this.balance-amount;}

}
