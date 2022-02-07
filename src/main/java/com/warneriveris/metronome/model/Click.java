/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.model;

/**
 * Plays audible click at designated BPM
 * 
 * @author Warner Iveris
 */
public class Click implements Runnable{

    public static final Click click = new Click();
    private Click(){}
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

/*
handles ONLY audio


volatile isRunning boolean
create synth object
pick a sound

playPause() -> toggles isRunning

close resource method
open resource method




*/
