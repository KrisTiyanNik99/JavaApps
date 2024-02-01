import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test 2");

        CustomTableModel model = new CustomTableModel();
        model.addColumn("Age");
        model.addColumn("Student");
        model.addColumn("Edit");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(820,600);
        frame.setLayout(null);

        JTable jTable = new JTable(model);
        //nastroiki na table
        jTable.getTableHeader().setOpaque(false);

        //overridevame CustomTableActionEvent metodite, taka kakto ni trqbva da rabotqt v tozi sluchai
        CustomTableActionEvent editor = new CustomTableActionEvent() {
            @Override
            public void onEdit(int row) {
                model.startEdit(row);
            }

            @Override
            public void onDelete(int row) {
                //pravim taka che da mojem da triem izbraniq ot nas red
                if(jTable.isEditing()){
                    jTable.getCellEditor().stopCellEditing();
                }
                DefaultTableModel mod = (DefaultTableModel)jTable.getModel();
                mod.removeRow(row);
            }
        };

        //slagam custom nastroikite za kolonata edit
        jTable.getColumn("Edit").setCellRenderer(new CustomTableAction());
        jTable.getColumn("Edit").setCellEditor(new CustomCellEditor(editor));

        //promenqm razmera na kolonkite
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // za da mojem da manipulirame po- lesno razmera na kolonkite
        jTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(60);

        //promenqme razmera na redovete
        jTable.setRowHeight(30);

        model.addRow(new Bsks().toTableRow());
        model.addRow(new Bsks().toTableRow());
        model.addRow(new Bsks().toTableRow());
        model.addRow(new Bsks().toTableRow());
        model.addRow(new Bsks().toTableRow());
        model.addRow(new Bsks().toTableRow());
        model.addRow(new Bsks().toTableRow());

        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBounds(20,30, 510, 300);

        /*JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setSize(300,200);

        ActionButton delete = new ActionButton();
        ActionButton delete2 = new ActionButton();
        delete2.setBounds(150,0,150,200);
        delete.setBounds(0,0,150,200);
        panel.add(delete);
        panel.add(delete2);*/

        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
