package assignment8Q1;

import java.awt.Font;

import javax.swing.JTextField;

public class MyTextField extends JTextField {

    public MyTextField(int columns) {
        super(columns);

        setEditable(false);
        setFont(new Font("Helvetica", Font.PLAIN, 60));
        setText("0");
    }

}
