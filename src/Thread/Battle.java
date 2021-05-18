package Thread;

public class Battle implements Runnable{
    //2. 实现Runnable接口
    private final Hero hero1;
    private final Hero hero2;

    public Battle(Hero h1, Hero h2) {
        this.hero1 = h1;
        this.hero2 = h2;
    }

    @Override
    public void run() {
        while (!hero2.isDead()) {
            hero1.attackHero(hero2);
        }
    }
}
