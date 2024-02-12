package functions;

import custom.Product;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;

public class SpinnerCellEditor extends DefaultCellEditor {

    private JSpinner spinner;
    private JTable table;
    private int row;
    private Product currentProduct;

    public SpinnerCellEditor() {
        super(new JCheckBox());

        // Create a new JSpinner and Table
        spinner = new JSpinner();
        table = new JTable();

        // Here we set max and min value of a JSpinner
        SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
        model.setMinimum(0);
        model.setMaximum(10);

        // We put it so we don't have to press enter to change and save the value in JSpinner
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);

        // Set our spinner to be in the center of the cell
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        // Add change method who will listen for changes who outside
        spinner.addChangeListener(e -> setSpinnerChanges());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);

        // Set these parameters to be the same as those we receive as arguments
        this.table = table;
        this.row = row;
        this.currentProduct = (Product) table.getValueAt(row, 0);

        // We parse the value to an int because in the SpinnerCellEditor we set it to work only with Integers
        int currentValue = Integer.parseInt(String.valueOf(value));

        // Put the value we got from outside to the JSpinner
        spinner.setValue(currentValue);
        return spinner;
    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    // Create a method that will monitor and set changes in the spinner and match them to the objects of the Product class
    private void setSpinnerChanges() {
        int currentSpinnerQuantity = Integer.parseInt(spinner.getValue().toString());

        // Checking if the values of the object from the Product class diverges from that of the value of the spinner
        if (currentSpinnerQuantity != currentProduct.getQuantity() || currentSpinnerQuantity == currentProduct.getQuantity()) {
            // If the values differ, here we make them the same
            currentProduct.editQuantity(currentSpinnerQuantity);

            // Set total price
            currentProduct.setTotalPrice(currentProduct.getPrice() * currentProduct.getQuantity());

            // Set new already edit total price value to the JTable
            table.setValueAt("$ " + currentProduct.getTotalPrice(), row, 4);
        }
    }
}
