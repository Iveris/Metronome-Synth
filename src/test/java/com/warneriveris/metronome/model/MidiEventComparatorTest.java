/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author warner
 */
public class MidiEventComparatorTest {
    
    ShortMessage shortMessage;
    MidiEvent event1; // tick = 1
    MidiEvent event1Copy;
    MidiEvent event2; // tick = 2
    MidiEvent event3; // tick = 3
    
    MidiEventComparator mec = new MidiEventComparator();
    
    public MidiEventComparatorTest() throws InvalidMidiDataException {
        System.out.println("Initializing");
        shortMessage = new ShortMessage(ShortMessage.NOTE_ON, 1, 50, 50);
        event1 = new MidiEvent(shortMessage, 1);
        event1Copy = new MidiEvent(shortMessage, 1);
        event2 = new MidiEvent(shortMessage, 2);
        event3 = new MidiEvent(shortMessage, 3);
    }
    
     /**
     * Test of compare method, of class MidiEventComparator.
     * Test two MidiEvents containing the same data for equality
     */
     
    @Test
    public void testCompareEqualMidiEvents(){
        assertEquals(0, mec.compare(event1, event1Copy));
    }
    
    /**
     * Test of compare method, of class MidiEventComparator.
     * Test two MidiEvents containing the different data for equality
     */
     
    @Test
    public void testCompareUnequalMidiEvents(){
        // Event1 has the lower tick number, so mec should return 1
        assertEquals(1, mec.compare(event1, event2));
        // Event 2 has the higher tick number, so mec should return -1
        assertEquals(-1, mec.compare(event2, event1));
    }
    
    

    /**
     * Test of compare method, of class MidiEventComparator.
     * 
     * Create two lists with the same MidiEvents added in different orders, then
     * test each for the same content by iterating through both at the same time
     * to compare the order of the MidiEvents before and after running them through
     * the MidiEvent Comparator
     */
    @Test
    public void testCompareList() {
        System.out.println("Testing compare method of class MidiEventComparator");
        
        List<MidiEvent> list1 = new ArrayList<>();
        List<MidiEvent> list2 = new ArrayList<>();
        
        // events in order
        list1.addAll(Arrays.asList(event1, event1Copy, event2, event3));
        
        // events out of order
        list2.addAll(Arrays.asList(event3, event1, event1Copy, event2));
        
        boolean equal = true;


        assertFalse(equal);
        
        
        // sort with comparator
        equal = true;
        assertTrue(equal);
    }
    
}
