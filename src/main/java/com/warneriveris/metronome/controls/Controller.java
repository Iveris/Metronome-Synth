/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.controls;

import com.warneriveris.metronome.gui.MainFrame;
import com.warneriveris.metronome.model.ClickService;

/**
 * Service class between GUI and metronome internal classes
 * 
 * @author Warner Iveris
 */
public final class Controller implements ControlInterface{

    private static final Controller controller = new Controller();
    private int tempo;
    
    private Controller(){
        tempo = 60;
    }
    
    public static Controller instance(){
        return controller;
    }
    
    /**
     * Calculates new speed, then updates metronome and updates GUI display label
     */
    @Override
    public void increment() {
        tempo = TempoUtilities.increment(tempo);
        setDisplay(tempo);
        ClickService.setTempo(tempo);
    }

    /**
     * Calculates new speed, then updates metronome and updates GUI display label
     */
    @Override
    public void decrement() {
        tempo = TempoUtilities.decrement(tempo);
        setDisplay(tempo);
        ClickService.setTempo(tempo);
    }

    /**
     * Toggles audio on and off
     */
    @Override
    public void stopPlay() {
        ClickService.stopPlay();
    }
    
    
    /**
     * Sets the tempo display in the GUI
     * 
     * @param tempo integer representing the current tempo
     */
    public void setDisplay(int tempo){
        MainFrame.instance().setDisplay(tempo);
    }
}
