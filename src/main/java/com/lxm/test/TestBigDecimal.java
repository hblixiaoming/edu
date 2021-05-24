package DCTest;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class TestBigDecimal {
    private void test1() throws Exception {
        AtomicReference<BigDecimal> num = new AtomicReference<>(BigDecimal.ZERO);
        CountDownLatch countDownLatch = new CountDownLatch(10);
//        ExecutorService executor = Executors.newFixedThreadPool(20);
//        for (int i = 0; i < 10; i++) {
//            executor.submit(new Task(num, countDownLatch));
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Task(num, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println(num);
//        executor.shutdown();
    }

    private void test2(BigDecimal num) {
        num = num.add(BigDecimal.ONE);
        System.out.println(num);
    }

    public static void main(String[] args) throws Exception {
        TestBigDecimal test = new TestBigDecimal();
        BigDecimal num = BigDecimal.ZERO;
        test.test2(num);
        System.out.println(num);
    }
}

class Task implements Runnable {
    private AtomicReference<BigDecimal> num;
    private CountDownLatch latch;

    public Task(AtomicReference<BigDecimal> num, CountDownLatch latch) {
        this.num = num;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            num.set(num.get().add(BigDecimal.ONE));
        }
//        BigDecimal temp = num.get();
//        for (int i = 0; i < 10; i++) {
//            temp = temp.add(BigDecimal.ONE);
//        }
//        num.set(temp);
//        synchronized (num){
//            for (int i = 0; i < 10; i++) {
//                num.set(num.get().add(BigDecimal.ONE));
//            }
//        }
        latch.countDown();
    }
}