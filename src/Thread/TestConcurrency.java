package Thread;

public class TestConcurrency {
    //多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题, 假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击

    public static void main(String[] args) {
        Hero gareen = new Hero("盖伦",10000,50);
        int n = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);

        //是有多个线程在减少盖伦的hp, 同时又有多个线程在恢复盖伦的hp

        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        //n个线程增加盖伦的hp
        for (int i=0; i<n; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    //一、使用gareen作为synchronized
                    synchronized (gareen) {
                        gareen.recover();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
            addThreads[i] = thread;
        }

        //n个线程减少盖伦的hp
        for (int i=0; i<n; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    //二、在方法hurt中有synchronized(this)
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
            reduceThreads[i] = thread;
        }
        //三、直接用synchronized修饰方法 public synchronized void hurt() {}
        //如果一个类，其方法都是有synchronized修饰的，那么该类就叫做线程安全的类；
        //同一时间，只有一个线程能够进入 这种类的一个实例 去修改数据，进而保证了这个实例中的数据的安全(不会同时被多线程修改而变成脏数据)


        //等待所有线程结束
        for (Thread thread : addThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread thread : reduceThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,gareen.hp);

    }
}
