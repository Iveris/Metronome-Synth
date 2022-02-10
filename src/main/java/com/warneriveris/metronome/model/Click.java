/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

/**
 * Plays audible click at designated BPM
 * 
 * @author Warner Iveris
 */
public class Click implements Runnable{

    private static final Click click = new Click();
    private Click(){}
    
    public static Click instance(){
        return click;
    }
    
    private Sequence sequence;
    private int tempo;
    private volatile boolean tempoChanged = false;
    private volatile boolean keepPlaying = false;
    
    @Override
    public void run() {
        /* create sequencer and synthesizer, load sequence, wire sequencer 
         * to syntheizer, open both, set tempo, play */
        
        while(getKeepPlaying()){
            if(getTempoChanged()){
                // set new tempo
                setTempoChanged(false);
            }
        }
    }
    
    /**
     * TODO: change to a builder pattern
     */
    private void init(){
    }

    /**
     * @return the tempo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    /**
     * @return the tempoChanged
     */
    public boolean getTempoChanged() {
        return tempoChanged;
    }

    /**
     * @param tempoChanged the tempoChanged to set
     */
    public void setTempoChanged(boolean tempoChanged) {
        this.tempoChanged = tempoChanged;
    }

    /**
     * @return the keepPlaying
     */
    public boolean getKeepPlaying() {
        return keepPlaying;
    }

    /**
     * @param keepPlaying the keepPlaying to set
     */
    public void setKeepPlaying(boolean keepPlaying) {
        this.keepPlaying = keepPlaying;
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
