package headfirst.charpter12;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();// 实例化一个窗口对象；
        JButton button = new JButton("click this button");// 实例化button对象
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 配置当window关闭时把程序关掉
        frame.getContentPane().add(button);// 把button添加到frame的pane上面；
        frame.setSize(300, 300);// 设定frame大小
        frame.setVisible(true);// 把frame显示出来
    }

}
