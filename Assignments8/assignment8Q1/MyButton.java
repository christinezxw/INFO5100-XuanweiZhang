package assignment8Q1;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton {

    public MyButton(String text) {
        super(text);

        setPreferredSize(new Dimension(40, 40));
        setFont(new Font("Helvetica", Font.PLAIN, 20));
    }

}
