package functions;

import javax.swing.table.DefaultTableModel;
/*
    We create our custom table model for our goals
 */
public class CustomTableModel extends DefaultTableModel {

    // Customize our cell editor
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 4;
    }
}
