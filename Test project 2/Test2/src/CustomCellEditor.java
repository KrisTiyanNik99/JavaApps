import javax.swing.*;
import java.awt.*;

public class CustomCellEditor extends DefaultCellEditor {
    //suzdavame obekt ot klasa CustomTableActionEvent koito shte go poluchim s gotovi zadadeni metodi ot main3
    private CustomTableActionEvent event;
    public CustomCellEditor(CustomTableActionEvent event) {
        super(new JCheckBox());
        //slagame ediniq CTAE da ima funkciite na funshniq CTAE
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //suzdavame obekt ot klasa newjpanel
        NewJpanel test = new NewJpanel();
        //na obekta ot newjpanel mu slagame metoda initEvent koito priema obek ot klasa CustomTableActionEvent
        test.initEvent(event, row);
        return test;
    }

}
