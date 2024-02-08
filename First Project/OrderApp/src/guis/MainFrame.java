package guis;

import guis.components.BiroterapiyaPanel;
import guis.components.HomePanel;
import guis.components.VedenaPanel;

import javax.swing.*;
import java.awt.*;

/*
    Here we set up first major part of our App - main GUI
*/
public class MainFrame extends JFrame {
    // General width and height that will be applied to all elements that need it
    int width = 205;
    int height = 60;

    public MainFrame(String title) {
        // Add StringBuilder who will store all info coming from the other classes
        StringBuilder printOrder = new StringBuilder();

        // Add components to main frame
        templateInitialize(title, printOrder);
    }

    // Initialize Dashboard and his components with main JFrame settings
    private void templateInitialize(String title, StringBuilder printOrder) {
        // Add a title to main JFrame
        setTitle(title);

        // Set size settings
        setSize(805, 500);

        // Closing settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Prevent GUI to be resized
        setResizable(false);

        // Launch app in the center of window
        setLocationRelativeTo(null);

        // Set layout to null for easy manipulation the elements
        setLayout(null);

        // Create a dashboard
        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);

        // Set size and location of dashboard
        dashboard.setBounds(0, 0, width, 500);

        // Set color in dashboard
        dashboard.setBackground(new Color(54, 33, 89));

        // Create JLabel for header
        JLabel header = new JLabel(" Choose a supplier");
        header.setBounds(0, 30, 165, 20);

        // Change font style and color
        header.setFont(new Font("Dialog", Font.BOLD, 18));
        header.setForeground(new Color(204, 204, 204));

        // Center the JLabel text
        header.setHorizontalAlignment(SwingConstants.CENTER);

        // Add JLabel to dashboard
        dashboard.add(header);

        // Home button
        JButton home = new JButton("Home          ");
        home.setBounds(0, 82, width, height - 5);
        addButtonSettings("home.png", home);
        dashboard.add(home);

        // Create Biroterapiq button
        JButton biroterapiya = new JButton("Biroterapiya");
        biroterapiya.setBounds(0, 181, width, height);
        addButtonSettings("biroterapiq.png", biroterapiya);
        dashboard.add(biroterapiya);

        // Create consumer button
        JButton consumables = new JButton("Consumables");
        consumables.setBounds(0, 282, width, height);
        addButtonSettings("consumer.png", consumables);
        dashboard.add(consumables);

        // Create Vedena button
        JButton vedena = new JButton("Vedena        ");
        vedena.setBounds(0, 382, width, height - 5);
        addButtonSettings("vedena.png", vedena);

        //Create objects from different GUIs
        HomePanel homePage = new HomePanel("Choose supplier!");
        VedenaPanel vedenaPage = new VedenaPanel("You choose " + vedena.getText(), printOrder);
        BiroterapiyaPanel biroterapiyaPage = new BiroterapiyaPanel("You choose " + biroterapiya.getText(), printOrder);
        vedenaPage.setVisible(false);

        // Add functionality to the buttons------------------------------------------
        home.addActionListener(e -> {
            homePage.setVisible(true);
            vedenaPage.setVisible(false);
        });
        //biroterapiya.addActionListener(e -> {});
        //consumables.addActionListener();------------------------------------------
        vedena.addActionListener(e -> {
            vedenaPage.setVisible(true);
            homePage.setVisible(false);
        });

        // Add button vedena to dashboard
        dashboard.add(vedena);

        // Add dashboard to Main GUI
        add(dashboard);

        // Add all GUIS to main Frame by default
        add(homePage);
        add(vedenaPage);
    }

    // A method that automatically puts the settings of the buttons in Main frame GUI
    private void addButtonSettings(String url, JButton button) {
        // Set color background
        button.setBackground(new Color(85, 65, 118));

        // Set color text to the button
        button.setForeground(new Color(204, 204, 204));

        // Remove the box surrounded the text inside the JButton
        button.setFocusPainted(false);

        // Remove border surrounded the button
        button.setBorderPainted(false);

        // Add ImageIcon
        ImageIcon icon = new ImageIcon(url);

        // Parse ImageIcon to Image and resize the png file
        Image resize = icon.getImage().getScaledInstance(85, 60, Image.SCALE_DEFAULT);
        ImageIcon editIcon = new ImageIcon(resize);

        // Add icon to the button
        button.setIcon(editIcon);
    }
}
