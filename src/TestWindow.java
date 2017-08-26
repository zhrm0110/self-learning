//模拟火车站窗口开启3个窗口售票，总票数100张。
class Window extends Thread {
    private static int ticket = 100;// 只有static的才会被三个线程公用。否则就是300张票了。

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
            } else {
                break;
            }
        }
    }
}

public class TestWindow {

    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }

}
