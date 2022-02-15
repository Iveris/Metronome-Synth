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
 * Handles audio portion of application
 *
 * @author Warner Iveris
 */
public class Click implements Runnable {

    private final Click click;

    private Click(Builder builder) {
        click = builder.buildClick;
    }

    // Audio Handlers
    private Sequence sequence;
    private int tempo;

    private volatile boolean tempoChanged = false;
    private volatile boolean keepPlaying = false;

    public static class Builder {

        private Click buildClick;
        private Sequence sequence;
        private int tempo;

        public Builder(Sequence sequence, int tempo) {
            this.sequence = sequence;
            this.tempo = tempo;
        }

        public Click build() {
            buildClick = new Click(this);
            buildClick.setTempo(tempo);
            buildClick.sequence = sequence;
            return buildClick;
        }
    }

    @Override
    public void run() {
        /* create sequencer and synthesizer, load sequence, wire sequencer 
         * to syntheizer, open both, set tempo, play */
        try ( Sequencer sequencer = MidiSystem.getSequencer();  Synthesizer synthesizer = MidiSystem.getSynthesizer()) {

            sequencer.setSequence(getSequence());

            synthesizer.open();

            sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());
            sequencer.setLoopCount(Integer.MAX_VALUE); // loops until the value of keepPlaying is set to false

            sequencer.open();
            sequencer.setTempoInBPM(getTempo());
            sequencer.start();
            while (getKeepPlaying()) {
                if (getTempoChanged()) {
                    sequencer.setTempoInBPM(getTempo());
                    setTempoChanged(false);
                }
            }
            sequencer.stop();

        } catch (MidiUnavailableException | InvalidMidiDataException ex ) {
            Logger.getLogger(Click.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private Sequence getSequence() {
        return sequence;
    }
}
