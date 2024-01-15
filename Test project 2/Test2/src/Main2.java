import javax.swing.*;
import java.awt.*;

public class Main2 {
    public static void main(String[] args) {
        //Suzdavame test za Jframe
        JFrame frame = new JFrame("Test 2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //Suzdavane na panelite za da gi manipulirame
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        //Slagame cvetove na panelite koito shte manipulirame
        p1.setBackground(Color.yellow);
        p2.setBackground(Color.BLUE);
        p3.setBackground(Color.black);

        //Slagame razmeri
        p1.setPreferredSize(new Dimension(100,100));
        p2.setPreferredSize(new Dimension(200,100));
        p3.setPreferredSize(new Dimension(100,100));

        //SLagame kyde iskame da e panela
        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.WEST);
        frame.add(p3,BorderLayout.CENTER);
    }
}
