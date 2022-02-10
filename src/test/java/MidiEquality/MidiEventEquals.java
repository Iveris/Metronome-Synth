/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MidiEquality;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * MidiEvent containing the same content will return false for equality. This
 * class ensure equality for MidiEvents containing the same content by comparing
 * the actual data stored in each event.
 *
 * @author Warner Iveris
 */
public class MidiEventEquals {

    public static boolean compare(MidiEvent m1, MidiEvent m2) {
        boolean areEqual = true;
        ShortMessage msg1 = (ShortMessage) m1.getMessage();
        ShortMessage msg2 = (ShortMessage) m2.getMessage();

        return m1.getTick() == m2.getTick()
                && msg1.getCommand() == msg2.getCommand()
                && msg1.getData1() == msg2.getData1()
                && msg1.getData2() == msg2.getData2();
    }

}
