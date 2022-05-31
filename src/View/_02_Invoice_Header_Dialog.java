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
public class _02_Invoice_Header_Dialog extends JDialog {
    private JTextField CustomerJText;
    private JTextField DateJText;
    private JLabel CustomerJLabel;
    private JLabel DateJLabel;
    private JButton OkJButton;
    private JButton CancelJButton;
    public _02_Invoice_Header_Dialog(_01_SIG_Main_JFrame frame)
    {
        //Prepare Jdialog components
        CustomerJLabel = new JLabel("Customer Name:");
        CustomerJText = new JTextField(20);
        DateJLabel = new JLabel("Invoice Date:");
        DateJText = new JTextField(20);
        OkJButton = new JButton("OK");
        CancelJButton = new JButton("Cancel");
        //Set action commands for each button
        OkJButton.setActionCommand("createInvoiceOK");
        CancelJButton.setActionCommand("createInvoiceCancel");
        //add action listener to the main listener class
        OkJButton.addActionListener(frame.getListener());
        CancelJButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));
        add(DateJLabel);
        add(DateJText);
        add(CustomerJLabel);
        add(CustomerJText);
        add(OkJButton);
        add(CancelJButton);
        pack();
    }

    
    public JTextField getCustomerJText() {
        return CustomerJText;
    }

    
    public JTextField getDateJText() {
        return DateJText;
    }
    
    
}
