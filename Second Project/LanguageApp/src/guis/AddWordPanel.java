package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddWordPanel extends JFrame {

    public AddWordPanel(int width, int height, JMenuBar menuBar){

        addComponents(width, height, menuBar);
    }

    private void addComponents(int width, int height, JMenuBar menuBar){

        // Setting up our JFrame
        setMandatoryFrameSettings(width, height);
        getContentPane().setBackground(Color.BLUE);

        // Set already setup menu bar who come from our MainFrame
        setJMenuBar(menuBar);
        setActionsToMenuItems(menuBar);

        
        setVisible(true);
    }

    private static void removeActions(JMenuItem item) {

        ActionListener[] listeners = item.getActionListeners();
        for (ActionListener listener : listeners) {

            // Now we remove all actions from our buttons
            item.removeActionListener(listener);
        }
    }

    private void setActionsToMenuItems(JMenuBar menuBar){

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
