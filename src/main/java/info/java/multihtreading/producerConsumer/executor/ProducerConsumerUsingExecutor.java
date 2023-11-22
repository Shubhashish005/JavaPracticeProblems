package info.java.multihtreading.producerConsumer.executor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerUsingExecutor {

    public static void main(String[] args) {

        Queue<Integer> sharedQueue = new LinkedList<>();
        Object object = new Object();
        int max_size = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            if (sharedQueue.size() == max_size) {
                System.out.println("Size is full: " + sharedQueue.size());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            Integer added = random.nextInt(20);
            System.out.println(Thread.currentThread().getName() + " added: " + added);
            sharedQueue.offer(added);
            object.notify();
        });

        executorService.submit(() -> {
            while (true) {
                synchronized (object) {
                    if (sharedQueue.isEmpty()) {
                        System.out.println("Empty queue: " + sharedQueue.size());
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Integer removed = sharedQueue.poll();
                    System.out.println(Thread.currentThread().getName() + " removed: " + removed);
                    object.notify();
                }
            }
        });

    }
}
