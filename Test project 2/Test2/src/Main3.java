import javax.swing.*;
import java.awt.*;

public class Main3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test 2");

        PanelAction action = new PanelAction();
        frame.add(action);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(820,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
