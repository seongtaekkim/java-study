package _07_CompletableFuture_5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        });
        // 의존성이 있는경우
        CompletableFuture<String> world = future.thenCompose(App::getWorld);
        System.out.println(world.get());


        CompletableFuture<String> world2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("world " + Thread.currentThread().getName());
            return ("world");
        });

        // 의존성이 없는 경우
        CompletableFuture<String> future3 = future.thenCombine(world2, (f, w) -> f + " " + w);
        System.out.println(future3.get());

        CompletableFuture<Void> future4 = CompletableFuture.allOf(future, world2)
                .thenAccept(System.out::println);
        System.out.println(future4.get());// 결과는 null

        System.out.println("=============================");
        // 이렇게 하면 아무런 블로킹 없이 자연스럽게 처리할 수 있다.
        List<CompletableFuture<String>> futures = Arrays.asList(future, world2);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join) // join 은 unchecked exception
                            .collect(Collectors.toList());
                });
        results.get().forEach(System.out::println);

        System.out.println("==============================");
        // 작업 중 먼저 끝나는걸 출력함.
        CompletableFuture<Void> future6 = CompletableFuture.anyOf(future, world2).thenAccept((s) -> {
            System.out.println(s);
        });
        future6.get();

        boolean throwError = false;

        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> {
            if (throwError)
                throw new IllegalArgumentException();

            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });
        System.out.println(future7.get());

        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> {
            if (throwError)
                throw new IllegalArgumentException();

            System.out.println("hello " + Thread.currentThread().getName());
            return ("hello");
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return ("Error");
            }
           return result;
        });

        System.out.println(future8.get());


        /**
         * forkjoin framework, flow 를 공부하면 더 깊게 공부할 수 있다.
         */

    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return message + " world";
        });
    }
}
