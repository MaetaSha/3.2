class A extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("\t From Thread A : i= " + i);
            if (i == 1)
                Thread.yield(); // Yield the CPU to other threads
        }
        System.out.println("Exit from A");
    }
}

class C extends Thread {
    public void run() {
        for (int k = 1; k <= 5; k++) {
            System.out.println("\t From Thread C : k= " + k);
            if (k == 1) {
                try {
                    Thread.sleep(1000); // Pause for 1 second
                } catch (InterruptedException e) {
                    System.out.println("Thread C interrupted.");
                }
            }
        }
        System.out.println("Exit from C");
    }
}

public class ThreadMethodd {
    public static void main(String[] args) {
        A threadA = new A();

        C threadC = new C();

        System.out.println("Start thread A");
        threadA.start();

        System.out.println("Start thread C");
        threadC.start();

        // Main thread continues its execution
        System.out.println("End of the main thread");
    }
}
