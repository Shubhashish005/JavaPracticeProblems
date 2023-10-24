package info.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExtensiveOperation implements Runnable {
    @Override
    public void run() {
        System.out.println("Current Running thread: " + Thread.currentThread().getName());
    }
}

public class ExecutorServiceFixedPool {

    public static void main(String[] args) {

        int numberOfProcessors = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(numberOfProcessors);

        for (int i = 0; i < 100; i++) {
            service.execute(new ExtensiveOperation());
        }
    }
}
