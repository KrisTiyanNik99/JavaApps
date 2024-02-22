package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    // We create a constructor for our MainFrame
    public MainFrame() {

        // In the constructor we have a method that creates our frame settings
        initComponents();
    }

    public void initComponents() {

        // From here we lower the settings to MainFrame
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Language Application");
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        // Set buttons and their settings
        JButton beginner = new JButton("Start for beginners");
        beginner.setBounds(250, 200, 300, 50);
        setButtonSettings(beginner);
        add(beginner);

        JButton advanced = new JButton("Start Advanced");
        advanced.setBounds(250, 300, 300, 50);
        setButtonSettings(advanced);
        add(advanced);

        JButton exit = new JButton("Exit");
        exit.setBounds(250, 400, 300, 50);
        setButtonSettings(exit);
        add(exit);

        // Create menu bar who will contain our menu options
        JMenuBar menuBar = new JMenuBar();

        // Create and add menus to main JMenu
        JMenu main = new JMenu("Main");
        JMenu addWord = new JMenu("Add");

        // Add menu items to the menus
        JMenuItem mainMenu = new JMenuItem("Go to main Menu");
        JMenuItem addGui = new JMenuItem("Add word");

        // Add menu items to the menus
        main.add(mainMenu);
        addWord.add(addGui);

        // Add all menus to main menu bar
        menuBar.add(main);
        menuBar.add(addWord);

        // Set actions to menu items
        removeActions(addGui);
        addGui.addActionListener(e -> {
            dispose();
            new AddWordPanel(getWidth(), getHeight(), menuBar);
        });

        // Set menu bar to this scene
        setJMenuBar(menuBar);

        // Add actions to the buttons
        beginner.addActionListener(e -> {
            dispose();
            new JLanguagePanel(getWidth(), getHeight(), menuBar);
        });

        setVisible(true);
    }

    // Method who set our button settings
    private void setButtonSettings(JButton button) {

        // Set mandatory settings
        button.setBackground(Color.yellow);
        button.setFont(new Font("Title", Font.BOLD, 20));
        button.setFocusable(false);
    }

    // Special method for removing all actions
    private static void removeActions(JMenuItem item) {

        ActionListener[] listeners = item.getActionListeners();
        for (ActionListener listener : listeners) {

            // Now we remove all actions from our buttons
            item.removeActionListener(listener);
        }
    }
}
