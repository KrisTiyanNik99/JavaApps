package guis.components;

import guis.MainJpanel;

import javax.swing.*;
import java.util.List;

public class ConsumablesPanel extends MainJpanel {

    boolean isPrinted = false;
    public ConsumablesPanel(String title, List<String> printOrder) {
        super(title, printOrder);
    }

    @Override
    protected void initCustomComponents(List<String> printOrder, JButton addOrder, JButton reset) {


        //String bira = "Консумативи заявка\n\n";
        //printOrder.add(bira);
        // This is Test block for now -------------------------------------
        //print.setBackground();
    }
}
