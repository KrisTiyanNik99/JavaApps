import javax.swing.*;
import java.awt.*;

public class NewTestJpanel extends JPanel {

    public NewTestJpanel(StringBuilder order){
        setLayout(null);
        setBounds(0,90, 800, 410);
        setBackground(Color.GREEN);

        TextField username = new TextField();
        username.setBounds(0,50,150,20);
        add(username);

        JButton extractText = new JButton("extract");
        extractText.setBounds(160, 50, 50,20);
        extractText.addActionListener(e-> {
            extract(username, order);
        });
        add(extractText);
    }

    public void extract(TextField username, StringBuilder order){
        String model = username.getText();
        if(model != null || !model.equals(" ")) {
            order.append(username.getText() + "\n");
            username.setText("");
        }else {
            System.out.println("Nothing!");
        }
    }
}
