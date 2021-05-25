package Thread;

public class TestThread {
    Hero gareen = new Hero("盖伦",616,50);
    Hero teemo = new Hero("提莫",300,30);
    Hero bh = new Hero("赏金猎人",500,65);
    Hero leesin = new Hero("盲僧",455,80);

    public void test1() {
        //盖伦攻击提莫
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }
        //赏金猎人攻击盲僧
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }
    }

    public void test2() {
        //start()方法是启动线程 KillThread继承了Thread类 可直接调用start启动一个新的线程
        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();
    }

    public void test3() {
        //Battle实现了Runnable接口 因此有run方法，但是直接调用run 并不会启动一个新的线程，必须 借助一个线程对象的start()方法
        //所以在创建Thread对象的时候 把battle1作为构造方法的参数传递进去 这个线程启动的时候 就会去执行battle1.run()方法了
        Battle battle1 = new Battle(gareen,teemo);
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();
    }

    public void test4() {
        //匿名类形式
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (!teemo.isDead()) {
                    //线程临时暂停
                    Thread.yield();
                    gareen.attackHero(teemo);
                }
            }
        };
        //设置线程优先级1-10, MIN_PRIORITY=1, MAX_PRIORITY=10
        thread1.setPriority(10);
        thread1.start();

        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        thread2.start();
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                int second = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", second++);
                }
            }
        };
        //设置为守护线程 通常会被用来做日志 性能统计等工作；当一个进程里，所有的线程都是守护线程的时候，会结束当前进程
        thread.setDaemon(true);
        thread.start();
        //new TestThread().test1();
        //new TestThread().test2();
        //new TestThread().test3();
        new TestThread().test4();
    }
}
