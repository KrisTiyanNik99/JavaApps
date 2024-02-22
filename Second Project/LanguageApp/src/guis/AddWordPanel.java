package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddWordPanel extends JFrame {

    public AddWordPanel(int width, int height, JMenuBar menuBar) {

        addComponents(width, height, menuBar);
    }

    private void addComponents(int width, int height, JMenuBar menuBar) {

        // Setting up our JFrame
        setMandatoryFrameSettings(width, height);
        getContentPane().setBackground(Color.RED);

        // Set already setup menu bar who come from our MainFrame
        setJMenuBar(menuBar);
        setActionsToMenuItems(menuBar);

        // Add text fields
        JTextField word = new JTextField();
        word.setFont(new Font("Word", Font.BOLD, 20));
        word.setBounds(10, 80, 300, 40);

        JTextField translated = new JTextField();
        translated.setFont(new Font("Translated", Font.BOLD, 20));
        translated.setBounds(10, 210, 300, 40);

        JTextField emoji = new JTextField();
        emoji.setFont(new Font("Emoji", Font.BOLD, 20));
        emoji.setBounds(10, 340, 300, 40);

        // Add all text fields to the frame
        add(word);
        add(translated);
        add(emoji);

        // Button who add this new word
        JButton addWord = new JButton("Add word");
        addWord.setBounds(560, 485, 200, 50);
        addWord.setFocusPainted(false);
        add(addWord);

        setVisible(true);
    }

    private static void removeActions(JMenuItem item) {

        ActionListener[] listeners = item.getActionListeners();
        for (ActionListener listener : listeners) {

            // Now we remove all actions from our buttons
            item.removeActionListener(listener);
        }
    }

    private void setActionsToMenuItems(JMenuBar menuBar) {

        // Get first menu item
        JMenu firstMenu = menuBar.getMenu(0);
        JMenuItem firstItem = firstMenu.getItem(0);

        // Remove all actions
        removeActions(firstItem);

        // Set new action
        firstItem.addActionListener(e -> {
            dispose();
            new MainFrame();
        });

        // Repeat the for second menu item
        JMenuItem secondItem = menuBar.getMenu(1).getItem(0);
        removeActions(secondItem);
        secondItem.addActionListener(e -> {
            dispose();
            new AddWordPanel(getWidth(), getHeight(), menuBar);
        });
    }

    private void setMandatoryFrameSettings(int width, int height) {

        // Set settings to our custom JFrame
        setLayout(null);
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
