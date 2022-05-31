/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import View._01_SIG_Main_JFrame;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Kimo Store
 */
public class Main 
{
    static public ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) 
    {
        //Creat new Object from Main Jframe
        _01_SIG_Main_JFrame GUI =new _01_SIG_Main_JFrame();
        //Make it visible
        GUI.setVisible(true);
        //Creat new Object from button check class to determine each buton state according to spcsfic conditions
        Button_Check button_Check=new Button_Check(GUI);
        //Creat new Object from button check class to handle foucs listsenr state
        Foucs_Restarter foucs_Restarter=new Foucs_Restarter(GUI);
        //Creat new object from ScheduledExecutorService to schedule button check class
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        //Make button check to check and decide on each button state every 100 ms (10 times per second)
        executor.scheduleAtFixedRate(button_Check, 0, 100, TimeUnit.MILLISECONDS);
    }
}
