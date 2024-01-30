import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ActionButton extends JButton {
    public ActionButton() {
        setBorder(new EmptyBorder(3,3,3,3));
    }

    public void editImage() {
        ImageIcon icon = new ImageIcon("edit.png");
        Image resize = icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon editIcon = new ImageIcon(resize);
        setIcon(editIcon);
        addActionListener(e -> {
            System.out.println("Editor bachake e......");
        });
    }

    public void deleteImage() {
        ImageIcon icon = new ImageIcon("delete.png");
        Image resize = icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon deleteIcon = new ImageIcon(resize);
        setIcon(deleteIcon);
    }

    //metod s koito testvam kak moga da promenq izgleda na samiq buton
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width,height);
        int x = (width-size)/2;
        int y = (height-size)/2;
        g2.fill(new Ellipse2D.Double(x,y,size,size));
        g2.dispose();
        super.paintComponent(graphics);
    }
}
