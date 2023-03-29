package softwaredesign;
import softwaredesign.Users.User;
import softwaredesign.Users.UserList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login {
    public Login() {
        JFrame frame = new JFrame();
        //create frame
        frame.setTitle("My Tamagotchi");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //window can be closed
        frame.setLayout(new BorderLayout());

        login_fields(frame);
        //set visible
        frame.setVisible(true);
    }

    private static void login_fields(JFrame frame) {
        //add panel in frame and make format
        //title pattern
        UserList userList = new UserList();
        JPanel title_panel = new JPanel();
        frame.add(title_panel, BorderLayout.NORTH);
        JLabel title_label = new JLabel("TAMAGOTCHI");
        Font f1 = new Font(Font.MONOSPACED, Font.BOLD, 40);
        title_label.setFont(f1);
        title_panel.add(title_label);

        //<!--need pattern adjust here-->
        //central user info panel
        JPanel central_panel = new JPanel();
        frame.add(central_panel, BorderLayout.CENTER);
        central_panel.setLayout(new FlowLayout());
//        panel.setBackground(new Color(250, 172, 24));
        JLabel userLabel = new JLabel("ID:");
        userLabel.setPreferredSize(new Dimension(60, 25));
        central_panel.add(userLabel);
        JTextField userText = new JTextField(20);
        central_panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setPreferredSize(new Dimension(80, 25));
        central_panel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField(20);
        central_panel.add(passwordText);

        JButton loginButton = new JButton("login");
        central_panel.add(loginButton);
        JButton createaccButton = new JButton("Create Account");
        central_panel.add(createaccButton, BorderLayout.SOUTH);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = userText.getText();
                String inputPw = passwordText.getText();
                if (inputId.isBlank() || inputPw.isBlank()) {
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Invalid information!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!userList.logIn(inputId, inputPw)) {
                    //TODO: Add Authentication process
                    //find User
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Invalid id or password!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    User currentUser = userList.getCurrentUser();
                    frame.dispose();
                    TamagotchiGUI infopage = new TamagotchiGUI(currentUser);
//              frame.removeAll();
//              frame.repaint();
//              frame.revalidate();
                }
            }
        });
        createaccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Createacc accpage = new Createacc();

            }
        });
    }
}
