package Thread;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    //线程池大小
    int threadPoolSize;
    //任务容器
    final LinkedList<Runnable> tasks = new LinkedList<>();

    //构造方法 启动十个线程
    public TestThreadPool() {
        threadPoolSize = 10;
        synchronized (tasks) {
            for (int i=0; i<threadPoolSize; i++) {
                new TaskConsumerThread("任务消费者线程 " + i).start();
            }
        }
    }

    //往任务容器中增加任务
    public void add(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            //唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    //非静态内部类
    class TaskConsumerThread extends Thread {
        public TaskConsumerThread(String name) {
            super(name);
        }
        Runnable task;
        @Override
        public void run() {
            System.out.println("启动： " + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    //允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + " 获取到任务，并执行");
                task.run();
            }
        }
    }

    public static void main(String[] args) {
        TestThreadPool threadPool = new TestThreadPool();
        int sleep = 1000;

        while (true) {
            threadPool.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:sleep;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
