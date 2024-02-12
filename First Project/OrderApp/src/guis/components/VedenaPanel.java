package guis.components;

import custom.Product;
import functions.CustomTableModel;
import functions.DataParser;
import functions.SpinnerCellEditor;
import functions.TableCellRender;
import guis.MainJpanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Double.parseDouble;
import static javax.swing.BorderFactory.createEmptyBorder;

public class VedenaPanel extends MainJpanel {
    // Init boolean to check if some button is pressed
    boolean isAdded = false;

    public VedenaPanel(String title, List<String> printOrder) {
        super(title, printOrder);
    }

    @Override
    protected void initCustomComponents(List<String> printOrder, JButton addOrder, JButton reset) {
        // Create a table model
        CustomTableModel tableModel = new CustomTableModel();

        // Create columns and add it to TableModel
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Price");
        tableModel.addColumn("Total Price");

        // Create JTable and add TableModel to table
        JTable table = new JTable(tableModel);

        // Add header setting to JTable
        addJTableHeaderSettings(table);

        // Add column and row cell settings
        addJTableRenderSettings(table);

        // Add data to our table
        tableDataInitialization(tableModel);

        // Initialize ScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(1, 190, 580, 200);
        scrollPane.setBackground(new Color(111, 112, 111));
        scrollPane.getViewport().setBackground(new Color(111, 112, 111));
        scrollPane.setBorder(createEmptyBorder());

        // Add ScrollPane to main JPanel
        add(scrollPane);

        // Add fields thanks to which we will be able to add products to the table
        JTextField nameField = new JTextField();
        nameField.setBounds(8, 135, 185, 36);
        nameField.setFont(new Font("Dialog", Font.BOLD, 22));
        nameField.setForeground(Color.WHITE);
        nameField.setBackground(new Color(111, 112, 111));
        add(nameField);

        JTextField priceField = new JTextField();
        priceField.setBounds(200, 135, 105, 36);
        priceField.setFont(new Font("Dialog", Font.BOLD, 22));
        priceField.setForeground(Color.WHITE);
        priceField.setBackground(new Color(111, 112, 111));
        add(priceField);

        // Initialize add button
        JButton adding = new JButton("Add Product");
        adding.setBounds(317, 135, 155, 36);
        addButtonSettings(adding);
        add(adding);

        // Add save info button
        JButton save = new JButton("Save");
        save.setBounds(480, 135, 80, 36);
        addButtonSettings(save);
        add(save);

        // Add Functions to the buttons--------------------------------
        reset.addActionListener(e -> {
            if (isAdded) {
                addDialogWindow("Your request order is canceled!", "Reset");

                // Make our main List with Order clear from this order!---------------------------------------
                clearOrder(printOrder);

                isAdded = false;
            }
        });
        addOrder.addActionListener(e -> {
            // We check if the request has been added to our list of requests
            if (!isAdded) {
                // Add some mandatory setting to our table if we want to select all rows and columns in the future
                table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                table.setRowSelectionAllowed(true);
                table.setRowSelectionInterval(0, table.getRowCount() - 1);

                // If it is not added, we add it
                printOrderFormat(table, printOrder);
                JOptionPane.showMessageDialog(new Frame(),
                        "You successfully added your order to the storage!", "Add", JOptionPane.INFORMATION_MESSAGE);

                isAdded = true;
            } else {
                // If the request has already been added we want to notify the user with this message
                addDialogWindow("""
                        You already add your Order to the storage.
                        If you want to cancel this request press 'Reset' button.
                        You can also press the 'Print' if you are SURE you are DONE with adding orders!!!""", "Error");
            }
        });
        adding.addActionListener(e -> {
            if (!nameField.getText().isEmpty() && !priceField.getText().isEmpty()) {
                // Check if priceField is different then double num
                try {
                    // If all fields are fine we parse date from priceField to Double num
                    double price = parseDouble(priceField.getText());
                    tableModel.addRow(new Product(nameField.getText(), price).toTable());

                    // After all we clear ourJTextFields
                    nameField.setText("");
                    priceField.setText("");
                } catch (Exception ignored) {
                    // Dialog that will show if someone entered letters in the price field
                    addDialogWindow("Price field is not filled in correctly!!", "Invalid");
                }
            } else {
                // Dialog that will show when you try to add some product with empty fields
                addDialogWindow("Empty field/s!!", "Error");
            }
        });
        //save.addActionListener();--------------------------------------------------
    }

