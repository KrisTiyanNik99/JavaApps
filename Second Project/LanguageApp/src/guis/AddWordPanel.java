package guis;

import custom.WordList;

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

        // Set text labels to guide the user what, where and how to write
        setTextLabel();

        // Add all text fields to the frame
        add(word);
        add(translated);
        add(emoji);

        // Button who add this new word
        JButton addWord = new JButton("Add word");
        addWord.setBounds(560, 485, 200, 50);
        addWord.setFocusPainted(false);
        add(addWord);

        // Set action to the button
        addWord.addActionListener(e -> {

            // Check if any of out text fields are empty
            if (word.getText().isEmpty() || translated.getText().isEmpty() || emoji.getText().isEmpty()) {

                // Pop-up window with instructions
                JOptionPane.showMessageDialog(new Frame(),
                        "You must fill in all blank fields!", "Empty field?!", JOptionPane.ERROR_MESSAGE);
            } else {

                // Set function who add current word to our json file
                new WordList().addWordToJson(word.getText(), translated.getText(), emoji.getText());
                JOptionPane.showMessageDialog(new Frame(),
                        "You have successfully added a new word!", "New word!", JOptionPane.INFORMATION_MESSAGE);
            }

            // After all clear our text fields
            word.setText("");
            translated.setText("");
            emoji.setText("");
        });

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

    private void setTextLabel() {

        JLabel word = new JLabel("Write your word");
        word.setBounds(12, 58, 300, 20);
        word.setFont(new Font("Word", Font.BOLD, 20));
        word.setForeground(Color.BLACK);

        JLabel translated = new JLabel("Write translated word");
        translated.setBounds(12, 188, 300, 20);
        translated.setFont(new Font("Translated", Font.BOLD, 20));
        translated.setForeground(Color.BLACK);

        JLabel emoji = new JLabel("Set emoji");
        emoji.setBounds(12, 318, 300, 20);
        emoji.setFont(new Font("Emoji", Font.BOLD, 20));
        emoji.setForeground(Color.BLACK);

        add(word);
        add(translated);
        add(emoji);
    }
}
