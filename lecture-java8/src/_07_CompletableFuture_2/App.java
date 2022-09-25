package _07_CompletableFuture_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        /**
         * 내부에 thread pool 있다.
         * 작업을 생성하면, 스레드가 작업을 맡고, 종료하고, 다시 다음 작업을 수행한다.
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        // graceful shutdown : 진행중인 작업 완료 후 스레드 종료
        executorService.shutdown();

        // 즉시종료
        //executorService.shutdownNow();


        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello1"));
        executorService1.submit(getRunnable("Hello2"));
        executorService1.submit(getRunnable("Hello3"));
        executorService1.submit(getRunnable("Hello4"));
        executorService1.submit(getRunnable("Hello5w"));


        executorService1.shutdown();

        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.schedule(getRunnable("bybye"), 3, TimeUnit.SECONDS);
        executorService2.shutdown();

        /**
         * shutdown 종료가 되기 때문에, 작성하지 않고 테스트를 하였음.
         */
        ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
        executorService3.scheduleAtFixedRate(getRunnable("fixedbyby"),1,2,TimeUnit.SECONDS);
        //executorService3.shutdown();

    }

    private static Runnable getRunnable(String hello) {
        return () -> System.out.println(hello + Thread.currentThread().getName());
    }
}
