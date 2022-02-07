/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.controls;

import java.lang.reflect.Array;
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
public class TempoUtilitiesTest {
    
    private int MAX_BMP;
    private int MIN_BMP;
    
    
    public TempoUtilitiesTest() throws ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        setup();
    }
    
    @BeforeAll
    public void setup() throws ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        var field = TempoUtilities.class.getDeclaredField("possibleSpeeds");
        field.setAccessible(true);
        int[] speeds = (int[]) field.get(TempoUtilities.class);
        
        MIN_BMP = speeds[0];
        MAX_BMP = speeds[speeds.length - 1];
        
    }

    /**
     * Test of increment method, of class CalculateSpeed.
     */
    @org.junit.jupiter.api.Test
    public void testIncrement() {
        System.out.println("increment");
        int currentBMP = 60;
        int expResult = 63;
        int result = TempoUtilities.increment(currentBMP);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrement method, of class CalculateSpeed.
     */
    @org.junit.jupiter.api.Test
    public void testDecrement() {
        System.out.println("decrement");
        int currentBMP = 60;
        int expResult = 58;
        int result = TempoUtilities.decrement(currentBMP);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of increment method, of class CalculateSpeed.
     * Tests incrementing max possible tempo
     */
    @org.junit.jupiter.api.Test
    public void testIncrementMax() {
        System.out.println("increment maximum: " + MAX_BMP);
        int currentBMP = MAX_BMP;
        int expResult = MAX_BMP;
        int result = TempoUtilities.increment(currentBMP);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of decrement method, of class CalculateSpeed.
     */
    @org.junit.jupiter.api.Test
    public void testDecrementMin() {
        System.out.println("decrement minimum: " + MIN_BMP);
        int currentBMP = MIN_BMP;
        int expResult = MIN_BMP;
        int result = TempoUtilities.decrement(currentBMP);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class CalculateSpeed.
     */
    @org.junit.jupiter.api.Test
    public void testValidate() {
        System.out.println("validate");
        int validTempo = 60; // 60 will always be a valid tempo on any metronome
        int invalidTempo = -4; // it is impossible to have a negative number of beats per minute
        assertTrue(TempoUtilities.validate(validTempo));
        assertFalse(TempoUtilities.validate(invalidTempo));
    }
}
