/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.controls;

import com.warneriveris.metronome.gui.MainFrame;

/**
 * Service class between GUI and metronome internal classes
 * 
 * @author Warner Iveris
 */
public final class Controller implements ControlInterface{

    private static final Controller controller = new Controller();
    
    private Controller(){
    }
    
    public static Controller instance(){
        return controller;
    }
    /**
     * Calculates new speed, then updates metronome and updates GUI display label
     */
    @Override
    public void increment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Calculates new speed, then updates metronome and updates GUI display label
     */
    @Override
    public void decrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Toggles audio on and off
     */
    @Override
    public void stopPlay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setDisplay(int tempo){
        MainFrame.instance().setDisplay(tempo);
    }
}
