package coretech.charpter11;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class LoggingImageViewer {
    /**
     * A modification of the image viewer program that logs various events
     */
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("coretech.charpter11.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                /**
                 * Question here: Second @param limit the maximum number of bytes to write to any one file, Why we set
                 * it to 0?
                 */
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("coretech.charpter11.corejava").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("coretech.charpter11.corejava").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Handler windowHandler = new WindowHandler();
                windowHandler.setLevel(Level.ALL);
                Logger.getLogger("coretech.charpter11.corejava").addHandler(windowHandler);
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("LoggingImageViewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Logger.getLogger("coretech.charpter11.corejava").fine("Showihng frame");
                frame.setVisible(true);
            }
        });
    }

}
