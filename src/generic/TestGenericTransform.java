package generic;

import charactor.Hero;
import charactor.AdHero;

import java.util.ArrayList;


public class TestGenericTransform {

    public static void test1() {
        Hero hero = new Hero();
        AdHero adHero = new AdHero();
        //子类对象 转 父类对象 可以成功
        hero = adHero;
    }

    public static void test2() {
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<AdHero> adHeroes = new ArrayList<>();
        //子类泛型 转 父类泛型 不可以
        //heroes = adHeroes;
    }

    public static void main(String[] args) {
        test1();
    }
}
