/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.model;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author warner
 */
public class ClickTest {

    Click instance; 
    int testTempo = 88;
    Sequence sequence;
    
    public ClickTest() throws InvalidMidiDataException {
        sequence = new Sequence(Rhythms.QUARTER.divisionType(), Rhythms.QUARTER.quarterNoteDivision());
        instance = new Click.Builder(sequence, testTempo).build();
    }

    
    
    
    
    
    /**
     * Test of the setKeepPlaying method, of class Click. VERY IMPORTANT! Tests
     * that an outside thread can stop the while loop inside the run method.
     */
    @Test
    public void testKeepPlaying() {
        System.out.println("Test setKeepPlaying Method");

        assertFalse(instance.getKeepPlaying());

        instance.setKeepPlaying(true);

        Thread runThread = new Thread(instance);
        runThread.start();
        assertTrue(instance.getKeepPlaying());

        instance.setKeepPlaying(false);
        assertFalse(instance.getKeepPlaying());
    }

    /**
     * Test of the setTempoChanged method, of class Click. Tests that an outside
     * thread can change the value of the tempo while the while loop is running.
     *
     */
    @Test
    public void testTempoChanged() {
        System.out.println("Test setTempoChanged Method");

        assertFalse(instance.getTempoChanged());

        instance.setKeepPlaying(true);
        instance.setTempo(60);

        assertTrue(instance.getTempo() == 60);

        Thread runThread = new Thread(instance);
        runThread.start();
        instance.setTempo(80);
        instance.setTempoChanged(true);

        assertEquals(80, instance.getTempo());

        // should be false because reset to false once tempo is changed inside thread
        assertFalse(instance.getTempoChanged());

        instance.setKeepPlaying(false);
    }
    
    
    /**
     * Test of the getTempo and setTempo methods, of class Click.
     *
     */
    @ParameterizedTest
    @ValueSource(ints = {88, 60})
    void testGetAndSetTempo(int tempo, boolean output){
        System.out.println("Testing getTempo and setTempo methods");
        instance.setTempo(tempo);
        assertEquals(instance.getTempo(), tempo);
    }
}
