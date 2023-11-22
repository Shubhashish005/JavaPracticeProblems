package info.java.multihtreading.producerConsumer.traditional;

import java.util.Queue;

public class ConsumerThread implements Runnable {

    Queue<Integer> sharedList = null;
    private Object object = null;

    ConsumerThread(Queue<Integer> sharedList, Object object) {
        this.object = object;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (sharedList.isEmpty()) {
                    System.out.println("Empty queue: " + sharedList.size());
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
                Integer removed = sharedList.poll();
                System.out.println(Thread.currentThread().getName() + " removed: " + removed);
                object.notify();
            }
        }
    }
}
