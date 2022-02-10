/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.model;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author warner
 */
public class ClickTest {

    int testTempo = 88;
    Sequence sequence;
    
    public ClickTest() throws InvalidMidiDataException {
        sequence = new Sequence(Rhythms.QUARTER.divisionType(), Rhythms.QUARTER.quarterNoteDivision());
    }
    
    /**
     * Test Click run method to determine if it actually plays any sound!
     */
    @Test
    public void testClick(){
        Sequence s = new SequenceWriter.Builder().quarterNotes().eigthNotes().build().getSequence();
        Click sound = new Click.Builder(s, testTempo).build();
        sound.setKeepPlaying(true);
        Thread runClick = new Thread(sound);
        runClick.start();
        
        try{
            Thread.sleep(4000);
        } catch(Exception e){
            
        }
        
        
        sound.setKeepPlaying(false);
        
    }
    
    /**
     * Test of the setKeepPlaying method, of class Click. VERY IMPORTANT! Tests
     * that an outside thread can stop the while loop inside the run method.
     */
    @Test
    public void testKeepPlaying() {
        System.out.println("Test setKeepPlaying Method");
        Click instance = new Click.Builder(sequence, testTempo).build();
        assertFalse(instance.getKeepPlaying());

        instance.setKeepPlaying(true);

        Thread runThread = new Thread(instance);
        runThread.start();
        assertTrue(instance.getKeepPlaying());

        instance.setKeepPlaying(false);
        assertFalse(instance.getKeepPlaying());
        
        if(runThread.isAlive()){
            runThread.interrupt();
        }
        runThread = null;
        instance = null;
    }

    /**
     * Test of the setTempoChanged method, of class Click. Tests that an outside
     * thread can change the value of the tempo while the while loop is running.
     *
     */
    @Test
    public void testTempoChanged() {
        System.out.println("Test setTempoChanged Method");
        Click instance = new Click.Builder(sequence, testTempo).build();
        instance.setTempoChanged(false);
        
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
//        assertFalse(instance.getTempoChanged());

        instance.setKeepPlaying(false);
        
        if(runThread.isAlive()){
            runThread.interrupt();
        }
        runThread = null;
        instance = null;
    }
    
    
    /**
     * Test of the getTempo and setTempo methods, of class Click.
     *
     */
    @Test
    public void testGetAndSetTempo(){
        System.out.println("Testing getTempo and setTempo methods");
        int tempo = 60;
        Click instance = new Click.Builder(sequence, tempo).build();
        instance.setTempo(tempo);
        assertTrue(instance.getTempo() == tempo);
        
        tempo = 92;
        assertFalse(instance.getTempo() == tempo);
        
        instance.setTempo(tempo);
        assertEquals(instance.getTempo(), tempo);
    }
    
    
}
