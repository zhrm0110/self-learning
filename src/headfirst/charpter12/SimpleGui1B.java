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
import javax.swing.JPanel;

public class SimpleGui1B extends JPanel implements ActionListener {
    // 当前类已经实现了对Action事件的监听接口
    JButton button;
    JFrame frame;
    JPanel panel;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleGui1B gui1b = new SimpleGui1B();
        gui1b.go();

        MyDrawPanel myDrawPanel = new MyDrawPanel();
        myDrawPanel.repaint();
    }

    private void go() {
        // TODO Auto-generated method stub
        frame = new JFrame();// 实例化一个窗口对象；
        button = new JButton("click this button");// 实例化button对象
        button.addActionListener(this);// 向button注册Action事件监听接口的实现类
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 配置当window关闭时把程序关掉
        frame.getContentPane().add(BorderLayout.EAST, button);// 把button添加到frame的pane上面
        /**
         * There are five zones on one frame that you can place your widgets. Each zone only can place one widget.
         */
        panel = new SimpleGui1B();
        /**
         * This panel extands JPanel and override the paintComponent. When call the repaint for the frame inside the
         * handler of event listener, system wil call paintComponent(has been override) for panel. Then you will see the
         * panel color change with each time you press button.
         */
        frame.getContentPane().add(panel);
        frame.setSize(300, 300);// 设定frame大小
        frame.setVisible(true);// 把frame显示出来
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 当Action事件发生时会调用此方法。
        button.setText("I have been clicked!");
        frame.repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        // graphics.setColor(Color.ORANGE);
        // graphics.fillRect(20, 50, 100, 100);
        //
        // Image image = new ImageIcon("C:\\Users\\i324167\\Pictures\\image2017-3-21 14-0-44.png").getImage();
        // graphics.drawImage(image, 3, 4, this);
        //
        // graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        // graphics.setColor(randomColor);
        // graphics.fillOval(70, 70, 100, 100);
        /**
         * Here the arguments is Polymorphic. Each a Graphics reference variable is referenced to a Graphics2D instance.
         * Graphics2D provides more methods than Graphics. However you cannot call the specific method provides by
         * Graphics2D directly. But you can cast the graphics to Graphics2D, and then call these methods.
         */
        Graphics2D graphics2d = (Graphics2D) graphics;
        // graphics2d.fill3DRect(5, 7, 9, 300, true);

        int redend = (int) (Math.random() * 255);
        int greenend = (int) (Math.random() * 255);
        int blueend = (int) (Math.random() * 255);
        Color randomColorend = new Color(redend, greenend, blueend);

        GradientPaint gradientPaint = new GradientPaint(70, 70, randomColor, 150, 150, randomColorend);
        graphics2d.setPaint(gradientPaint);
        graphics2d.fillOval(70, 70, 100, 100);

    }

}
