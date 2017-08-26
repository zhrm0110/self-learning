
class SubThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class TestThread1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubThread1 st1 = new SubThread1();
        st1.setName("ChildThread1");
        st1.start();
        Thread.currentThread().setName("MainThread");
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            // if (i%10 == 0) {
            // Thread.currentThread().yield();
            // }
            if (i == 20) {
                try {
                    st1.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
