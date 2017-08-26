package headfirst.charpter11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();// This object used for combine the Midi information into
                                                            // music
            System.out.println("We got a sequencer");
        } catch (MidiUnavailableException e) {
            // TODO Auto-generated catch block
            System.out.println("Bummer");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }

    public void testThrowFather() throws IOException {
        testThrowChild1();
        testThrowChild2();
    }

    private void testThrowChild1() throws InterruptedIOException {

    }

    private void testThrowChild2() throws FileNotFoundException {

    }

    public void testMultiCatch() {
        try {
            testThrowChild1();
            testThrowChild2();
        } catch (InterruptedIOException e) {
            // TODO: handle exception
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
    }

}
