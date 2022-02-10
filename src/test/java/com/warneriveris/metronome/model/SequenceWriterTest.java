/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.model;

import MidiEquality.MidiEventEquals;
import MidiEquality.SequenceEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the reliability of the SequenceWriter class to deliver error free
 * sequences to the application
 *
 * @author Warner Iveris
 */
public class SequenceWriterTest {

    private int CHANNEL = 1;

    public SequenceWriterTest() {
    }

    
    
    /**
     * Test of getSequence method, of class SequenceWriter.Simple test adding a
     * quarter-note to a sequence and testing that against a sequence built a
     * hard-coded sequence
     *
     * @throws javax.sound.midi.InvalidMidiDataException
     */
    @Test
    public void testGetQuarterNoteSequence() {
        System.out.println("Testing getSequence() method");

        // builidng expected sequence result
        Sequence expected = quarterNoteTestSequence();

        SequenceWriter sWrite = new SequenceWriter.Builder().quarterNotes().build();
        Sequence actual = sWrite.getSequence();

        assertTrue(SequenceEquals.compare(expected, actual));
    }
    
    private Sequence quarterNoteTestSequence() {
        Sequence expected = null;
        try {
            expected = new Sequence(Rhythms.QUARTER.divisionType(),
                    Rhythms.QUARTER.quarterNoteDivision());
            Track track = expected.createTrack();
            track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, CHANNEL,
                    Rhythms.QUARTER.getPitch(), Rhythms.QUARTER.getVelocity()), Rhythms.QUARTER.getPlacement()));
            track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, CHANNEL,
                    Rhythms.QUARTER.getPitch(), Rhythms.QUARTER.getVelocity()), Rhythms.QUARTER.getPlacement() + 1));
            track.add(new MidiEvent(new ShortMessage(
                    ShortMessage.NOTE_OFF, CHANNEL, Rhythms.LAST.getPitch(),
                    Rhythms.LAST.getVelocity()), Rhythms.LAST.getPlacement()));
            
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(SequenceWriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return expected;
    }
}
