package headfirst.charpter12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultiListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton fbutton, rbutton;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MultiListener gui = new MultiListener();
        gui.go();
    }

    private void go() {
        // TODO Auto-generated method stub
        frame = new JFrame();
        rbutton = new JButton("Label Button");
        rbutton.addActionListener(new LabelListener());
        /**
         * Strange thing is that, although no explicitly frame.repaint() call for the label button action event, the
         * color change will also occur with the label button action event. Why?
         */

        fbutton = new JButton("Collor Button");
        fbutton.addActionListener(new ColorListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.EAST, rbutton);
        frame.getContentPane().add(BorderLayout.SOUTH, fbutton);
        label = new JLabel("Before label button clicked");
        frame.getContentPane().add(BorderLayout.WEST, label);
        panel = new MyPanel();
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(900, 600);
        frame.setVisible(true);

    }

    public class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (label.getText().equalsIgnoreCase("Before label button clicked")) {
                label.setText("I'm a label and have been changed with clicke event with the rbutton.");
            } else {
                label.setText("Before label button clicked");
            }
        }

    }

    public class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            frame.repaint();
        }
    }

    public class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            int redbegin = (int) (Math.random() * 255);
            int greenbegin = (int) (Math.random() * 255);
            int bluebegin = (int) (Math.random() * 255);
            Color randomBeginColor = new Color(redbegin, greenbegin, bluebegin);
            int redend = (int) (Math.random() * 255);
            int greenend = (int) (Math.random() * 255);
            int blueend = (int) (Math.random() * 255);
            Color randomEndColor = new Color(redend, greenend, blueend);
            Graphics2D graphics2d = (Graphics2D) graphics;
            GradientPaint gradientPaint = new GradientPaint(70, 70, randomBeginColor, 150, 150, randomEndColor);
            graphics2d.setPaint(gradientPaint);
            graphics2d.fillOval(70, 70, 100, 100);
        }
    }

}
