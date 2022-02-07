/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.gui;

import javax.swing.JLabel;
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
public class MainFrameTest {
    
    private MainFrame instance = new MainFrame();
    
    public MainFrameTest() {
    }
   
    /**
     * Test of setDisplay method, of class MainFrame.
     */
    @Test
    public void testSetDisplay() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setDisplay");
        int tempo = 60;
        instance.setDisplay(tempo);
        var fields = MainFrame.class.getDeclaredFields();
        var DisplayField = MainFrame.class.getDeclaredField("DisplayLabel");
        DisplayField.setAccessible(true);
        var display = (JLabel) DisplayField.get(instance);
        assertEquals(tempo, Integer.parseInt(display.getText()));
        
    }
    
     @AfterAll
    public void tearDownClass() {
        instance = null;
    }
    
}
