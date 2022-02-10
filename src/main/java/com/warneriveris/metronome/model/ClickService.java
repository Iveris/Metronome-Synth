/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.model;

import com.warneriveris.metronome.controls.ControlInterface;

/**
 * Service handles running the audio object thread and handles communication 
 * from the controller
 * 
 * @author Warner Iveris
 */
public class ClickService {

    public static final ClickService clickService = new ClickService();
    private ClickService(){
        throw new UnsupportedOperationException("Cannot reinstantiate class");
    }
    
    private static volatile boolean isRunning = false;
    
    public static void setTempo(int BPM){
        
    }
    
    public static boolean getIsRunning(){
        return isRunning;
    }
    
    public static void stopPlay(){
        // if(isRunning) stop else play
    }
    
    
    
}
