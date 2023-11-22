package info.java.multihtreading.producerConsumer.traditional;

import java.util.Queue;
import java.util.Random;

public class ProducerThread implements Runnable {

    Queue<Integer> sharedList = null;
    private Object object = null;
    private int max_size = 5;

    ProducerThread(Queue<Integer> sharedList, Object object) {
        this.object = object;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (object) {
                if (sharedList.size() == max_size) {
                    System.out.println("Size is full: " + sharedList.size());
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
                sharedList.offer(added);
                object.notify();

            }
        }

    }
}
