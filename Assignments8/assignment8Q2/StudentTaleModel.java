package assignment8Q2;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentTaleModel implements TableModel {
    private StudentsManager manager;

    public StudentTaleModel(StudentsManager manager) {
        super();
        this.manager = manager;
    }

    @Override
    public int getRowCount() {
        return manager.getStudentCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return "ID";
        case 1:
            return "Name";
        case 2:
            return "Gender";
        default:
            throw new IllegalArgumentException("Unexpected value: " + columnIndex);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = manager.getStudents().get(rowIndex);
        switch (columnIndex) {
        case 0:
            return student.getId();
        case 1:
            return student.getName();
        case 2:
            return student.getGender();
        default:
            throw new IllegalArgumentException("Unexpected value: " + columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

}
