package Thread;

public class KillThread extends Thread{
    //1. 继承Thread类
    private final Hero hero1;
    private final Hero hero2;

    public KillThread(Hero h1, Hero h2){
        this.hero1 = h1;
        this.hero2 = h2;
    }

    public void run(){
        while(!hero2.isDead()){
            hero1.attackHero(hero2);
        }
    }
}
