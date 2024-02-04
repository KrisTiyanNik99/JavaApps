package guis;

import javax.swing.*;
import java.awt.*;

/*
    This is GUI for our main beer supplier- "Vedena"
*/
public class VedenaGui extends MainFrame{

    public VedenaGui() {
        super("Order app");
    }

    @Override
    protected void addGuiTemplate() {
        // Create a dashboard
        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);

        // Set size and location of dashboard
        dashboard.setBounds(0,0,165,500);

        // Set color in dashboard
        dashboard.setBackground(new Color(54,33,89));

        // Add dashboard elements
        

        // Add dashboard to vedena GUI
        add(dashboard);
    }
}
