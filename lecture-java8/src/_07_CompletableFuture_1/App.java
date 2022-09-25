package _07_CompletableFuture_1;


/**
 * ex1) Mythread class 에 대한 스레드 생성
 * ex2) Runnable 인스턴스에 대한 스레드 생성
 * ex3) main thread 에서 interrupt 발생으로 진행중인 스레드 중지.
 * ex4) main thread에서 진행중인 스레드 종료 대기 (join)
 * -> 스레드간 간섭하는 명령어가 많아 로직이 매우 복잡해질 수 있다.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        // 출력 순서가 다를수 있다. 당연히.
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("hello " + myThread.getName());

        // new Runnable -> rammda 가능.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        });
        thread.start();

        System.out.println("hello2 " + thread.getName());


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted!!");
                        return ;
                    }
                }
            }
        });
        thread2.start();
        Thread.sleep(3000L);
        thread2.interrupt();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        });
        thread3.start();
        thread3.join();
        System.out.println("thread3 is done");

    }

    // static 이어야 함.
    static class MyThread extends  Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
