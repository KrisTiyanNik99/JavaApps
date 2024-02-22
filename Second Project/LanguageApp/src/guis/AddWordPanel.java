package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddWordPanel extends JFrame {

    public AddWordPanel(int width, int height, JMenuBar menuBar){
        // Set settings to our custom JFrame
        setLayout(null);
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);
        setVisible(true);
    }

    private static void removeActions(JMenuItem item) {

        ActionListener[] listeners = item.getActionListeners();
        for (ActionListener listener : listeners) {

            // Now we remove all actions from our buttons
            item.removeActionListener(listener);
        }
    }
}
