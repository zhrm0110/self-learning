package headfirst.charpter12;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(20, 50, 100, 100);

        Image image = new ImageIcon("C:\\Users\\i324167\\Pictures\\image2017-3-21 14-0-44.png").getImage();
        graphics.drawImage(image, 3, 4, this);

        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        graphics.setColor(randomColor);
        graphics.fillOval(70, 70, 100, 100);
        /**
         * Here the arguments is Polymorphic. Each a Graphics reference variable is referenced to a Graphics2D instance.
         * Graphics2D provides more methods than Graphics. However you cannot call the specific method provides by
         * Graphics2D directly. But you can cast the graphics to Graphics2D, and then call these methods.
         */
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.fill3DRect(5, 7, 9, 300, true);

        int redend = (int) (Math.random() * 255);
        int greenend = (int) (Math.random() * 255);
        int blueend = (int) (Math.random() * 255);
        Color randomColorend = new Color(redend, greenend, blueend);

        GradientPaint gradientPaint = new GradientPaint(70, 70, randomColor, 150, 150, randomColorend);
        graphics2d.setPaint(gradientPaint);
        graphics2d.fillOval(70, 70, 100, 100);

    }
}
