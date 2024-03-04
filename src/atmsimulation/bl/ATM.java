/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmsimulation.bl;

import atmsimulation.entity.BankAccount;

/**
 *
 * @author Simphiwe-2021
 */
public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: R" + userAccount.getBalance());
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("R" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("R" + amount + " withdrawn successfully.");
        }
    }
}
