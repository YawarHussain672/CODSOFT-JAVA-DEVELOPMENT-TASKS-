import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;

        int attempts = 5;

        boolean playing = true;
        while (playing) {
            
            int randomNumber = random.nextInt(max - min + 1) + min;

            int attemptsRemaining = attempts;

            boolean guessed = false;
            while (attemptsRemaining > 0 && !guessed) {
                System.out.println("Guess a number between " + min + " and " + max + ": ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    guessed = true;
                    System.out.println("You guessed it! The number was " + randomNumber + ".");
                } else if (guess < randomNumber) {
                    System.out.println("Too low! You have " + (attemptsRemaining - 1) + " attempts remaining.");
                } else {
                    System.out.println("Too high! You have " + (attemptsRemaining - 1) + " attempts remaining.");
                }

                attemptsRemaining--;
            }

            if (!guessed) {
                System.out.println("You ran out of attempts! The number was " + randomNumber + ".");
            }

            System.out.println("Play again? (y/n)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                playing = false;
            }
        }

        System.out.println("Thanks for playing!");
    }
}