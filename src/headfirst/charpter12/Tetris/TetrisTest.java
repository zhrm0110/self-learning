package headfirst.charpter12.Tetris;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TetrisTest {
    JFrame frame;
    ShipPanel panel;
    JButton rotateButton;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TetrisTest tetrisTest = new TetrisTest();
        tetrisTest.go();

    }

    private void go() {
        // TODO Auto-generated method stub
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rotateButton = new JButton("Rotate it!");
        rotateButton.addActionListener(new RotateListener());
        frame.getContentPane().add(BorderLayout.SOUTH, rotateButton);
        frame.setSize(600, 600);
        frame.setVisible(true);
        // panel = new Ship1(chunckSizeLength, midXLoc);
        this.continues();
    }

    public void continues() {
        int chunckSizeLength = 10;
        int midXLoc = 300;
        panel = new ShipFactory(chunckSizeLength, midXLoc).getPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
        drop(panel);

    }

    public void drop(ShipPanel panel) {
        do {
            panel.repaint();
            panel.dmove();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (panel.getY1() < 600);
        this.continues();
    }

    public class RotateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            panel.rotation();
            frame.repaint();
        }
    }
}
