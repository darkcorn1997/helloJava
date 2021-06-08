package Practice; /*匿名类方式以及lambda方式对比*/

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda2 {

    public boolean testHero1(Hero h) {
        return h.getNumber()>100 && h.getDamage()<50;
    }
    public static boolean testHero2(Hero h) {
        return h.getNumber()>100 && h.getDamage()<50;
    }

    private static void

    filter(List<Hero> heroes, HeroChecker checker) {
        for (Hero h : heroes) {
            if (checker.test(h)) {
                System.out.println(h);
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println(heroes);
        //匿名类的正常写法
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return h.getNumber()>100 && h.getDamage()<50;
            }
        };
        System.out.println("匿名类筛选");
        filter(heroes, checker);
        /*
        去掉new、方法返回类型、方法名，保留方法参数和方法体，用->连接：
        HeroChecker checker1 = (Hero h) -> {return h.getDamage()>100 && h.getDamage()<50;};
        去掉return和{}：
        HeroChecker checker2 = (Hero h) -> h.getDamage()>100 && h.getDamage()<50;
        去掉参数类型和()，多个参数时需要()：
        HeroChecker checker3 = h -> h.getDamage()>100 && h.getDamage()<50;
        把checker3作为参数传递进去：
        filter(heroes, checker3);
        lambda方式，直接将表达式传递进去：       */
        System.out.println("lambda筛选");
        filter(heroes, h -> h.getDamage()>100 && h.getDamage()<50);

        //在lambda中使用静态方法
        filter(heroes, h -> TestLambda2.testHero2(h));
        //等同于直接引用静态方法
        filter(heroes, TestLambda2::testHero2);

        //lambda中引用对象方法
        TestLambda2 testLambda2 = new TestLambda2();
        filter(heroes, testLambda2::testHero1);
    }
}