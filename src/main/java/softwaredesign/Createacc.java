package softwaredesign;


import softwaredesign.Users.User;
import softwaredesign.Users.UserList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Createacc extends JFrame {
    private JPanel j1;
    private JTextField idField;
    private JTextField nameField;
    private JTextField pwField;
    private JButton createAcc;
    private JButton goBack;
    static UserList userList = UserList.getInstance();
    public Createacc(){
        JFrame frame=new JFrame();
        frame.setTitle("Create Account");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //window can be closed
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel container = (JPanel) getContentPane();
        container.setLayout(new GridBagLayout());
        j1 = new JPanel(new GridLayout(4, 1, 10, 10));
        JPanel row = new JPanel();
        JLabel idLabel = new JLabel("ID");
        idLabel.setPreferredSize(new Dimension(60, 25));
        row.add(idLabel);
        idField = new JTextField(20);
        row.add(idField);
        j1.add(row);
        row = new JPanel();
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setPreferredSize(new Dimension(60, 25));
        row.add(nameLabel);
        nameField = new JTextField(20);
        row.add(nameField);
        j1.add(row);
        row = new JPanel();
        JLabel pwLabel = new JLabel("Password");
        pwLabel.setPreferredSize(new Dimension(60, 25));
        row.add(pwLabel);
        pwField = new JTextField(20);
        row.add(pwField);
        j1.add(row);
        row = new JPanel();
        goBack = new JButton("Go Back");
        row.add(goBack);
        createAcc = new JButton("Create Account");
        row.add(createAcc);
        j1.add(row);
        container.add(j1);
        frame.add(container);

        createAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check validity
                if(idField.getText().isBlank() || nameField.getText().isBlank() || pwField.getText().isBlank()) {
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Invalid information!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    User user = new User(idField.getText(), nameField.getText(), pwField.getText());
                    userList.addUser(user);
                    frame.dispose();
                    Createtama tama = new Createtama(user, false);
                }
            }
        });
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login login_page = new Login();
            }
        });
    }
}