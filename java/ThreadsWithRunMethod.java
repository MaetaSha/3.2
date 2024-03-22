class MyThread extends Thread {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    public void run() {
        System.out.println("Thread " + threadName + " is running.");
    }
}

public class ThreadsWithRunMethod {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");
        MyThread thread3 = new MyThread("Thread 3");

        // Calling run() method directly
        thread1.run();
        thread2.run();
        thread3.run();
    }
}
