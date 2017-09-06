class Window2 implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.currentThread().sleep(10);// 加剧了线程安全问题，出现重票和错票（-1）
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
            } else {
                break;
            }
        }
    }

}

public class TestWindow2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Window2 w = new Window2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }

}
