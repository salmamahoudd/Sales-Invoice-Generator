/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.Listener;
import View._01_SIG_Main_JFrame;

/**
 *
 * @author Kimo Store
 */
public class Foucs_Restarter extends Thread
{
    _01_SIG_Main_JFrame GUI;
    public Foucs_Restarter(_01_SIG_Main_JFrame GUI) 
    {
        this.GUI=GUI;
    }
    @Override
    public void run() 
    {
        // this filed by default has two FocusListeners so I remove all others except the first tow
        while(GUI.getDateTF().getFocusListeners().length>2)
        {
            //remove foucus listener
            GUI.getDateTF().removeFocusListener(Listener.dateLabelChangeHandler);
        }
        // this filed by default has two FocusListeners so I remove all others except the first tow
        while(GUI.getCustomerNameTF().getFocusListeners().length>2)
        {
            //remove foucus listener
            GUI.getCustomerNameTF().removeFocusListener(Listener.cSNameTexFieldChangeHandler);
        }
        //addd focus listsner again
        GUI.getDateTF().addFocusListener(Listener.dateLabelChangeHandler);
        GUI.getCustomerNameTF().addFocusListener(Listener.cSNameTexFieldChangeHandler);
        //and request focus by other element
        GUI.requestFocus();
    }
    
}
