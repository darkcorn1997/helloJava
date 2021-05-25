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
}
