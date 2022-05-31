/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import View._01_SIG_Main_JFrame;

/**
 *
 * @author Kimo Store
 */
public class Button_Check extends Thread
{
    _01_SIG_Main_JFrame GUI;
    public Button_Check(_01_SIG_Main_JFrame GUI) 
    {
        this.GUI=GUI;
    }
    @Override
    public void run() 
    {
        //if no header row selected 
        //disable creat line and delete line buttons
        if(GUI.getInvoicesTable().getSelectedRow()<0)
        {
            GUI.getCreateLineBtn().setEnabled(false);                
            GUI.getDeleteBtn().setEnabled(false);
        }
        else
        {
            GUI.getCreateLineBtn().setEnabled(true);
            GUI.getDeleteBtn().setEnabled(true);
        }
        //if no invoice line row selected
        //disable delete line button
        if(GUI.getInvoiceLinesJTable().getSelectedRow()<0)
        {
            GUI.getDeleteLineBtn().setEnabled(false);
        }
        else
        {
            GUI.getDeleteLineBtn().setEnabled(true);
        }
        //if inovice list is empty 
        //disable save menue item in file meneu
        if(GUI.getInvoicesList().isEmpty())
        {
            GUI.getSaveItem().setEnabled(false);
        }
        else
        {
            GUI.getSaveItem().setEnabled(true);
        }
    }
}
