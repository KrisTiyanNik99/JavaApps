import javax.swing.*;
import java.awt.*;

public class PanelAction extends JPanel {
    //suzdavame instancii na kustom klasa buton koito iskame
    ActionButton delete, edit;
    public PanelAction() {

        //suzdavame metod koito da se griji za suzdavaneto na componentite na panela
        initComponent();
    }

    private void initComponent() {
        setPreferredSize(new Dimension(10,10));
        setBounds(300, 30 , 200, 200);
        setBackground(Color.BLACK);

        //suzdame obekti ot kustom klasa ActionButton
        delete = new ActionButton();
        edit = new ActionButton();

        //suzdame ikonki
        ImageIcon deleting = new ImageIcon("delete.png");
        ImageIcon editing = new ImageIcon("edit.png");
        //resaizvame ikonkite zashtoto sa mnogo golemi no za tazi cel trqbva da sa Image
        Image icon = deleting.getImage().getScaledInstance(28,28, Image.SCALE_DEFAULT);
        Image icon2 = editing.getImage().getScaledInstance(28,28,Image.SCALE_DEFAULT);

        //slagame ikonki na butonchetata no gi parsvame kym ImageIcon zashtoto buntona raboti samo s ImageIcon a ne s Image
        delete.setIcon(new ImageIcon(icon));
        edit.setIcon(new ImageIcon(icon2));

        //suzdavame grouplayout za da mojem po- lesno da kontrolirame elementite v jpanela
        GroupLayout layout = new GroupLayout(this);
        //na tozi kustom jpanel mu slagame grouplayouta
        this.setLayout(layout);
        //nastroiki na horizontalniq layout
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
