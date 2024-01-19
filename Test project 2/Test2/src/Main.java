import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //Syzdavam jframe i mu zadavam osnovnite harakteristiki
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(980, 680);

        //Slagame default table model i suzdavame table za da raboti
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        //Suzdavame koloninkite i tehnite imena za test
        String nameColum = "ID";
        model.addColumn(nameColum); //stava i kogato e prosto String tip
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("Bober"); //dobavqme edna ekstra kolana za test kak mojem da q iztriem

        //Suzdavame TableColum s column modela na table i vzimame indexa na kolonata koqto iskame da mahnem
        TableColumn col = table.getColumnModel().getColumn(4); //s metoda getColumn(index) vzimame kolonata koqto iskame
        table.removeColumn(col); //sled koeto izpolzvame promenlivata "col" za da premahnem s metoda na table- removeColumn, TableColumn koito sme izbrali
        //pravim go zashtoto removeColum raboti s TableColumn, poradi koeto ni trqbva da suzdadem promenliva ot tip TableColumn za da mojem da q mahnem

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
        //slagame na scrollpane za da znae jpanela kude da go pozicionira
        ne.setBounds(40, 20, 600, 200);

        //test buton s cel printirane za debug
        JButton print = new JButton("Buba butonche");
        print.setBackground(Color.PINK);
        print.addActionListener(e -> {
            table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            //slagame setRowSelectionAllowed na true zashtot inache ne mojem da izbirame kolonite
            table.setRowSelectionAllowed(true);
            //izbira vsichki redove ot purviq do posledniq
            table.setRowSelectionInterval(0, table.getRowCount() - 1);
            getSelectedRowValues(table);
        });
        print.setBounds(280, 80, 200, 100);

        //suzdavame Jpanel v koito shte si durjim elementite
        JPanel first = new JPanel();
        first.setPreferredSize(new Dimension(490, 340));
        first.setBackground(Color.BLACK);
        first.setLayout(null);
        first.add(ne);

        //suzdavame i vtori jpanel koito da durjim butona
        JPanel second = new JPanel();
        second.setPreferredSize(new Dimension(490,340));
        second.setBackground(Color.yellow);
        second.setLayout(null);
        second.add(print);

        //dobavqm table kym jfreima
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(first, BorderLayout.NORTH);
        frame.add(second, BorderLayout.SOUTH);
    }

    //metod s koito shte printirame elementite ot redovete na suotvetnata kolona S CEL DEBUG
    private static void getSelectedRowValues(JTable table){
        int[] vals = table.getSelectedRows(); //tuk sa vsichki izbrani redove zaedno sys stoinostite koito imat
        //obhojdame gi s for cikul za da mojem da preminem prez vseki red
        for (int i = 0; i < vals.length; i++){
            //chrez metoda table.getValueAt(nomera na reda, nomera na kolonata) vzimame stoinostta ot kolonata koqto iskame
            System.out.println(table.getValueAt(i, 2));
            System.out.println(table.getValueAt(i, 1));
            System.out.println("Cenata na artikula " + table.getValueAt(i, 3));
        }
        System.out.println();
    }
}