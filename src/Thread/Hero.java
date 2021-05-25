package Thread;

public class Hero {
    public String name;
    public float hp;
    public int damage;

    public Hero(String name, int hp, int damage) {
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }

    public Hero() {}

    public boolean isDead() {
        return hp <= 0;
    }

    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            //sleep会抛出InterruptedException 中断异常 因为当前线程sleep的时候有可能被停止
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=this.damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public void recover() {
        hp += 1;
    }
    public void hurt() {
        //使用this作为同步对象
        synchronized (this) {
            hp -= 1;
        }
    }

    public synchronized void recover2() {
        hp += 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        //通知那些等待在this对象上的线程，可以醒过来了，如第56行，等待着的减血线程，苏醒过来
        this.notify();
    }
    public synchronized void hurt2() {
        if (hp == 1) {
            try {
                //让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp -= 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }
}
