package info.java.multihtreading.evenOdd;

public class EvenOddPrinterUsingTwoThreads implements Runnable {

    static int count = 0;

    public static void main(String[] args) {
        EvenOddPrinterUsingTwoThreads evenOddPrinterUsingTwoThreads = new EvenOddPrinterUsingTwoThreads();
        Thread oddThread = new Thread(evenOddPrinterUsingTwoThreads, "OddThread");
        Thread evenThread = new Thread(evenOddPrinterUsingTwoThreads, "EvenThread");

        oddThread.start();
        evenThread.start();
    }

    @Override
    public void run() {
        while (count <= 30) {
            if (count % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("EvenThread")) {
                synchronized (this) {
                    System.out.println("Value : " + count + " Printed by thread: " + Thread.currentThread().getName());
                    count++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            if (count % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("OddThread")) {
                synchronized (this) {
                    System.out.println("Value : " + count + " Printed by thread: " + Thread.currentThread().getName());
                    count++;
                    notify();
                }
            }
        }
    }
}
