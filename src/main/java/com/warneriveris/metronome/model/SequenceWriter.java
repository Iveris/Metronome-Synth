/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * Creates a Sequence for the sequencer to use
 *
 * @author Warner Iveris
 */
public class SequenceWriter {

    private final Sequence sequence;
    public static final int CHANNEL = 1;

    private SequenceWriter(Builder builder) {
        sequence = builder.sequence;
    }
    
    public Sequence getSequence() {
        return sequence;
    }

    public static class Builder {

        // List of MidiEvents used to build the sequence
        private List<MidiEvent> events = new ArrayList<>();
        private Sequence sequence;

        public Builder() {
            try {
                sequence = new Sequence(Sequence.PPQ, Rhythms.QUARTER.quarterNoteDivision());
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(SequenceWriter.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1); // TODO catch non-initialized sequence and display message to user
            }
        }
        
        // choose midi instrument and set it before the sequence begins (i.e. at tick 0)
        public Builder instrument(int program){
            try {
                events.add(new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, CHANNEL, program, 0), 0));
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(SequenceWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return this;
        }

        // methods for adding events to Rhythms array
        public Builder quarterNotes() {
            addEvent(Rhythms.QUARTER);
            return this;
        }

        public Builder eigthNotes() {
            // do something
            return this;
        }

        // adds rhythm events to events list and ensures that
        // every event added has an on and off tick in the sequence
        private void addEvent(Rhythms rhythm) {
            events.add(createEvent(ShortMessage.NOTE_ON, rhythm, rhythm.getPlacement()));
            events.add(createEvent(ShortMessage.NOTE_OFF, rhythm, rhythm.getPlacement() + 1));
        }

        // helps addEvent method by creating actual events to be added to events list
        private MidiEvent createEvent(int command, Rhythms rhythm, int tick) {
            MidiEvent event = null;
            try {
                var smg = new ShortMessage();
                smg.setMessage(command, CHANNEL, rhythm.getPitch(), rhythm.getVelocity());
                event = new MidiEvent(smg, tick);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(SequenceWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return event;
        }

        // creates the actual sequence to be returned
        private void createSequence() {
            // ensures that the sequence will last the full duration of the quarter-note pulse
            events.add(createEvent(ShortMessage.NOTE_OFF, Rhythms.LAST, Rhythms.LAST.getPlacement()));

            events.sort(new MidiEventComparator());
                
            Track track = sequence.createTrack();
            events.forEach(event -> {
                track.add(event);
            });
        }
        

        public SequenceWriter build() {
            createSequence();
            return new SequenceWriter(this);
        }

    }
}
