//模拟火车站窗口开启3个窗口售票，总票数100张。
class Window4 extends Thread {
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

public class TestWindow4 {

    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }

}
