package guis.components;

import guis.MainJpanel;

import javax.swing.*;

public class BiroterapiyaPanel extends MainJpanel {

    public BiroterapiyaPanel(String title, StringBuilder printOrder){
        super(title, printOrder);
    }

    @Override
    protected void initCustomComponents(StringBuilder printOrder) {

        // This is test block for now
        printOrder.append("Ot biroterapiq\n");
        JButton test = new JButton("Print");
        test.setBounds(0, 200, 50,50);
        add(test);
    }
}
