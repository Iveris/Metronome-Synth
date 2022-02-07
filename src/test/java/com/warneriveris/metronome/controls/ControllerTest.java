/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.warneriveris.metronome.controls;

import com.warneriveris.metronome.gui.MainFrame;
import java.lang.reflect.InvocationTargetException;
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
public class ControllerTest {
    
    private static MainFrame mFrameInstance = MainFrame.instance();
    private static Controller controllerInstance = Controller.instance();
    
    public ControllerTest() {
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

//    /**
//     * Test of increment method, of class Controller.
//     */
//    @Test
//    public void testIncrement() {
//        System.out.println("increment");
//        Controller instance = null;
//        instance.increment();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of decrement method, of class Controller.
//     */
//    @Test
//    public void testDecrement() {
//        System.out.println("decrement");
//        Controller instance = null;
//        instance.decrement();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stopPlay method, of class Controller.
//     */
//    @Test
//    public void testStopPlay() {
//        System.out.println("stopPlay");
//        Controller instance = null;
//        instance.stopPlay();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    /**
     * Test of setDisplay method, of class Controller.
     */
    @Test
    public void testSetDisplay() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        System.out.println("setDisplay");
        int tempo = 60;
        controllerInstance.setDisplay(tempo);
        
        var field = MainFrame.class.getDeclaredField("DisplayLabel");
        field.setAccessible(true);
        JLabel display = (JLabel) field.get(mFrameInstance);
        
        
        
        assertEquals(tempo, Integer.parseInt(display.getText()));
        
        
    }
}
