package _07_CompletableFuture_3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep((2000L));
            return ("hello");
        };

//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println(helloFuture.isDone());
//        System.out.println("started!");
//
//        // true : interrupt 하고 취소
//        // false : interrupt 안하고 기다린 후 취소
//        // -> get()으로 값을 가져올 수 없다. (예외가 발생)
//        // isdone은 무조건 true가 된다. (canel 성공)
//        //helloFuture.cancel(true);
//        //helloFuture.get(); // 블록킹
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("end!");
//        executorService.shutdown();


        Callable<String> java = () -> {
            Thread.sleep((3000L));
            return ("java");
        };

        Callable<String> staek = () -> {
            Thread.sleep((1000L));
            return ("staek");
        };

        /*
            모든 작업이 종료 된 후 출력된다.
         */
//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, staek));
//        for (Future<String> f : futures)
//            System.out.println(f.get());
//        executorService.shutdown();


        // blocking call
        // 스레드가 작업 중 먼저 종료된 결과를 출력할 수 있다.
        String s = executorService.invokeAny(Arrays.asList(hello, java, staek));
        System.out.println(s);
        executorService.shutdown();

    }
}
