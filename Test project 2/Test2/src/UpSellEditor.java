import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;

public class UpSellEditor extends DefaultCellEditor {

    private JSpinner spinner;

    public UpSellEditor() {
        super(new JCheckBox());
        spinner = new JSpinner();
        SpinnerNumberModel numberModel = (SpinnerNumberModel) spinner.getModel();
        numberModel.setMinimum(0);
        numberModel.setMaximum(10);
        //S tozi kod pravim taka che ne e nujno da natiskame enter za da zapazvame promenenata stoinost v spinnera
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter)editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        //zadavam parametri koito da centrirat stoinostta koqto se pokazva v jspinnera
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER); //slaga stoinostta v centura samo kogato e w edit mode

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);
        //S tozi i dolniq red pravim spinnera da zapazva na vsqka otdelna kletka zadadenata i stoinost(sama za sebe si)
        int quint = Integer.parseInt(value.toString()); //parsvame stoinostta kym int
        spinner.setValue(quint);
        return spinner;
    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}
