package com.Houts;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static Random random;
    private static int secretNumber;
    private static int numberOfTries;
    private static String userName;

    public static void main(String[] args) {
        random = new Random();
        scanner = new Scanner(System.in);
        numberOfTries = 0;
        randomNumber();
        System.out.println("Hello! What is your name");
        userName = scanner.nextLine();
        System.out.println("Well, " + userName + ", I am thinking of a number between 1 and 20.\n");
        takeAGuess();
    }

    // Generates the secret number.
    private static void randomNumber() {
        secretNumber = random.nextInt(20)+1;
    }

    // Used after a game is complete. User has the option to play again
    // or exit the game. Playing again will reset numberOfTries to 0.
    // Call a new secret number, and call the takeAGuess method again to restart game.
    // Method called from the takeAGuess method if user wins or numberOfTries is greater than 6.
    private static void playAgain() {
        System.out.println("Would you like to play again? (y or n)");
        scanner.nextLine();
        String option = scanner.nextLine();
        if(option.equals("y")) {
            System.out.println("Great, lets play!");
            numberOfTries = 0;
            randomNumber();
            takeAGuess();
        }
        else {
            System.out.println("Thanks for playing! Good bye.");
            return;
        }
    }

    // Tracks number of tries using numberOfTries variable.
    // Compares secret number to user inputs.
    // Exceptions are caught, user is prompted to enter numbers and takeAGuess method is called again
    private static void takeAGuess() {
        if(numberOfTries == 6) {
            System.out.println("Sorry, you exceeded the number of tries.");
            playAgain();
        }
        System.out.println("Take a guess (1 to 20)");
        try{
            int userGuess = scanner.nextInt();
            numberOfTries++;

            if(userGuess == secretNumber) {
                System.out.println("Good job, " + userName + " You guessed my number in " + numberOfTries + " guesses!");
                playAgain();
            }
            else if(userGuess < secretNumber) {
                System.out.println("Your guess is too low.");
                takeAGuess();
            }
            else if(userGuess > secretNumber) {
                System.out.println("Your guess is too high");
                takeAGuess();
            }
        }
        catch(Exception e) {
            System.out.println("Please enter a valid number between 1 and 20");
            scanner.nextLine();
            takeAGuess();
        }
    }
}
