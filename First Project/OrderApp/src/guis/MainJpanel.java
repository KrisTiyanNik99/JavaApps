package guis;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
    This main JPanel will be just a template for the other ones
*/
public abstract class MainJpanel extends JPanel {

    public MainJpanel(String title, List<String> printOrder) {
        initComponents(title, printOrder);
    }

    private void initComponents(String title, List<String> printOrder) {
        // Add settings to MainJPanel that will be constant for all objects from this class
        setLayout(null);
        setBounds(205, 0, 605, 500);
        setBackground(new Color(24, 24, 24));

        JPanel headLine = new JPanel();
        headLine.setLayout(null);
        headLine.setBounds(1, 11, 605, 100);
        headLine.setBackground(new Color(110, 89, 222));

        // Create a text label like e header and set settings
        JLabel header = new JLabel("You chose: " + title);
        header.setBounds(0, 25, 605, 50);
        header.setFont(new Font("Dialog", Font.BOLD, 25));
        header.setForeground(Color.WHITE);
        header.setVerticalAlignment(SwingConstants.CENTER);
        header.setHorizontalAlignment(SwingConstants.CENTER);

        // Create print JButton
        JButton print = new JButton("Print Orders!");
        print.setBounds(415, 410, 140, 40);
        addButtonSettings(print);
        print.setBackground(new Color(90, 64, 217));

        // Add function to print button
        print.addActionListener(e -> {
            if (!printOrder.isEmpty()) {
                // A method that will execute if our storage IS NOT empty
                printOrderAction(printOrder);
                JOptionPane.showMessageDialog(new Frame(),
                        "You successfully print your order!", "Print", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Popup dialog box that will repent if the storage is empty
                JOptionPane.showMessageDialog(new Frame(),
                        "You can't print empty storage\n" +
                                "To fill the storage, click on one of the suppliers in the dashboard on the left",
                        "Empty", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(print);

        // Add addOrder button
        JButton addOrder = new JButton("Add Order");
        addOrder.setBounds(8, 410, 140, 40);
        addButtonSettings(addOrder);
        add(addOrder);

        // Add Reset button
        JButton reset = new JButton("Reset");
        reset.setBounds(155, 410, 140, 40);
        addButtonSettings(reset);
        add(reset);

        // Add JLabel to the main JPanel
        headLine.add(header);
        add(headLine);

        // Initialize different GUIs
        initCustomComponents(printOrder, addOrder, reset);
    }

    // Method for set mandatory settings to the buttons
    private static void addButtonSettings(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(154, 141, 231, 255));
        button.setFont(new Font("Text", Font.BOLD, 15));
        button.setFocusPainted(false);
    }

    // Method that prints the requests made up to the moment of pressing the print button
    private static void printOrderAction(List<String> printOrder) {
        // Init StringBuilder that will collide in itself the elements that are from the List
        StringBuilder orders = new StringBuilder();

        try {
            // First we need to create our file
            File ourOrder = new File("PrintedOrder.txt");
            if (ourOrder.createNewFile()) {
                System.out.println("File was successfully created");
            }

            // Next we want to write the elements that our List have to the new file
            FileWriter printing = new FileWriter("PrintedOrder.txt");

            // Loop through all elements in the List
            for (String singleOrder : printOrder) {
                // We add all single element to our StringBuilder
                orders.append(singleOrder).append("\n");
            }

            // After the loop we just wrote all in the file
            printing.write(orders.toString());
            printing.close();

        } catch (IOException e) {
            System.out.println("An error file system!");
        }
    }

    // Create abstract method that we can create as we want
    protected abstract void initCustomComponents(List<String> printOrder, JButton addOrder, JButton reset);
}
