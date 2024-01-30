import javax.swing.*;
import java.awt.*;

public class CustomCellEditor extends DefaultCellEditor {

    private CustomTableActionEvent event;
    public CustomCellEditor(CustomTableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        NewJpanel test = new NewJpanel();
        test.initEvent(event, row);
        return test;
    }

}
