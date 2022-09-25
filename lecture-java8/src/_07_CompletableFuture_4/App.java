package _07_CompletableFuture_4;

import java.util.concurrent.*;

/**
 * ComplatableFuture
 * - 스레드개수를 정의하지 않아도, 내부에서 forkjoinpool이 dequeue방식으로 알아서 처리한다. (Excutors를 통해 스레드 개수를 정할 수 도 있다.)
 * - 작업 정의 할 때, 종료 후 작업할 내용을 작성할 수 있다. ( .thenAccept, .thenRun, .thenApply)
 * - 종료 후 작업 정의 시에도 스레개수를 정할 수 잇다. (.thenAcceptAsync, thenRunAsync, .thenApplyAsync )
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<String> future = executorService.submit(() -> "hello");
//        future.get();

        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("staek");
        System.out.println(future.get());

        // static factory method
        CompletableFuture<String> future2 = CompletableFuture.completedFuture("staek");
        System.out.println(future2.get());

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
        });
        future3.get();
        //future3.join();

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        });
        System.out.println(future4.get());


        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future5.get());

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        future6.get();

        CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        }).thenRun(() -> {
            System.out.println(Thread.currentThread());
        });
        future7.get();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread());
        });
        future8.get();
    }
}
