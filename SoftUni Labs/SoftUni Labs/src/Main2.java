import javax.swing.*;

public class Main2 {
    public static void main(String[] args) {
        //StringBuilder allCars = new StringBuilder();

        JFrame name = new JFrame();
        name.setLayout(null);
        name.setSize(800,500);
        name.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TestJpanel test1 = new TestJpanel();
        NewTestJpanel test2 = new NewTestJpanel();
        test1.setVisible(true);
        test2.setVisible(false);
        JButton change = new JButton("Change");
        change.setBounds(0,0,80,80);
        change.addActionListener(e->{
            if(test1.isVisible()){
                test1.setVisible(false);
                test2.setVisible(true);
            }else {
                test1.setVisible(true);
                test2.setVisible(false);
            }
        });

        JButton all = new JButton("print");
        all.setBounds(80,0,80,80);
        all.addActionListener(e->{
            System.out.println(GlabalString.getInstance().getData());
        });
        name.add(all);


        /*JPanel test = new JPanel();
        test.setLayout(null);
        test.setSize(800,500);
        test.setBackground(Color.yellow);*/


        /*TestJpanel test1 = new TestJpanel(allCars);
        NewTestJpanel test2 = new NewTestJpanel(allCars);
        test2.setVisible(false);

        test.add(change);*/


        /*JButton print = new JButton("Print");
        print.setBounds(90,0, 80,80);
        print.addActionListener(e->{
            StringBuilder newOrderFromAllCars = allCars;
            System.out.println(newOrderFromAllCars);
        });
        test.add(print);

        name.add(test1);
        name.add(test2);
        name.add(test);*/
        name.add(test1);
        name.add(test2);
        name.add(change);
        name.setVisible(true);
    }
}
