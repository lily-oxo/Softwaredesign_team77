package softwaredesign;

import javax.swing.*;
import java.awt.*;

public class TamagotchiGUI extends JFrame {

    private JLabel statusLabel;
    private JButton feedButton;
    private JButton playButton;
    private JButton sleepButton;

    public TamagotchiGUI() {
        super("Tamagotchi");

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        // Create the status label and add it to the top of the frame
        statusLabel = new JLabel("I'm hungry!");
        add(statusLabel, BorderLayout.NORTH);

        // Create the buttons and add them to the center of the frame
        feedButton = new JButton("Feed");
        playButton = new JButton("Play");
        sleepButton = new JButton("Sleep");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        buttonPanel.add(sleepButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Set the size of the frame and make it visible
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
