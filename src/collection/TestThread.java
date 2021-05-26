package collection;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        MyStack<Character> stack = new MyStack<>();
        new ProducerThread("Producer1",stack).start();
        new ProducerThread("Producer2",stack).start();
        new ProducerThread("Producer3",stack).start();
        Thread.sleep(1000);
        new ConsumerThread("Consumer1",stack).start();
        new ConsumerThread("Consumer2",stack).start();
        new ConsumerThread("Consumer3",stack).start();
    }
}
