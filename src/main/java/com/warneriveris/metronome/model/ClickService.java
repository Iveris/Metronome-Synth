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
public class ClickService implements ControlInterface {

    public static final ClickService clickService = new ClickService();
    private ClickService(){
        throw new UnsupportedOperationException("Cannot reinstantiate class");
    }
    
    @Override
    public void increment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void decrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void stopPlay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
