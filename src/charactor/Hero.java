package charactor;

import property.Consumables;
import property.Item;
import property.Weapon;


public class Hero implements Comparable<Hero>{
    private String name;
    private int number;
    private int damage;

    //实现Comparable接口 重写比较算法 从大到小
    @Override
    public int compareTo(Hero hero) {
        if (this.number < hero.number)
            return 1;
        else
            return -1;
    }

    public Hero() {
        System.out.println("new a hero with no para");
    }
    public Hero(String name) {
        this.name=name;
        System.out.println("new a hero with name");
    }
    public Hero(String name, int number) {
        this.name=name;
        this.number=number;
        System.out.println("new a hero with name number");
    }
    public Hero(String name, int number, int damage) {
        this.name=name;
        this.number=number;
        this.damage=damage;
        System.out.println("new a hero with name number damage");
    }

    public String getName() {return this.name;}
    public int getNumber() {return this.number;}
    public int getDamage() {return this.damage;}

    @Override
    public String toString() {return this.name;}

    public void useItem(Item item) {
        item.effect();
    }

    public void levelUp(int attack) {
        damage = this.damage + attack;
    }

    public static void battleWin() {
        System.out.println("hero battle win");
    }

    public static void main(String[] args) {
        Hero h = new Hero("ashe");

        Item i1 = new Weapon();
        Item i2 = new Consumables();

        Weapon w = new Weapon();
        Consumables c = new Consumables();

        h.useItem(i1);
        h.useItem(i2);
        h.useItem(w); //w引用指向类Weapon 向上转型成类Item
        h.useItem(c);
        System.out.println(h);

        Hero timo = new Hero("timo", 1, 100);
        timo.levelUp(10);
        System.out.println(timo.getDamage());

    }


}
