package assignment8Q2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class StudentSystem extends BaseFrame {
    private JLabel titleLabel, idLabel, nameLabel, genderLabel;
    private JTextField idField, nameField;
    private JComboBox<String> genderBox;
    private JButton addButton;
    private StudentTaleModel studentTableModel;
    private JTable studentJTable;
    private StudentsManager manager;

    public static void main(String[] args) {
        new StudentSystem();

    }

    @Override
    public void create() {
        titleLabel = new JLabel("Enter student information here:");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        genderLabel = new JLabel("Gender:");
        idField = new JTextField(15);
        nameField = new JTextField(15);
        genderBox = new JComboBox<String>(new String[] { "", "Male", "Female" });
        addButton = new JButton("ADD");
        try {
            manager = new StudentsManagerFileImpl();
        } catch (Exception e) {
            // TODO: handle exception
        }

        studentTableModel = new StudentTaleModel(manager);
        studentJTable = new JTable(studentTableModel);
    }

    @Override
    public void add(Container con) {
        Font font = new Font("Helvetica", Font.PLAIN, 15);
        JPanel informationJPanel = new JPanel();
        informationJPanel.setLayout(new GridBagLayout());
        addInformation(informationJPanel);
        con.add(informationJPanel, BorderLayout.NORTH);
        con.add(new JScrollPane(studentJTable), BorderLayout.SOUTH);

        JTableHeader tableHeader = studentJTable.getTableHeader();
        tableHeader.setFont(font);
        studentJTable.setFont(font);
        studentJTable.setRowHeight(25);
        informationJPanel.setFont(font);
        titleLabel.setFont(font);
        idLabel.setFont(font);
        nameLabel.setFont(font);
        genderLabel.setFont(font);
        addButton.setFont(font);
    }

    private void addInformation(JPanel informationJPanel) {
        int strength = 10;
        gridConstrains(informationJPanel, titleLabel, 0, 0, 2, 1, strength, strength);
        gridConstrains(informationJPanel, idLabel, 1, 0, 1, 1, strength, strength);
        gridConstrains(informationJPanel, idField, 1, 1, 1, 1, strength, strength);
        gridConstrains(informationJPanel, nameLabel, 2, 0, 1, 1, strength, strength);
        gridConstrains(informationJPanel, nameField, 2, 1, 1, 1, strength, strength);
        gridConstrains(informationJPanel, genderLabel, 3, 0, 1, 1, strength, strength);
        gridConstrains(informationJPanel, genderBox, 3, 1, 1, 1, strength, strength);
        gridConstrains(informationJPanel, addButton, 4, 0, 2, 1, strength, strength);
    }

    private void gridConstrains(JPanel informationJPanel, Component com, int row, int col, int width, int height,
            int xstren, int ystren) {
        GridBagConstraints constrains = new GridBagConstraints();
        constrains.gridx = col;
        constrains.gridy = row;
        constrains.gridwidth = width;
        constrains.gridheight = height;
        constrains.weightx = xstren;
        constrains.weighty = ystren;
        informationJPanel.add(com, constrains);
    }

    @Override
    public void addListeners() {
        addButton.addActionListener((e) -> addButtonAction());

    }

    private void addButtonAction() {
        String id = idField.getText();
        String name = nameField.getText();
        String gender = genderBox.getSelectedItem().toString();
        try {
            manager.addStudent(new Student(id, name, gender));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        studentJTable.revalidate();
    }

}
