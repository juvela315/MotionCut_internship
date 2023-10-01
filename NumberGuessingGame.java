import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int min = 1;
        int max = 100;
        int num = r.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean correctlyGuessed = false;

        System.out.println("----------------------------Number Guessing Game----------------------------");
        System.out.println("Guess a number between " + min + " and " + max );

        while (!correctlyGuessed) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess < min || guess > max) {
                System.out.println("Please enter a number between " + min + " and " + max );
            } else if (guess < num) {
                System.out.println("Too low! Try another guess");
            } else if (guess > num) {
                System.out.println("Too high! Try another guess");
            } else {
                System.out.println("Congratulations! You've guessed the number " + num + " correctly in " + attempts + " attempts");
                correctlyGuessed = true;
            }
        }

        sc.close();
    }
}