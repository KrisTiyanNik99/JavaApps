import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    static JTable table;

    List<NewTest> mhm = new ArrayList<>();

    public static void main(String[] args) {

        //Syzdavam jframe i mu zadavam osnovnite harakteristiki
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        table = new JTable();
        //Slagame default table model za da raboti
        DefaultTableModel model = (DefaultTableModel)table.getModel();

        //Suzdavame koloninkite
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");

        //Syzdavam redovete i slagam artikuli v nego
        model.addRow(new NewTest("Laptop", 1, 3.54).toTableRow());
        model.addRow(new NewTest("Telephone", 1, 500).toTableRow());
        model.addRow(new NewTest().toTableRow());

        //zadavam na koq kolonka iskam da se proloji kustom kolonkata s jspinnera
        table.getColumnModel().getColumn(1).setCellEditor(new UpSellEditor());
        //pravim taka che stoinostta da sedi poprincip v centura - no za da go napravim trqbva da prenapishem chast ot funkciqta koqto pravi tova
        table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer(){
            //trqbva da override getTableCellRenderComponent metoda za da moje da go napravim taka che da ni slaga stoinostta v sredata
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER); // ot tuk slagane stoinostta v sredata
                return this;
            }
        });

        //slagam parametri na table
        table.setBounds(30,40,200, 300);
        JScrollBar ne = new JScrollBar();
        table.add(ne);

        //dobavqm table kym jreima
        frame.add(table);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}