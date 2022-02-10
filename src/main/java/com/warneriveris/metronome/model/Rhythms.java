/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.warneriveris.metronome.model;

/**
 * Represents various rhythms and their placement within a quarter-note pulse
 *
 * @author Warner Iveris
 */
public enum Rhythms {

    QUARTER(1, 80, 95),
    EIGHTH(420, 70, 85),
    LAST(840, 0, 0);

    private int placement; // called "tick" in sequence and MidiEvents that make up a sequence
    private int pitch;
    private int velocity; // how loud or soft a pitch is
    
    /* 840 divisions of a quarter-note chosen because it is divisible 
     * by 4, 5, 6, and 7 (and by divisions 2 and 3) allowing any common
     * divisions of a quarter-note */
    private int QUARTER_DIVISION = 840;

    Rhythms(int placement, int pitch, int velocity) {
        this.placement = placement;
        this.pitch = pitch;
        this.velocity = velocity;
    }

    /**
     * @return the placement
     */
    public int getPlacement() {
        return placement;
    }

    /**
     * @return the pitch
     */
    public int getPitch() {
        return pitch;
    }
    
    /**
     * @return the velocity
     */
    public int getVelocity() {
        return velocity;
    }
    
    public int quarterNoteDivision(){
        return QUARTER_DIVISION;
    }

}
