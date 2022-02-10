/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MidiEquality;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

/**
 * Sequences storing the same data will return false when compared Object.equals(),
 * so this class determines equality by comparing each item of data stored in 
 * both sequences. Because this program will only every use one track in a 
 * sequence, only the first track of each sequence is compared.
 * 
 * @author Warner Iveris
 */
public class SequenceEquals {
    
    public static boolean compare(Sequence s1, Sequence s2) {
        boolean areEqual = true;
        
        Track[] tracks1 = s1.getTracks();
        Track[] tracks2 = s2.getTracks();
        
        if(tracks1.length != tracks2.length){
            return false;
        } else {
            for(int i = 0; i < tracks1.length; i++){
                if(!TrackEquals.compare(tracks1[i], tracks2[i])){
                    return false;
                }
            }
        }
        
        return areEqual;
    }
}
