/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.Listener.frame;
import Main.Foucs_Restarter;
import Main.Main;
import View._01_SIG_Main_JFrame;
import View._04_InvoiceDateFieldChange_Dialog;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Kimo Store
 */
public class DateTextFieldChangeHandler implements FocusListener
{
    _01_SIG_Main_JFrame frame;
    //This is for Handle the focuse by disbling it and enable it after 50ms
    Foucs_Restarter foucs_Restarter;
    public DateTextFieldChangeHandler(_01_SIG_Main_JFrame frame) 
    {
        this.frame=frame;
        foucs_Restarter=new Foucs_Restarter(frame);
    }

    @Override
    public void focusGained(FocusEvent e) 
    {
        //check if date filed is occupied with date (i.e row seleted from left side)
       if(!(frame.getDateTF().getText().isEmpty()))
       {
           //ask user if he want to change date
           int dialogResult = JOptionPane.showConfirmDialog (frame, "Do you want to change date?","Warning",JOptionPane.YES_NO_OPTION);
           if(dialogResult == JOptionPane.YES_OPTION)
           {
               //if yes then I will call tha jdialog to take new date from it
               Listener.showNewInvoiceDateDialog();
               //remove foucus listener to disable repeated calls
               frame.getDateTF().removeFocusListener(Listener.dateLabelChangeHandler);
           }
           else
           {
               //remove foucus listener to disable repeated calls
               frame.getDateTF().removeFocusListener(Listener.dateLabelChangeHandler);
           }
           // run th foucus restarter to re-enable foucus listener after 50 ms 
           Main.executor2.schedule(foucs_Restarter,50, TimeUnit.MILLISECONDS);
       }
    }

    @Override
    public void focusLost(FocusEvent e)
    {
    }
}
