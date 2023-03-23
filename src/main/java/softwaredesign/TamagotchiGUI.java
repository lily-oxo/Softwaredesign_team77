package softwaredesign;

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

    private User user;
    private Tamagotchi tamagotchi;
    private Command command;

    public TamagotchiGUI(User user) {
        super("Tamagotchi");

        this.user = user;
        command = new Command(user);

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        jp1 = new JPanel();

        vital = new JLabel("Vitals ");
        jp1.add(vital);

        hungerVital = new JProgressBar(0, 100);
        hungerVital.setValue(50);
        hungerVital.setStringPainted(true);
        hungerVital.setString("Hunger");
        jp1.add(hungerVital);

        cleanVital = new JProgressBar(0, 100);
        cleanVital.setValue(50);
        cleanVital.setStringPainted(true);
        cleanVital.setString("Cleanliness");
        jp1.add(cleanVital);

        moodVital = new JProgressBar(0, 100);
        moodVital.setValue(50);
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
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        buttonPanel.add(sleepButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the size of the frame and make it visible
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
