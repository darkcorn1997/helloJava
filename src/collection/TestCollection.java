package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import charactor.Hero;

public class TestCollection {

    public static void testArrayList() {
        List<Hero> heroes = new ArrayList<>(); //ArrayList实现了接口List  常会把引用声明为接口List类型

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heroes.add(specialHero);

        //遍历
        for (Hero hero : heroes) {
            System.out.println(hero);
        }

        //转化为数组
        Hero[] hs = (Hero[]) heroes.toArray(new Hero[]{});
        System.out.println("数组:" + Arrays.toString(hs));
    }

    public static void testLinkedList() {
        List<Hero> heroes = new LinkedList<>();
    }


    public static void main(String[] args) {
        TestCollection.testArrayList();
    }
}
