import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;

public class UpSellEditor extends DefaultCellEditor {

    private JSpinner spinner;
    private JTable table;
    private int row;
    private NewTest currentItemSet;


    public UpSellEditor() {
        super(new JCheckBox());
        spinner = new JSpinner();
        SpinnerNumberModel numberModel = (SpinnerNumberModel) spinner.getModel();
        numberModel.setMinimum(0);
        numberModel.setMaximum(10);
        //S tozi kod pravim taka che ne e nujno da natiskame enter za da zapazvame promenenata stoinost v spinnera
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        //zadavam parametri koito da centrirat stoinostta koqto se pokazva v jspinnera
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER); //slaga stoinostta v centura samo kogato e w edit mode
        //dobavqme metod koito shte promenq cenata i kolichestvoto na produktite
        spinner.addChangeListener(e -> spinnerChange());

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);
        //Setvame nashiq jtable da e kato Jtable v main metoda
        this.table = table;
        this.row = row; //slagame reda koito sme poluchili kato argument ot celleditora
        this.currentItemSet = (NewTest) table.getValueAt(row, 0);// zaduljitelno kolonata koqto sochi kum mqstoto na zapazenite obekti v pametta
        //S tozi i dolniq red pravim spinnera da zapazva na vsqka otdelna kletka zadadenata i stoinost(sama za sebe si)
        int quint = Integer.parseInt(value.toString()); //parsvame stoinostta kym int
        spinner.setValue(quint);
        return spinner;
    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    private void spinnerChange() {
        int qynt = Integer.parseInt(spinner.getValue().toString());
        if (qynt != currentItemSet.getKolichesto()) { //Proverqvame dali kolichestvoto e razlichno promenqno
            currentItemSet.setKolichesto(qynt); //Tui kato sme v sluchq kogato sa razlichni kolichestvata, prosto gi oednakvqvame v tozi red

            if (currentItemSet.getTotalCena() > (currentItemSet.getCena() * currentItemSet.getKolichesto())) { //pravim proverka dali obshtata suma e po- golqma ot kolichestvoto po cenata
                //ako obshtata suma e po golqma ot kolichestvoto po cenata znachi broikata na maxvalue trqbva da porasne
                currentItemSet.setMaxKolichestvo(currentItemSet.getMaxKolichestvo() + 1);
            } else if (currentItemSet.getTotalCena() < (currentItemSet.getCena() * currentItemSet.getKolichesto())) {
                //ako e po malka znachi trqbva maxvalue da namalee s edno
                currentItemSet.setMaxKolichestvo(currentItemSet.getMaxKolichestvo() - 1);
            }

            //sled tova veche pri vsichki sluchai si smqtame cenata po kolichestvoto
            currentItemSet.setTotalCena(currentItemSet.getCena() * currentItemSet.getKolichesto()); //tuk setvame total cenata
            table.setValueAt("$ " + currentItemSet.getTotalCena(), row, 5);
            table.setValueAt(currentItemSet.getMaxKolichestvo(), row, 4);
        }
    }
}
