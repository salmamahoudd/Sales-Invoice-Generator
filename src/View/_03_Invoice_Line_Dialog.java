/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Kimo Store
 */
public class _03_Invoice_Line_Dialog extends JDialog {

    private JTextField ItemNameJText;
    private JTextField ItemCountJText;
    private JTextField ItemPriceJText;
    private JLabel ItemNameJLabel;
    private JLabel CountJLabel;
    private JLabel ItemPriceJLabel;
    private JButton okJButton;
    private JButton CancelJButton;

    public _03_Invoice_Line_Dialog(_01_SIG_Main_JFrame frame) {
        //Prepare Jdialog components
        ItemNameJText = new JTextField(20);
        ItemNameJLabel = new JLabel("Item Name");
        ItemCountJText = new JTextField(20);
        CountJLabel = new JLabel("Item Count");
        ItemPriceJText = new JTextField(20);
        ItemPriceJLabel = new JLabel("Item Price");
        okJButton = new JButton("OK");
        CancelJButton = new JButton("Cancel");
        //Set action commands for each button
        okJButton.setActionCommand("createLineOK");
        CancelJButton.setActionCommand("createLineCancel");
        //add action listener to the main listener class
        okJButton.addActionListener(frame.getListener());
        CancelJButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));
        add(ItemNameJLabel);
        add(ItemNameJText);
        add(CountJLabel);
        add(ItemCountJText);
        add(ItemPriceJLabel);
        add(ItemPriceJText);
        add(okJButton);
        add(CancelJButton);
        pack();
    }

    public JTextField getItemNameJText() {
        return ItemNameJText;
    }

    public JTextField getItemCountJText() {
        return ItemCountJText;
    }

    public JTextField getItemPriceJText() {
        return ItemPriceJText;
    }

}
