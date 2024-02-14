import components.MainFrame;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {

        // Run App
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame("Language Application").setVisible(true);
            }
        });
    }
}
