/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmsimulation;

import atmsimulation.bl.ATM;
import atmsimulation.entity.BankAccount;
import java.util.Scanner;

/**
 *
 * @author Simphiwe-2021
 */
public class AtmSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankAccount account = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: R");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: R");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    }
    
