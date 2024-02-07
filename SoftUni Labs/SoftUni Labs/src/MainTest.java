import javax.swing.*;

public abstract class MainTest extends JPanel {


    StringBuilder storeInfo = new StringBuilder();
    public MainTest(){
        initComponents(storeInfo);
    }

    public void initComponents(StringBuilder storeInfo){
        setLayout(null);
        setBounds(0,80, 800,420);

        JButton print = new JButton("Print Info");
        print.setBounds(280,0,80,80);
        print.addActionListener(e->{
            System.out.println(storeInfo);
            GlabalString.getInstance().setData(storeInfo);
        });

        add(print);

        initGui(storeInfo);
    }

    public abstract void initGui(StringBuilder storeInfo);
}
