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
public class _04_InvoiceDateFieldChange_Dialog extends JDialog
{
    private JTextField NewDateJText;
    private JLabel NewDateJLabel;
    private JButton OkJButton;
    private JButton CancelJButton;

    public _04_InvoiceDateFieldChange_Dialog(_01_SIG_Main_JFrame frame) 
    {
        //Prepare Jdialog components
        NewDateJLabel = new JLabel("New Invoice Date:");
        NewDateJText = new JTextField(20);
        OkJButton = new JButton("OK");
        CancelJButton = new JButton("Cancel");
        //Set action commands for each button
        OkJButton.setActionCommand("NewInvoiceDateOK");
        CancelJButton.setActionCommand("NewInvoiceDateCancel");
        //add action listener to the main listener class
        OkJButton.addActionListener(frame.getListener());
        CancelJButton.addActionListener(frame.getListener());
        setLayout(new GridLayout(2, 4));
        add(NewDateJLabel);
        add(NewDateJText);
        add(OkJButton);
        add(CancelJButton);
        pack();
    }
    public JTextField getNewDateJText() 
    {
        return NewDateJText;
    }
}
