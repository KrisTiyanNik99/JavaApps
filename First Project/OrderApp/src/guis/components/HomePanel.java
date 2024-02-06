package guis.components;

import javax.swing.*;
import java.awt.*;

/*
    This panel will be the first thing to load into the program, it will also appear
    when user clicks on the home button in MainFrame class
*/
public class HomePanel extends JPanel {
    public HomePanel(String title) {
        // Add settings to HomePanel
        setLayout(null);
        setBounds(205, 0, 605, 500);
        setBackground(new Color(24, 24, 24));

        // Add a headline to Home Panel
        JPanel headLine = new JPanel();
        headLine.setLayout(null);
        headLine.setBounds(1, 11, 605, 100);
        headLine.setBackground(new Color(110, 89, 222));

        // Create a text label like e header and set settings
        JLabel header = new JLabel(title);
        header.setBounds(0, 25, 605, 50);
        header.setFont(new Font("Dialog", Font.BOLD, 25));
        header.setForeground(new Color(204, 204, 204));
        header.setVerticalAlignment(SwingConstants.CENTER);
        header.setHorizontalAlignment(SwingConstants.CENTER);

        // Add logo to the place for which we make the program
        ImageIcon logo = new ImageIcon("cooldown.png");
        Image resize = logo.getImage().getScaledInstance(605, 450, Image.SCALE_DEFAULT);
        logo = new ImageIcon(resize);

        // Add JLabel where we can store the image
        JLabel body = new JLabel(logo);
        body.setBounds(0, 100, 590, 390);
        body.getBackground();
        add(body);

        // Add JLabel and Headline panel to home JPanel
        headLine.add(header);
        add(headLine);
    }
}
