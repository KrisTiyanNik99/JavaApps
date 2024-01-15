import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {

    static JTable table;

    public static void main(String[] args) {

        //Syzdavam jframe i mu zadavam osnovnite harakteristiki
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(980, 680);

        table = new JTable();
        //Slagame default table model za da raboti
        DefaultTableModel model = (DefaultTableModel)table.getModel();

        //Suzdavame koloninkite i tehnite imena za test
        String nameColum = "ID";
        model.addColumn(nameColum); //stava i kogato e prosto String tip
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");

        //zadavam na koq kolonka iskam da se priloji kustom kolonkata s jspinnera
        table.getColumnModel().getColumn(2).setCellEditor(new UpSellEditor());

        //Syzdavam redovete i slagam artikuli v nego chrez medoda "toTableRow", koito suzdadohme v NewTest
        model.addRow(new NewTest("Laptop", 1, 950.90).toTableRow());
        //addRow metoda raboti s Object arr, zatova nie v nashiq klas NewTest suzdadohme mnogo vajniq metod "toTableRow" koito parsva vsichko koeto ni trqbva kato Object arr
        model.addRow(new NewTest("Telephone", 1, 500).toTableRow());
        model.addRow(new NewTest("Klimatik", 0,450.55).toTableRow());
        model.addRow(new NewTest(nameColum+" for servers", 1, 3000).toTableRow());
        model.addRow(new NewTest().toTableRow());

        //pravim taka che stoinostta da sedi poprincip v centura - no za da go napravim trqbva da prenapishem chast ot funkciqta koqto pravi tova
        table.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer(){
            //trqbva da override getTableCellRenderComponent metoda za da moje da go napravim taka che da ni slaga stoinostta v sredata
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER); // ot tuk slagane stoinostta v sredata
                return this;
            }
        });
        //pravim cenata sushto da sedi v centura na kletkata
        table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        });

        //slagam parametri na table za da moje da se vijdat hedarite na tablicata
        table.setRowHeight(25);
        int boldNum = 15; //test dali stava ot promenliva da boldvam
        table.getTableHeader().setFont(new Font("Colors", Font.BOLD, boldNum));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32,136,203));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setSelectionBackground(new Color(232,57,95));
        JScrollPane ne = new JScrollPane(table);

        //dobavqm table kym jfreima
        frame.add(ne);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}