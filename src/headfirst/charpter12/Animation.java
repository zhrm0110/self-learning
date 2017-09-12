package headfirst.charpter12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation {
    JFrame frame;
    JPanel panel;
    int xloc;
    int yloc;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Animation gui = new Animation();
        gui.go();
    }

    private void go() {
        // TODO Auto-generated method stub
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyPanel();
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
        animation();
    }

    public void animation() {
        xloc = 50;
        yloc = 50;
        do {
            panel.repaint();
            xloc++;
            yloc++;
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (xloc < 450);
    }

    public class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            /**
             * Ther first two line used for clear last paint mark.
             */
            graphics.setColor(Color.white);
            graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

            Graphics2D graphics2d = (Graphics2D) graphics;
            GradientPaint gradientPaint = new GradientPaint(70, 70, generateRandomColor(), 150, 150,
                    generateRandomColor());
            graphics2d.setPaint(gradientPaint);
            graphics2d.fillOval(xloc, yloc, 40, 40);
        }

        public Color generateRandomColor() {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            return new Color(red, green, blue);
        }
    }

}
