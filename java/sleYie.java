class Thread1 extends Thread {
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " running ");
            Thread.yield();
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(name + " running ");
                Thread.sleep(3000); // Sleeping for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread3 extends Thread {
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " running ");
        }
    }
}

public class sleYie {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.setName("thread1");
        t2.setName("thread2");
        t3.setName("thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}