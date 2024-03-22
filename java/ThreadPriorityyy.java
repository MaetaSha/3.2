public class ThreadPriorityyy {
    public static void main(String args[]) {

        A threadA = new A();
        B threadB = new B();
        C threadC = new C();

        // Setting thread priorities
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(threadA.getPriority() + 1);
        threadA.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Start thread A");
        threadA.start();

        System.out.println("Start thread B");
        threadB.start();

        System.out.println("Start thread C");
        threadC.start();

        // Wait for threads to finish execution
        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main thread");
    }

    static class A extends Thread {
        public void run() {
            synchronized (System.out) {
                System.out.println("Thread A started");
                for (int i = 1; i <= 4; i++) {
                    System.out.println("\tFrom Thread A : i =" + i);
                }
                System.out.println("Exit from A ");
            }
        }
    }

    static class B extends Thread {
        public void run() {
            synchronized (System.out) {
                System.out.println("Thread B started");
                for (int j = 1; j <= 4; j++) {
                    System.out.println("\tFrom Thread B : j =" + j);
                }
                System.out.println("Exit from B ");
            }
        }
    }

    static class C extends Thread {
        public void run() {
            synchronized (System.out) {
                System.out.println("Thread C started");
                for (int k = 1; k <= 4; k++) {
                    System.out.println("\tFrom Thread C : k=" + k);
                }
                System.out.println("Exit from C");
            }
        }
    }
}
