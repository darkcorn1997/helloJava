package charactor;

import dao.AD;
import property.Consumables;
import property.Item;
import property.Weapon;

public class AdHero extends Hero implements AD {

    public AdHero() {
        System.out.println("new a AdHero with no para");
    }
    public AdHero(String name) {
        //super 显式调用父类带参的构造方法
        super(name);
        System.out.println("new a AdHero with name");
    }

    @Override
    public void physicAttack() {
        System.out.println("physic attack");
    }

    //重写父类的对象方法
    public void useItem(Item item) {
        //super 调用父类方法
        super.useItem(item);
    }

    //通过重写 隐藏父类的类方法
    public static void battleWin() {
        System.out.println("AdHero battle win");
    }

    public static void main(String[] args) {
        Hero.battleWin();
        AdHero.battleWin();

        AdHero hero = new AdHero("Wilson");
        hero.useItem(new Consumables());
        hero.useItem(new Weapon());

        hero.attack();
        System.out.println(hero.type);
    }
}
