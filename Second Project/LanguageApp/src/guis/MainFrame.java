package guis;

import javax.swing.*;

public class MainFrame extends JFrame {
    // We create a constructor for our MainFrame
    public MainFrame(String title) {

        // In the constructor we have a method that creates our frame settings
        initComponents(title);
    }

    public void initComponents(String title) {

        // From here we lower the settings to MainFrame
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setLocationRelativeTo(null);

        // Set our main JPanel who will display all things in our app
        JLanguagePanel main = new JLanguagePanel(getWidth(), getHeight());
        add(main);
    }
}
