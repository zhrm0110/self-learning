class Window3 implements Runnable {
    int ticket = 100;// 共享数据
    // Object obj = new Object();

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            // synchronized (obj) {
            synchronized (this) {// 此时的this是main中的w
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

}

public class TestWindow3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }

}
