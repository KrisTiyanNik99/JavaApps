import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJpanel extends JPanel {
    private ActionButton delete;
    private ActionButton edit;
    public NewJpanel() {
        setLayout(null);
        setBackground(Color.BLACK);
        setSize(60,30);
        delete = new ActionButton();
        edit = new ActionButton();
        delete.deleteImage();
        edit.editImage();
        delete.setBounds(0,0,30,30);
        edit.setBounds(30,0,30,30);
        add(delete);
        add(edit);
    }

    public void initEvent(CustomTableActionEvent event, int row){
        //tozi metod se griji za zadavaneto na metodi kym butonite
        edit.addActionListener(e -> event.onEdit(row));
        delete.addActionListener(e-> event.onDelete(row));
    }
}
