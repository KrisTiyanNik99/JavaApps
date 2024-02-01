import javax.swing.*;
import java.awt.*;

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
        //tozi metod se griji za zadavaneto na metodi kym butonite sled poluchavane na obekt ot CustomTableActionEvent
        edit.addActionListener(e -> event.onEdit(row));
        //sled kato CustomTableActionEvent obekta vednuj e poluchil ot kakvo mu pravqt metodite v main3 nie tuk prosto gi slagame da rabotqt po butonite
        delete.addActionListener(e-> event.onDelete(row));
    }
}
