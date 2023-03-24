package softwaredesign;

import softwaredesign.tamagotchis.Professor;
import softwaredesign.tamagotchis.Tamagotchi;

import javax.swing.*;
import java.awt.*;

public class TamagotchiGUI extends JFrame {
    private JPanel jp1;
    private JLabel vital;
    private JProgressBar hungerVital;
    private JProgressBar cleanVital;
    private JProgressBar moodVital;
    private JLabel stLabel;
    private JLabel statusLabel;
    private JButton feedButton;
    private JButton playButton;
    private JButton sleepButton;
    private JButton doctorButton;
    private JButton earnButton;

    private User user;
    private Tamagotchi tamagotchi;
    private Command command;

    public void feed(){
        //TODO : Show choices of food to User
        //food: Sandwich(10euro, -20hunger) / Pancake(15euro, -30hunger) / Pasta(20euro, -50hunger)
        tamagotchi.eat();
    }
    public void play(){
        tamagotchi.playWithUser();
    }
    public void callDoctor(){
        tamagotchi.meetDoctor();
    }
    public void rest(){
        tamagotchi.sleep();
    }
    public void cleanUp(){
        tamagotchi.wash();
    }
    public void earnMoneyWithMiniGame(){
        user.rockPaperScissors();
    }

    public TamagotchiGUI(User user) {
        super("Tamagotchi");

        this.user = user;
        this.tamagotchi = user.getTamagotchi();
        //for test
        this.tamagotchi = new Professor("K", "Female");
        command = new Command(user);

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        jp1 = new JPanel();

        vital = new JLabel("Vitals ");
        jp1.add(vital);

        hungerVital = new JProgressBar(0, 100);
        hungerVital.setValue(tamagotchi.vital.getHungerV());
        hungerVital.setStringPainted(true);
        hungerVital.setString("Hunger");
        jp1.add(hungerVital);

        cleanVital = new JProgressBar(0, 100);
        cleanVital.setValue(tamagotchi.vital.getCleanlinessV());
        cleanVital.setStringPainted(true);
        cleanVital.setString("Cleanliness");
        jp1.add(cleanVital);

        moodVital = new JProgressBar(0, 100);
        moodVital.setValue(tamagotchi.vital.getMoodV());
        moodVital.setStringPainted(true);
        moodVital.setString("Mood");
        jp1.add(moodVital);

        add(jp1, BorderLayout.NORTH);
        // Create the status label and add it to the top of the frame
        statusLabel = new JLabel("I'm hungry!");
        add(statusLabel, BorderLayout.CENTER);

        // Create the buttons and add them to the center of the frame
        feedButton = new JButton("Feed");
        playButton = new JButton("Play");
        sleepButton = new JButton("Sleep");
        doctorButton = new JButton("Call Doctor");
        earnButton = new JButton("Earn Money");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        buttonPanel.add(sleepButton);
        buttonPanel.add(doctorButton);
        buttonPanel.add(earnButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the size of the frame and make it visible
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
