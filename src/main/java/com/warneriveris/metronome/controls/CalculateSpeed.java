/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.warneriveris.metronome.controls;

import java.util.Arrays;

/**
 * Calculates the increment or decrement of the metronome speed based
 * current Beats Per Minute (BMP)
 * @author Warner Iveris
 */
public class CalculateSpeed {
    
    private static CalculateSpeed cs = new CalculateSpeed();
    private CalculateSpeed(){}
    
    private static int[] possibleSpeeds = {
        40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 63, 66, 69, 72, 76, 80, 
        84, 88, 92, 96, 100, 104, 108, 112, 116, 120, 126, 132, 138, 144, 
        152, 160, 168, 176, 184, 192, 200, 208
    };
    
    public static int increment(int currentBMP){
        // if current tempo is the max possible, return max index 
        if(currentBMP == possibleSpeeds[possibleSpeeds.length - 1]) {
            return currentBMP;
        }
        return possibleSpeeds[(findSpeedIndex(currentBMP) + 1)];
        
    }
    
    public static int decrement(int currentBMP){
        if(currentBMP == possibleSpeeds[0]) {
            return currentBMP;
        }
        return possibleSpeeds[(findSpeedIndex(currentBMP) - 1)];
    }
    
    private static int findSpeedIndex(int currentBMP){
        return Arrays.binarySearch(possibleSpeeds, currentBMP);
    }
}