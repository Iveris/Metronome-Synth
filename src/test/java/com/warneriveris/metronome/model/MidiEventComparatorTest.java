package com.warneriveris.metronome.model;

import MidiEquality.MidiEventEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Ensures that the MidiEventComparator can be used to organize a list of 
 * MidiEvents in regards to the time each event takes place (i.e. it's "tick").
 * 
 * @author warner
 */
public class MidiEventComparatorTest {

    ShortMessage shortMessage; // all events will contain this same message
    MidiEvent event1; // tick = 1
    MidiEvent event1Copy;
    MidiEvent event2; // tick = 2
    MidiEvent event3; // tick = 3

    // compares all data stored in each event
    MidiEventEquals eventEquals = new MidiEventEquals();

    // compares tick markings
    MidiEventComparator eventCompare = new MidiEventComparator();

    public MidiEventComparatorTest() throws InvalidMidiDataException {
        System.out.println("Initializing");
        shortMessage = new ShortMessage(ShortMessage.NOTE_ON, 1, 50, 50);
        event1 = new MidiEvent(shortMessage, 1);
        event1Copy = new MidiEvent(shortMessage, 1);
        event2 = new MidiEvent(shortMessage, 2);
        event3 = new MidiEvent(shortMessage, 3);
    }

    /**
     * Test of compare method, of class MidiEventComparator. Test two MidiEvents
     * containing the same data for equality
     */
    @Test
    public void testCompareEqualMidiEvents() {
        assertEquals(0, eventCompare.compare(event1, event1Copy));
    }

    /**
     * Test of compare method, of class MidiEventComparator. Test two MidiEvents
     * containing the different data for equality
     */
    @Test
    public void testCompareUnequalMidiEvents() {
        // Event1 has the lower tick number, so eventCompare should return 1
        assertEquals(-1, eventCompare.compare(event1, event2));
        // Event 2 has the higher tick number, so eventCompare should return -1
        assertEquals(1, eventCompare.compare(event2, event1));
    }

    /**
     * Test of compare method, of class MidiEventComparator.
     *
     * Create two lists with the same MidiEvents added in different orders, then
     * test each for the same content by iterating through both at the same time
     * to compare the order of the MidiEvents before and after running them
     * through the MidiEvent Comparator
     */
    @Test
    public void testCompareList() {
        System.out.println("Testing compare method of class MidiEventComparator");

        List<MidiEvent> list1 = new ArrayList<>();
        List<MidiEvent> list2 = new ArrayList<>();

        // events in order
        list1.addAll(Arrays.asList(event1, event2, event3));

        // events out of order
        list2.addAll(Arrays.asList(event3, event1Copy, event2));

//        assertFalse(compareEventLists(list1, list2));
        list2.sort(eventCompare);

        // sort with comparator
        assertTrue(compareEventLists(list1, list2));
    }

    // helper method to compare lists of MidiEvents
    private boolean compareEventLists(List<MidiEvent> list1, List<MidiEvent> list2) {
        boolean listsEqual = true;

        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            MidiEvent m1 = list1.get(i);
            MidiEvent m2 = list2.get(i);
            System.out.println("Index: " + i);
            System.out.println("List1 Event: " + m1.getTick() + "\t\tList2 Event: " + m2.getTick());
            if (!eventEquals.compare(list1.get(i), list2.get(i))) {
                listsEqual = false;
                break;
            }
        }
        return listsEqual;
    }

}
