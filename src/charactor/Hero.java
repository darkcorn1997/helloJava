package charactor;

import property.Consumables;
import property.Item;
import property.Weapon;


public class Hero {
    private String name;
    private int number;
    private int damage;

    public Hero() {}
    public Hero(String name) {
        this.name=name;
    }
    public Hero(String name, int number) {
        this.name=name;
        this.number=number;
    }
    public Hero(String name, int number, int damage) {
        this.name=name;
        this.number=number;
        this.damage=damage;
    }

    public String getName () {return this.name;}
    public int getNumber () {return this.number;}
    public int getDamage () {return this.damage;}

    @Override
    public String toString() {return this.name;}

    public void useItem(Item item) {
        item.effect();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        Item i1 = new Weapon();
        Item i2 = new Consumables();
        Weapon w = new Weapon();
        Consumables c = new Consumables();
        h.useItem(i1);
        h.useItem(i2);
        h.useItem(w);
        h.useItem(c);
    }
}
