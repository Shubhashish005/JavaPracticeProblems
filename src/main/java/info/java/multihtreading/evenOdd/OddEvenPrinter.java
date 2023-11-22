package info.java.multihtreading.evenOdd;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class OddEvenPrinter {

    public static Object object = new Object();
    private static IntPredicate oddCondition = e -> e % 2 != 0;
    private static IntPredicate evenCondition = e -> e % 2 == 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> OddEvenPrinter.printResults(oddCondition));
        CompletableFuture.runAsync(() -> OddEvenPrinter.printResults(evenCondition));

        Thread.sleep(1000);
    }

    public static void printResults(IntPredicate condition) {
        IntStream.range(1, 30)
                .filter(condition)
                .forEach(OddEvenPrinter::execute);

    }

    public static void execute(int number) {
        synchronized (object) {
            System.out.println("Value is: " + number + " Printed by thread: " + Thread.currentThread().getName());
            try {
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
