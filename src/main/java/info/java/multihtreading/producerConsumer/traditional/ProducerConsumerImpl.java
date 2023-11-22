package info.java.multihtreading.producerConsumer.traditional;


import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImpl {

    public static void main(String[] args) {

        Queue<Integer> sharedQueue = new LinkedList<>();
        Object object = new Object();
        Thread producerThread = new Thread(new ProducerThread(sharedQueue, object), "Producer Thread");
        Thread consumerThread = new Thread(new ConsumerThread(sharedQueue, object), "Consumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}
