package assignment8Q1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame {

    public BaseFrame() {
        create();
        Container con = getContentPane();
        add(con);
        addListeners();
        makeItVisible();
    }

    public abstract void create();

    public abstract void add(Container con);

    public abstract void addListeners();

    public void makeItVisible() {
        setMinimumSize(new Dimension(400, 250));
        setVisible(true);
        setFont(new Font("Helvetica", Font.PLAIN, 40));
    }

}
