/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author warner
 */
public class ClickTest {
    
    public ClickTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of the setKeepPlaying method, of class Click.
     * Tests that an outside thread can stop the while loop
     * inside the run method.
     */
    @Test
    public void testKeepPlaying() {
        System.out.println("Test setKeepPlaying Method");
        Click instance = Click.instance();
        
        assertFalse(instance.getKeepPlaying());
        
        instance.setKeepPlaying(true);
        
        Thread runThread = new Thread(instance);
        runThread.start();
        assertTrue(instance.getKeepPlaying());
        
        instance.setKeepPlaying(false);
        assertFalse(instance.getKeepPlaying());
    }
    
    /**
     * Test of the setTempoChanged method, of class Click.
     * Tests that an outside thread can change the value of the tempo while the 
     * while loop is running.
     * 
     */
    @Test
    public void testTempoChanged() {
        System.out.println("Test setTempoChanged Method");
        Click instance = Click.instance();
        
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
}
