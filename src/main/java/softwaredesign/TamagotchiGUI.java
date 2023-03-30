package softwaredesign;

import softwaredesign.Users.User;
import softwaredesign.tamagotchis.Lecturer;
import softwaredesign.tamagotchis.Professor;
import softwaredesign.tamagotchis.TA;
import softwaredesign.tamagotchis.Tamagotchi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class TamagotchiGUI extends JFrame {
    private JPanel jp1;
    private JLabel vital;
    private JProgressBar hungerVital;
    private JProgressBar cleanVital;
    private JProgressBar moodVital;
    JPanel infoPanel;
    JLabel userNameLabel;
    JLabel userBalance;
    JLabel tamaNameLabel;
    JLabel tamaGenLabel;
    JLabel tamaRoleLabel;
    //private JPanel statusPanel;
    private JLabel statusLabel;
    private JButton feedButton;
    private JButton playButton;
    private JButton sleepButton;
    private JButton doctorButton;
    private JButton earnButton;
    private JButton cleanButton;
    private JButton logOutButton;

    private User user;
    private Tamagotchi tamagotchi;
    private Observer vitalObserver;

    public void feed(){
        //food: Sandwich(10euro, -20hunger) / Pancake(15euro, -30hunger) / Pasta(20euro, -50hunger)
        JFrame frame=new JFrame();
        frame.setTitle("Choose Food");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //window can be closed
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel j1 = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel nameLabel = new JLabel("Choose Food");
        nameLabel.setPreferredSize(new Dimension(60, 25));
        j1.add(nameLabel);
        JPanel foods = new JPanel();
        JCheckBox f1 = new JCheckBox("Sandwich / 10euro");
        JCheckBox f2 = new JCheckBox("Pancake / 15euro");
        JCheckBox f3 = new JCheckBox("Pasta / 20euro");
        foods.add(f1); foods.add(f2); foods.add(f3);
        j1.add(foods);
        JPanel buttonPanel = new JPanel();
        JButton confirm = new JButton("Confirm");
        buttonPanel.add(confirm);
        j1.add(buttonPanel);
        frame.add(j1);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check validity
                if(!((f1.isSelected()^f2.isSelected()^f3.isSelected()) && !(f1.isSelected()&&f2.isSelected()&&f3.isSelected()))){
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Check only one option!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    if(f1.isSelected()){
                        if(!user.enoughBalance(10)){
                            JOptionPane err = new JOptionPane();
                            err.showMessageDialog(null, "Not enough money!", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            user.buyFood(10);
                            tamagotchi.eat(20);
                            frame.dispose();
                        }
                    }
                    else if(f2.isSelected()){
                        if(!user.enoughBalance(15)){
                            JOptionPane err = new JOptionPane();
                            err.showMessageDialog(null, "Not enough money!", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            user.buyFood(15);
                            tamagotchi.eat(30);
                            frame.dispose();
                        }
                    }
                    else if(f3.isSelected()){
                        if(!user.enoughBalance(20)){
                            JOptionPane err = new JOptionPane();
                            err.showMessageDialog(null, "Not enough money!", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            user.buyFood(20);
                            tamagotchi.eat(50);
                            frame.dispose();
                        }
                    }else{frame.dispose();}
                }
            }
        });
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
       vitalObserver = new Observer(this, tamagotchi);

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

        // Create the username, tamagotchi name, tamagotchi gender
        infoPanel = new JPanel();
        userNameLabel = new JLabel("User: " + user.username);
        userBalance = new JLabel("-  " + user.getBalance() + "euro   / ");
        tamaNameLabel = new JLabel("Tamagotchi: " + tamagotchi.getName());
        tamaGenLabel = new JLabel("-  " + tamagotchi.getGender());
        tamaRoleLabel = new JLabel("-  " + tamagotchi.getRole());
        infoPanel.add(userNameLabel);
        infoPanel.add(userBalance);
        infoPanel.add(tamaNameLabel);
        infoPanel.add(tamaGenLabel);
        infoPanel.add(tamaRoleLabel);
        add(infoPanel, BorderLayout.WEST);

        JPanel logOutPanel = new JPanel();
        logOutButton = new JButton("Log Out");
        logOutPanel.add(logOutButton);
        add(logOutPanel, BorderLayout.EAST);

        // Create the status label and add it to the top of the frame
        statusLabel = new JLabel(tamagotchi.vital.getStatus());
        add(statusLabel, BorderLayout.CENTER);

        // Create the buttons and add them to the center of the frame
        feedButton = new JButton("Feed");
        playButton = new JButton("Play");
        sleepButton = new JButton("Sleep");
        doctorButton = new JButton("Call Doctor");
        cleanButton = new JButton("Clean & Wash");
        earnButton = new JButton("Earn Money");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        buttonPanel.add(sleepButton);
        buttonPanel.add(doctorButton);
        buttonPanel.add(cleanButton);
        buttonPanel.add(earnButton);
        add(buttonPanel, BorderLayout.SOUTH);


        // Set the size of the frame and make it visible
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Vitals change every 30 minutes
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if(!tamagotchi.vital.checkDeath()){
                    if(Math.random()>0.5) tamagotchi.vital.getHungry();
                    if(Math.random()>0.5) tamagotchi.vital.getLonely();
                    if(Math.random()>0.5) tamagotchi.vital.getDirty();
                    if(Math.random()>0.7) tamagotchi.vital.getSick();
                }
                else{
                    timer.cancel();
                    int response = JOptionPane.showConfirmDialog(null,
                            "The tamagotchi died due to low vitals. Do you want to continue?", "Select Option", JOptionPane.YES_NO_OPTION);
                    if(response == JOptionPane.YES_OPTION){
                        TamagotchiGUI.super.dispose();
                        Createtama tama = new Createtama(user, true);
                    } else if(response == JOptionPane.NO_OPTION){
                        System.exit(0);
                    }
                }
            }
        };
        timer.schedule(task,0, 20000);


        //Set response to each button action
        feedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feed();
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });
        sleepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rest();
            }
        });
        doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callDoctor();
            }
        });
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanUp();
            }
        });
        earnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                earnMoneyWithMiniGame();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
            }
        });
    }

    public void updateFrame(){
        // Update vital
        jp1.removeAll();
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
        jp1.revalidate();
        jp1.repaint();

        if(tamagotchi.vital.checkDeath()){

        }

        // Update status
        remove(statusLabel);
        statusLabel = new JLabel(tamagotchi.vital.getStatus());
        add(statusLabel, BorderLayout.CENTER);
        statusLabel.revalidate();
        statusLabel.repaint();

        // Update Balance
        infoPanel.removeAll();
        userBalance = new JLabel("-  " + user.getBalance() + "euro   / ");
        infoPanel.add(userNameLabel);
        infoPanel.add(userBalance);
        infoPanel.add(tamaNameLabel);
        infoPanel.add(tamaGenLabel);
        infoPanel.add(tamaRoleLabel);
        add(infoPanel, BorderLayout.WEST);
        infoPanel.revalidate();
        infoPanel.repaint();
    }

}
