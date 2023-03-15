package softwaredesign;

import javax.swing.*;
import java.awt.*;

public class Getinfo {
    public Getinfo(){
        JFrame frame=new JFrame();
        /*create frame*/
        frame.setTitle("My Tamagotchi");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //window can be closed
        frame.setLayout(new BorderLayout());

        frame.setVisible(true);
    }
}
