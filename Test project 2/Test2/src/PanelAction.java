import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelAction extends JPanel {
    //suzdavame instancii na kustom klasa buton koito iskame
    ActionButton delete, edit;
    public PanelAction() {

        //suzdavame metod koito da se griji za suzdavaneto na componentite na panela
        initComponent();
    }

    private void initComponent() {
        //suzdame obekti ot kustom klasa ActionButton
        delete = new ActionButton();
        edit = new ActionButton();

        //suzdame ikonki
        Icon deleting = new ImageIcon("delete.png");
        Icon editing = new ImageIcon("edit.png");

        //slagame ikonki na butonchetata
        delete.setIcon(deleting);
        edit.setIcon(editing);

        //suzdavame grouplayout za da mojem po- lesno da kontrolirame elementite v jpanela
        GroupLayout layout = new GroupLayout(this);
        //na tozi kustom jpanel mu slagame grouplayouta
        this.setLayout(layout);
        //nastroiki na horizontalniq layout
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(400, 300 , 400, 300);
    }
}
