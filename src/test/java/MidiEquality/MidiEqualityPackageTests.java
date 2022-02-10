/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package MidiEquality;

import com.warneriveris.metronome.model.Rhythms;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Class to test the compare methods of each class in the MidiEquality package.
 * MidiEvent, Tracks, and Sequence classes do not return true for equality
 * despite storing the same data. Classes MidiEventEquals, TrackEquals, and
 * SequenceEquals contain compare methods that test for equality by comparing
 * the data stored in two objects and returns true if they store the same data,
 * and false if they do not. This class tests each of those classes for
 * accuracy.
 *
 * @author Warner Iveris
 */
public class MidiEqualityPackageTests {

    private MidiEvent event1;
    private MidiEvent event1Copy;
    private MidiEvent event2;

    private Track track1;
    private Track track1Copy;
    private Track track2;

    private Sequence sequence1;
    private Sequence sequence1Copy;
    private Sequence sequence2;

    private int CHANNEL = 1;
    private int DATA1 = 1;
    private int DATA2 = 1;
    private int TICK = 1;
    
    public MidiEqualityPackageTests() throws InvalidMidiDataException {
        event1 = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, CHANNEL, DATA1, DATA2), TICK);
        event1Copy = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, CHANNEL, DATA1, DATA2), TICK);
        event2 = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, CHANNEL, DATA1, DATA2), TICK);
        
        sequence1 = new Sequence(Sequence.PPQ, Rhythms.QUARTER.quarterNoteDivision());
        track1 = sequence1.createTrack();
        track1.add(event1);
        track1.add(event2);

        sequence1Copy = new Sequence(Sequence.PPQ, Rhythms.QUARTER.quarterNoteDivision());
        track1Copy = sequence1Copy.createTrack();
        track1Copy.add(event1Copy);
        track1Copy.add(event2);

        sequence2 = new Sequence(Sequence.SMPTE_24, Rhythms.QUARTER.quarterNoteDivision());
        track2 = sequence2.createTrack();
        // order of events is important, so track2 should NOT equal track1
        track2.add(event2);
        track2.add(event1);
        
        /* track3 is added to each sequence for multitrack comparisions between
         * two sequences. Sequences sequence1 and sequence1Copy should contain 
         * the same information in the same order. Sequence 2 should contain
         * the same information as the previous two, but the order of the tracks
         * is reversed.
         */
        Track track3 = sequence1.createTrack();
        track3.add(event2);
        track3.add(event1);
        
        track3 = sequence1Copy.createTrack();
        track3.add(event2);
        track3.add(event1Copy);
        
        track3 = sequence2.createTrack();
        track3.add(event1);
        track3.add(event2);
        
    }

    /**
     * Tests the compare method of class MidiEventEquals
     */
    @Test
    public void testMidiEventEquals() throws InvalidMidiDataException {
        System.out.println("Testing MidiEventEquals.compare() method");
        // same data, two different events
        assertTrue(MidiEventEquals.compare(event1, event1Copy));
        // different data, two different events
        assertFalse(MidiEventEquals.compare(event1, event2));
    }

    /**
     * Tests compare method of class TrackEquals
     */
    @Test
    public void testTrackEquals() throws InvalidMidiDataException {
        System.out.println("Testing TrackEquals.compare() method");
        assertTrue(TrackEquals.compare(track1, track1Copy));
        assertFalse(TrackEquals.compare(track1, track2));
    }

    /**
     * Tests compare method of class SequenceEquals
     */
    @Test
    public void testSequenceEquals() throws InvalidMidiDataException {
        System.out.println("Testing SequenceEquals.compare() method");
        assertTrue(SequenceEquals.compare(sequence1, sequence1Copy));
        assertFalse(SequenceEquals.compare(sequence1, sequence2));
    }

}