    // This is the method that will shape the request as a cash receipt
    private static void printOrderFormat(JTable table, List<String> printOrder) {
        // First we create StringBuilder who will store all elements from JTable
        StringBuilder products = new StringBuilder();

        // Put a unique text indicator to the request
        products.append("Ведена заявка \n");
        products.append("#===============================================================\n\n");

        // After that we put all rows in int array
        int[] rows = table.getSelectedRows();

        // We need to see what is total price in the end
        double totalPrice = 0.00;

        // Count products
        int countProducts = 0;

        for (int i = 0; i < rows.length; i++) {
            if (table.getValueAt(i, 2) != null) {

                // For int we need to parse table.getValueAt(i,2) to String and then To int - same for double
                int quantity = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));

                if (quantity > 0) {
                    // Set values from table by columns in different values types
                    String nameProduct = String.valueOf(table.getValueAt(i, 1));
                    countProducts ++;

                    // Split last colum because it contains "$" symbol
                    String[] totalPriceString = String.valueOf(table.getValueAt(i, 4)).split(" ");
                    double totalPricePerProduct = Double.parseDouble(totalPriceString[1]);

                    products.append("# в.п.").append(countProducts).append(" : ")
                            .append(nameProduct).append(" -- ").append(quantity).append(" броя -- ").
                            append(totalPricePerProduct).append("лв.").append("\n");

                    totalPrice += totalPricePerProduct;
                }
            }
        }

        // Set format
        DecimalFormat df = new DecimalFormat("#.##");
        totalPrice = parseDouble(df.format(totalPrice));

        // End point of this order
        products.append("\n").append("# в.п. Обща сума от заявката, без отстъпка : ").append(totalPrice).append("\n");
        products.append("#===============================================================\n\n");

        // Add our order to List
        System.out.println(products);
        printOrder.add(products.toString());
    }

    // Method A method that will take care of removing the request made by this JPanel
    private static void clearOrder(List<String> printOrders){
        // Loop our List with orders
        for (int i = 0; i < printOrders.size(); i++) {
            String order = printOrders.get(i);

            // We check which request is the lead one because it collides with a special notation and remove it
            if (order.contains("Ведена заявка")){
                printOrders.remove(i);
                break;
            }
        }
    }

    // Method for set mandatory settings to our buttons
    private static void addButtonSettings(JButton button) {
        // Add mandatory settings
        button.setFont(new Font("Dialog", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBackground(new Color(110, 89, 222));
    }

    // Method for JTable frontend settings
    private static void addJTableHeaderSettings(JTable table) {
        // Settings for header
        table.getTableHeader().setFont(new Font("Colors", Font.BOLD, 15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(110, 89, 222));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(Color.YELLOW);
        table.setRowHeight(25);

        // Sei ID column invisible because we only need it for functionality
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    // Method that will collide all cell render elements
    private static void addJTableRenderSettings(JTable table) {
        // Add custom Spinner Cell editor class and DefaultCellRender to first two columns
        table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Update name Product
                Product currentName = (Product) table.getValueAt(row, 0);
                currentName.editName(String.valueOf(value));

                return this;
            }
        });
        table.getColumnModel().getColumn(2).setCellEditor(new SpinnerCellEditor());

        for (int i = 2; i < table.getColumnCount(); i++) {

            // Check when it is the price column we will override our TableCellRender with specific function
            if (i == 3) {
                table.getColumnModel().getColumn(i).setCellRenderer(new TableCellRender() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                        // Update price value
                        Product currentProduct = (Product) table.getValueAt(row, 0);
                        double currentPrice = parseDouble(String.valueOf(value));
                        currentProduct.editPrice(currentPrice);

                        return this;
                    }
                });
            } else {
                table.getColumnModel().getColumn(i).setCellRenderer(new TableCellRender());
            }
        }
    }

    // Method who will set our mandatory data from 'productsStore' file
    private static void tableDataInitialization(CustomTableModel tableModel) {
        // Init our DataParser object and set his List
        DataParser data = new DataParser();
        List<Product> products = data.setDataProduct();

        // We create a for loop to loop through all the elements and layer them into our table
        for (Product currentProduct : products) {
            tableModel.addRow(currentProduct.toTable());
        }
    }

    // Method for Dialog Messages
    private static void addDialogWindow(String message, String title){
        // Dialog who will show if someone try to do something that will break the program
        JOptionPane.showMessageDialog(new Frame(),
                message, title, JOptionPane.ERROR_MESSAGE);
    }
}
