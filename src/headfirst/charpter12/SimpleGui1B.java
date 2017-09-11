package headfirst.charpter12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1B implements ActionListener {
    // 当前类已经实现了对Action事件的监听接口
    JButton button;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleGui1B gui1b = new SimpleGui1B();
        gui1b.go();
    }

    private void go() {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();// 实例化一个窗口对象；
        button = new JButton("click this button");// 实例化button对象
        button.addActionListener(this);// 向button注册Action事件监听接口的实现类
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 配置当window关闭时把程序关掉
        frame.getContentPane().add(button);// 把button添加到frame的pane上面；
        frame.setSize(300, 300);// 设定frame大小
        frame.setVisible(true);// 把frame显示出来
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 当Action事件发生时会调用此方法。
        button.setText("I have been clicked!");
    }

}
