package functions;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set text in center of the cell
        setHorizontalAlignment(SwingConstants.CENTER);

        // Change a font style
        this.setValue(table.getValueAt(row, column));
        this.setFont(this.getFont().deriveFont(Font.BOLD));
        return this;
    }
}
