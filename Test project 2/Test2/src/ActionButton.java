import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ActionButton extends JButton {
    public ActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3,3,3,3));

    }

    protected void paintComponent(Graphics2D graphics){
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;
    }
}
