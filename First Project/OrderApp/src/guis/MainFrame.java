package guis;

import javax.swing.*;
    /*
        Here we setup the blueprints that the GUIs will follow for example
    */
public abstract class MainFrame extends JFrame {

    public MainFrame(String title){
        templateInitialize(title);
    }

    private void templateInitialize(String title){
        // Add a title to main JFrame
        setTitle(title);

        // Set size settings
        setSize(765,500);

        // Closing settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Prevent GUI to be resized
        setResizable(false);

        // Launch app in the center of window
        setLocationRelativeTo(null);

        // GUI components
        addGuiTemplate();
    }

    //A method who will be defined by every subclass
    protected abstract void addGuiTemplate();
}
