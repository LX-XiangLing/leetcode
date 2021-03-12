package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lixiang
 * @Date 2021/3/13
 */
public class DeadLock {
    public static String lockA = "A";
    public static String lockB = "B";

    public static void main(String[] args) {
        Thread a = new Thread(new myThreadA());
        Thread b = new Thread(new myThreadB());
        a.start();
        b.start();

    }

    static class myThreadA implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lockA) {
                    try {
                        System.out.println("获取了A");
                        Thread.sleep(30);
                        synchronized (lockB) {
                            System.out.println("先获取A再获取B");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    static class myThreadB implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lockB) {
                    try {
                        System.out.println("获取了B");
                        TimeUnit.SECONDS.sleep(30);
                        synchronized (lockA) {
                            System.out.println("先获取B再获取A");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

}
