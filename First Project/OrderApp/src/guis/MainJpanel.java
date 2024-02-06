package guis;

import javax.swing.*;
import java.awt.*;

/*
    This main JPanel will be just a template for the other ones
*/
public abstract class MainJpanel extends JPanel {
    StringBuilder printOrder = new StringBuilder();
    public MainJpanel(String title){
        initComponents(title, printOrder);
    }

    private void initComponents(String title, StringBuilder printOrder){
        // Add settings to MainJPanel that will be constant for all objects from this class
        setLayout(null);
        setBounds(205,10, 605, 100);
        setBackground(new Color(110,89,222));

        // Create a text label like e header and set settings
        JLabel header = new JLabel(title);
        header.setBounds(0,25,605,50);
        header.setFont(new Font("Dialog", Font.BOLD, 25));
        header.setForeground(new Color(204, 204, 204));
        header.setVerticalAlignment(SwingConstants.CENTER);
        header.setHorizontalAlignment(SwingConstants.CENTER);

        // Add JLabel to the main JPanel
        add(header);

        // Initialize different GUIs
        initGui(printOrder);
    }

    // Create abstract method that we can create as we want
    protected abstract void initGui(StringBuilder printOrder);
}
