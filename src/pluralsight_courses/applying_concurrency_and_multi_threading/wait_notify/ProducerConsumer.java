package pluralsight_courses.applying_concurrency_and_multi_threading.wait_notify;

import java.util.Arrays;

public class ProducerConsumer {

    private static final Object lock = new Object();
    public static final int BUFFER_SIZE = 10;

    private static int[] buffer;
    private static int count;

    static Thread produceThread;
    static Thread consumeThread;

    public static void setBuffer(int[] buffer) {
        ProducerConsumer.buffer = buffer;
    }

    static class Producer {
        void produce() {
            synchronized (lock) {
                if (isFull(count, buffer.length)) {
                    try {
                        lock.wait();  //releases key and puts thread in wait state
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Setting a one at pos = "+count);

                System.out.println("produceThread.getState() = " + produceThread.getState());
                System.out.println("consumeThread.getState() = " + consumeThread.getState());

                buffer[count++] = 1;
                lock.notify(); //changes thread from wait to runnable state
            }
        }
    }


    static class Consumer {
        void consume() {
            synchronized (lock) {
                if (isEmpty(count)) {
                    try {
                        lock.wait();   //releases key and puts thread in wait state
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                buffer[--count] = 0;
            //    System.out.println("consumeThread.getState() = " + consumeThread.getState());
                System.out.println("Setting a zero at pos = "+count);
                lock.notify();  //changes thread from wait to runnable state
            }
        }
    }

    static boolean isEmpty(int count) {
        return count == 0;
    }

    static boolean isFull(int count, int length) {
        return count == length;
    }


    public static void main(String[] args) throws InterruptedException {

        setBuffer(new int[BUFFER_SIZE]);
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable prodTask = () -> {
            for (int i = 0; i < BUFFER_SIZE; i++) {
                producer.produce();
            //    System.out.println("produceThread.getState() = " + produceThread.getState());
            }

            System.out.println("Done producing");
        };

        Runnable consTask = () -> {
            for (int i = 0; i < 5; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming");
        };

        produceThread = new Thread(prodTask);
        consumeThread = new Thread(consTask);

        produceThread.start();
        consumeThread.start();

        produceThread.join();
        consumeThread.join();

        System.out.println("f produceThread.getState() = " + produceThread.getState());
        System.out.println("f consumeThread.getState() = " + consumeThread.getState());


        System.out.println("Sum of data in buffer " + Arrays.stream(buffer).sum());



    }


}
