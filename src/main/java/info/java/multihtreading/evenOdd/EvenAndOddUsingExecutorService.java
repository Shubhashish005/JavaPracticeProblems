package info.java.multihtreading.evenOdd;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenAndOddUsingExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(1, 30)
                .forEach(number -> {
                    CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(number)
                            .thenApplyAsync(num -> {
                                if (num % 2 != 0) {
                                    System.out.println("Value: " + num + " Printed by thread: " + Thread.currentThread().getName());
                                }
                                return num;
                            }, executorService);
                    oddCompletableFuture.join();

                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(number)
                            .thenApplyAsync(num -> {
                                if (num % 2 == 0) {
                                    System.out.println("Value: " + num + " Printed by thread: " + Thread.currentThread().getName());
                                }
                                return num;
                            }, executorService);
                    evenCompletableFuture.join();
                });
        executorService.shutdown();

    }
}
