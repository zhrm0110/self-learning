class PrintNum1 implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

public class TestThread3 {

    public static void main(String[] args) {
        PrintNum1 printNum1 = new PrintNum1();
        Thread t1 = new Thread(printNum1);
        t1.start();
        Thread t2 = new Thread(printNum1);
        t2.start();
    }

}
