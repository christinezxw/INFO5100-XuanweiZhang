package assignment8Q1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends BaseFrame {

    private JButton one, two, three, four, five, six, seven, eight, nine, zero, clear, back, plus, minus, multi, divid,
            equal;
    private JTextField resultField;
    private int currentNumber;
    private String sign = "+";
    private Stack<Integer> calculateStack = new Stack<Integer>();
    private int result;
    private boolean operationFollowNumber;

    public static void main(String[] args) {
        new Calculator();

    }

    @Override
    public void create() {
        one = new MyButton("1");
        two = new MyButton("2");
        three = new MyButton("3");
        four = new MyButton("4");
        five = new MyButton("5");
        six = new MyButton("6");
        seven = new MyButton("7");
        eight = new MyButton("8");
        nine = new MyButton("9");
        zero = new MyButton("0");
        plus = new MyButton("+");
        minus = new MyButton("-");
        multi = new MyButton("x");
        divid = new MyButton("÷");
        clear = new MyButton("C");
        back = new MyButton("<--");
        equal = new MyButton("=");
        resultField = new MyTextField(20);
    }

    @Override
    public void add(Container con) {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.PINK);
        addButtons(buttonPanel);
        con.add(resultField, BorderLayout.NORTH);
        con.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addButtons(JPanel buttonPanel) {
        // row one:1,2,3,back
        addButton(buttonPanel, one, 0, 0, 1, 1, 10, 10);
        addButton(buttonPanel, two, 0, 1, 1, 1, 10, 10);
        addButton(buttonPanel, three, 0, 2, 1, 1, 10, 10);
        addButton(buttonPanel, back, 0, 3, 2, 1, 20, 10);
        // row two:4,5,6,+,-
        addButton(buttonPanel, four, 1, 0, 1, 1, 10, 10);
        addButton(buttonPanel, five, 1, 1, 1, 1, 10, 10);
        addButton(buttonPanel, six, 1, 2, 1, 1, 10, 10);
        addButton(buttonPanel, plus, 1, 3, 1, 1, 10, 10);
        addButton(buttonPanel, minus, 1, 4, 1, 1, 10, 10);
        // row three:7,8,9,x,/
        addButton(buttonPanel, seven, 2, 0, 1, 1, 10, 10);
        addButton(buttonPanel, eight, 2, 1, 1, 1, 10, 10);
        addButton(buttonPanel, nine, 2, 2, 1, 1, 10, 10);
        addButton(buttonPanel, multi, 2, 3, 1, 1, 10, 10);
        addButton(buttonPanel, divid, 2, 4, 1, 1, 10, 10);
        // row four:clear,0,dot,equal
        addButton(buttonPanel, clear, 3, 0, 1, 1, 10, 10);
        addButton(buttonPanel, zero, 3, 1, 2, 1, 20, 10);
        addButton(buttonPanel, equal, 3, 3, 2, 1, 20, 10);
    }

    private void addButton(JPanel buttonPanel, Component button, int row, int col, int width, int height, int xstren,
            int ystren) {
        GridBagConstraints constrains = new GridBagConstraints();
        constrains.fill = GridBagConstraints.BOTH;
        constrains.gridx = col;
        constrains.gridy = row;
        constrains.gridwidth = width;
        constrains.gridheight = height;
        constrains.weightx = xstren;
        constrains.weighty = ystren;
        buttonPanel.add(button, constrains);
    }

    @Override
    public void addListeners() {
        // number buttons
        one.addActionListener((e) -> numberButtonAction(one, 1));
        two.addActionListener((e) -> numberButtonAction(two, 2));
        three.addActionListener((e) -> numberButtonAction(three, 3));
        four.addActionListener((e) -> numberButtonAction(four, 4));
        five.addActionListener((e) -> numberButtonAction(five, 5));
        six.addActionListener((e) -> numberButtonAction(six, 6));
        seven.addActionListener((e) -> numberButtonAction(seven, 7));
        eight.addActionListener((e) -> numberButtonAction(eight, 8));
        nine.addActionListener((e) -> numberButtonAction(nine, 9));
        zero.addActionListener((e) -> numberButtonAction(zero, 0));
        // operation buttons
        plus.addActionListener((e) -> operationButtonAction(plus, "+"));
        minus.addActionListener((e) -> operationButtonAction(minus, "-"));
        multi.addActionListener((e) -> operationButtonAction(multi, "x"));
        divid.addActionListener((e) -> operationButtonAction(divid, "/"));
        // equal button
        equal.addActionListener((e) -> equalButtonAction());
        // clear button
        clear.addActionListener((e) -> clearButtonAction());
        // back button
        back.addActionListener((e) -> backButtonAction());
    }

    private void numberButtonAction(Component button, int number) {
        operationFollowNumber = true;
        if (currentNumber == result) {
            currentNumber = 0;
            result = 0;
        }
        currentNumber = currentNumber * 10 + number;
        resultField.setText(Integer.toString(currentNumber));
    }

    private void operationButtonAction(Component button, String operation) {
        try {
            if (operationFollowNumber) {
                if (sign.equals("+")) {
                    calculateStack.push(currentNumber);
                } else if (sign.equals("-")) {
                    calculateStack.push(-currentNumber);
                } else if (sign.equals("x")) {
                    calculateStack.push(calculateStack.pop() * currentNumber);
                } else if (sign.equals("/")) {
                    calculateStack.push(calculateStack.pop() / currentNumber);
                }
            }

            sign = operation;
            currentNumber = 0;
        } catch (Exception e) {
            resultField.setText("Error!");
            calculateStack.clear();
            sign = "+";
            currentNumber = 0;
        }
        operationFollowNumber = false;
    }

    private void equalButtonAction() {
        try {
            if (sign.equals("+")) {
                calculateStack.push(currentNumber);
            } else if (sign.equals("-")) {
                calculateStack.push(-currentNumber);
            } else if (sign.equals("x")) {
                calculateStack.push(calculateStack.pop() * currentNumber);
            } else if (sign.equals("/")) {
                calculateStack.push(calculateStack.pop() / currentNumber);
            }
            result = 0;
            while (!calculateStack.isEmpty()) {
                result += calculateStack.pop();
            }
            resultField.setText(Integer.toString(result));
        } catch (Exception e) {
            resultField.setText("Error!");
            calculateStack.clear();
        }
        sign = "+";
        currentNumber = result;
    }

    private void clearButtonAction() {
        resultField.setText("0");
        calculateStack.clear();
        sign = "+";
        currentNumber = 0;
    }

    private void backButtonAction() {
        currentNumber = currentNumber / 10;
        resultField.setText(Integer.toString(currentNumber));
    }

}
