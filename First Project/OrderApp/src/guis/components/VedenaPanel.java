package guis.components;

import guis.MainJpanel;

import javax.swing.*;
import java.awt.*;

public class VedenaPanel extends MainJpanel {

    public VedenaPanel(String title, StringBuilder printOrder) {
        super(title, printOrder);
    }

    @Override
    protected void initCustomComponents(StringBuilder printOrder) {

        // This is test block for now
        printOrder.append("Ot vedena\n");
        JButton test = new JButton("Print");
        test.setBounds(0, 200, 50,50);
        test.addActionListener(e->System.out.println(printOrder));
        add(test);
    }
}
