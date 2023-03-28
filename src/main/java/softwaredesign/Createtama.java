package softwaredesign;

import softwaredesign.Users.User;
import softwaredesign.tamagotchis.Lecturer;
import softwaredesign.tamagotchis.Professor;
import softwaredesign.tamagotchis.TA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Createtama extends JFrame{
    private JPanel j1;
    private JTextField nameField;
    private JButton createtama;
    public Createtama(User user){
        JFrame frame=new JFrame();
        frame.setTitle("Create Tamagotchi");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //window can be closed
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel container = (JPanel) getContentPane();
        container.setLayout(new GridBagLayout());
        j1 = new JPanel(new GridLayout(4, 1, 10, 10));
        JPanel row = new JPanel();
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setPreferredSize(new Dimension(60, 25));
        row.add(nameLabel);
        nameField = new JTextField(20);
        row.add(nameField);
        j1.add(row);
        row = new JPanel();
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setPreferredSize(new Dimension(60, 25));
        row.add(genderLabel);
        JCheckBox g1 = new JCheckBox("Male");
        JCheckBox g2 = new JCheckBox("Female");
        JCheckBox g3 = new JCheckBox("Other");
        row.add(g1); row.add(g2); row.add(g3);
        j1.add(row);
        row = new JPanel();
        JLabel typeLabel = new JLabel("Type");
        typeLabel.setPreferredSize(new Dimension(60, 25));
        row.add(typeLabel);
        JCheckBox t1 = new JCheckBox("Lecturer");
        JCheckBox t2 = new JCheckBox("Professor");
        JCheckBox t3 = new JCheckBox("TA");
        row.add(t1); row.add(t2); row.add(t3);
        j1.add(row);
        row = new JPanel();
        createtama = new JButton("Create Account");
        row.add(createtama);
        j1.add(row);
        container.add(j1);
        frame.add(container);

        createtama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check validity
                if(nameField.getText().isBlank()) {
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!((g1.isSelected()^g2.isSelected()^g3.isSelected()) && !(g1.isSelected()&&g2.isSelected()&&g3.isSelected()))){
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Check only one option!", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(!((t1.isSelected()^t2.isSelected()^t3.isSelected()) && !(t1.isSelected()&&t2.isSelected()&&t3.isSelected()))){
                    JOptionPane err = new JOptionPane();
                    err.showMessageDialog(null, "Check only one option!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String gender="";
                    if(g1.isSelected()) gender = "Male";
                    else if(g2.isSelected()) gender = "Female";
                    else if(g3.isSelected()) gender = "Other";
                    if(t1.isSelected()){
                        Lecturer tama = new Lecturer(nameField.getText(), gender);
                        user.setTamagotchi(tama);
                    }
                    else if(t2.isSelected()){
                        Professor tama = new Professor(nameField.getText(), gender);
                        user.setTamagotchi(tama);
                    }
                    else if(t3.isSelected()){
                        TA tama = new TA(nameField.getText(), gender);
                        user.setTamagotchi(tama);
                    }
                    frame.dispose();
                    Login login_page = new Login();
                }
            }
        });
    }
}