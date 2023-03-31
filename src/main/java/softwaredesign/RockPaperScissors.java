package softwaredesign;
import softwaredesign.Users.User;
import softwaredesign.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.Random;

import static softwaredesign.TamagotchiGUI.user;

public class RockPaperScissors extends JFrame {

    private JFrame frame;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JButton endGameButton;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private JPanel moneyPanel;
    private JLabel notice;
    private JLabel money;
    private Random random = new Random();
    private int playerScore = 0;
    private int studentScore = 0;
    private int moneyEarned = 0;
    private String noticeLoss = "You lost! Try again.";
    private String noticeWin = "You win! Here is €10!";
    private String noticeTie = "It's a tie! Try again.";

    public void playGame() {
        moneyEarned = 0;
        setupWindowFrame("A student approaches you, daring you to play Rock, Paper, Scissors for a bet!");

    }

    private String moveToString(int move) {
        if (move == 1) {
            return "Rock";
        } else if (move == 2) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    private void makeChoice(int choice){
        // choice = 1 = rock, 2 = paper, 3 = scissors
        int playerMove = choice;
        int computerMove = random.nextInt(3) + 1;

        if (playerMove == 1 && computerMove == 2 ||
                playerMove == 2 && computerMove == 3 ||
                playerMove == 3 && computerMove == 1) {
            notice.setText("The student wins!");
            studentScore++;
        } else if (playerMove == computerMove) {
            notice.setText("It's a tie!");
        } else {
            notice.setText("You win! Good job!");
            playerScore++;
            // Connect money to gameMoney
            moneyEarned += 10; // player earns €10 for each win
            user.updateBalance(10);
            money.setText("Money: " + moneyEarned);
        }
        notice.repaint();

        // Keep for programming purposes, to see if it still works
        //Output to jLabel
        System.out.println("You chose " + moveToString(playerMove) + ".");
        System.out.println("The student chose " + moveToString(computerMove) + ".");

        // Output to JLabel
        System.out.println("Your score: " + playerScore);
        System.out.println("Computer score: " + studentScore);
        System.out.println("Money earned: $" + moneyEarned);
    }

    private void setupPanels(String noticeString){
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        endGameButton = new JButton("Return to class");
        notice = new JLabel(noticeString);
        money = new JLabel("Money: 0");

        buttonPanel = new JPanel();
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(endGameButton);

        textPanel = new JPanel();
        textPanel.add(notice);

        moneyPanel = new JPanel();
        moneyPanel.add(money);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(textPanel, BorderLayout.SOUTH);
        frame.add(moneyPanel, BorderLayout.EAST);

        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeChoice(1);
                // Redraw notice panel
                textPanel.revalidate();
                textPanel.repaint();
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeChoice(2);
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeChoice(3);
            }
        });
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                //TamagotchiGUI.updateFrame();
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private void setupWindowFrame(String noticeString){
        // Create RockPaperScissors JFrame

        frame = new JFrame();
        frame.setTitle("Earn money with Rock, Paper, Scissors!");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //window can be closed
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        setupPanels(noticeString);

//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                Login.infopage.updateFrame();
//            }
//        });
    }
}