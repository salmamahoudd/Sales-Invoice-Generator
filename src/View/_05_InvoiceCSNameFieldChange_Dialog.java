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
public class _05_InvoiceCSNameFieldChange_Dialog extends JDialog
{
    private JTextField NewCustomerNameJText;
    private JLabel NweCustomerNameJLabel;
    private JButton OkJButton;
    private JButton CancelJButton;
    public _05_InvoiceCSNameFieldChange_Dialog (_01_SIG_Main_JFrame frame)
    {
        //Prepare Jdialog components
        NweCustomerNameJLabel = new JLabel("New Customer Name:");
        NewCustomerNameJText = new JTextField(10);
        OkJButton = new JButton("OK");
        CancelJButton = new JButton("Cancel");
        //Set action commands for each button
        OkJButton.setActionCommand("NewCustomerNameOK");
        CancelJButton.setActionCommand("NewCustomerNameCancel");
        //add action listener to the main listener class
        OkJButton.addActionListener(frame.getListener());
        CancelJButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(2, 4));
        add(NweCustomerNameJLabel);
        add(NewCustomerNameJText);
        add(OkJButton);
        add(CancelJButton);
        pack();
    }
    public JTextField getNewCustomerNameJText() 
    {
        return NewCustomerNameJText;
    }
}
