/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MidiEquality;

import MidiEquality.MidiEventEquals;
import javax.sound.midi.Track;

/**
 * Tracks storing the same data return false when compared with Object.equals(),
 * so this class compares tracks based on the data stored in them.
 * 
 * @author Warner Iveris
 */
public class TrackEquals {
    
    public static boolean compare(Track t1, Track t2){
        boolean areEqual = true;
        
        if(t1.size() != t2.size()){
            return false;
        } else{
            /* IMPORTANT: the last item on any track is an immutable end of 
             * track message which cannot be compared with MidiEventEquals,
             * thus the loop stops at i < t1.size() - 1
             */
            for(int i = 0; i < t1.size() - 1; i++){
                if(!MidiEventEquals.compare(t1.get(i), t2.get(i))){
                    return false;
                }
            }
        }
        
        return areEqual;
    }
}
