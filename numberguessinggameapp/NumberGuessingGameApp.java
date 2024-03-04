/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numberguessinggameapp;

import java.util.Scanner;
import numberguessinggameapp.bl.NumberGuessingGame;

/**
 *
 * @author Simphiwe-2021
 */
public class NumberGuessingGameApp {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("=====================================");

            NumberGuessingGame game = new NumberGuessingGame(1, 100, 5);
            game.playGame();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            } else {
                roundsWon++;
            }
        }

        System.out.println("Thank you for playing! Your score: " + roundsWon + " rounds won.");
    }
}
