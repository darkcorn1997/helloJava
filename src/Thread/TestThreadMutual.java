package Thread;

public class TestThreadMutual {
    //线程交互
    //有两个线程，处理同一个英雄。 一个加血 慢，一个减血 快
    //减血的线程，发现血量=1，就停止减血，直到加血的线程为英雄加了血，才可以继续减血
    public static void main(String[] args) {
        final Hero gareen = new Hero("盖伦", 50,10);

        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(true){
                    gareen.hurt2();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run(){
                do {
                    gareen.recover2();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } while (!(gareen.hp > 50));
            }
        };
        t2.start();

    }
}
