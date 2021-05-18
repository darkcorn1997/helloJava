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
        //启动线程是start()方法
        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();
    }

    public void test3() {
        //启动线程是start()方法
        Battle battle1 = new Battle(gareen,teemo);
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();
    }

    public static void main(String[] args) {
        //new TestThread().test1();
        //new TestThread().test2();
        new TestThread().test3();
    }
}
