package softwaredesign;
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintStream;

public class RockPaperScissors {

    public static void playGame(JTextArea textArea) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int playerScore = 0;
        int computerScore = 0;
        int moneyEarned = 0;

        // Redirect standardOut to JTextArea
        PrintStream standardOut = System.out;   // Save reference to standardOut, in case it needs to be used later
        PrintStream printStream = new PrintStream(new customOutputStream(textArea));  // Redirect standardOut to JTextArea
        System.setOut(printStream);

        System.out.println("Let's play Rock-Paper-Scissors!");

        while (true) {
            System.out.println("Choose your move: 1 = Rock, 2 = Paper, 3 = Scissors");
            int playerMove = scanner.nextInt();
            int computerMove = random.nextInt(3) + 1;
            String result = "";

            if (playerMove == 1 && computerMove == 2 ||
                    playerMove == 2 && computerMove == 3 ||
                    playerMove == 3 && computerMove == 1) {
                result = "You lose!";
                computerScore++;
            } else if (playerMove == computerMove) {
                result = "It's a tie!";
            } else {
                result = "You win!";
                playerScore++;
                moneyEarned += 10; // player earns €10 for each win
            }

            System.out.println("You chose " + moveToString(playerMove) + ".");
            System.out.println("The computer chose " + moveToString(computerMove) + ".");
            System.out.println(result);

            System.out.println("Your score: " + playerScore);
            System.out.println("Computer score: " + computerScore);
            System.out.println("Money earned: $" + moneyEarned);

            System.out.println("Do you want to play again? (y/n)");
            String playAgain = scanner.next();

            if (!playAgain.equals("y")) {
                break;
            }
        }
    }

    private static String moveToString(int move) {
        if (move == 1) {
            return "Rock";
        } else if (move == 2) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
}