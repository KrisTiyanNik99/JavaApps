package NewTest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class buttonTest {
    public static void main(String[] args) {
        JFrame da = new JFrame();
        da.setSize(400,400);
        da.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        da.setLayout(null);
        JButton mm = new JButton();

        //slagame snimka na butona
        ImageIcon icon = new ImageIcon("vedena.png");
        Image resize = icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon editIcon = new ImageIcon(resize);
        mm.setIcon(editIcon);
        mm.setBounds(0,0,300,100);
        mm.setText("Vedena");
        mm.setBackground(Color.yellow);
        mm.setVerticalTextPosition(AbstractButton.CENTER);
        mm.setHorizontalTextPosition(AbstractButton.LEADING);

        da.add(mm);
        da.setVisible(true);
    }
}
