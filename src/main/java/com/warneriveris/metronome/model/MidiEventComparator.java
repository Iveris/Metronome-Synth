/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.model;

import java.util.Comparator;
import javax.sound.midi.MidiEvent;

/**
 *
 * @author warner
 */
public class MidiEventComparator implements Comparator<MidiEvent> {
    @Override
    public int compare(MidiEvent event1, MidiEvent event2) {
        if (event1.getTick() > event2.getTick()) {
            return 1;
        } else if (event1.getTick() == event2.getTick()) {
            return 0;
        } else {
            return -1;
        }
    }
    
    
}
