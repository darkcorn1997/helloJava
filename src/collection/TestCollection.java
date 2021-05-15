package collection;

import java.util.*;

import charactor.Hero;

public class TestCollection {

    public static void testArrayList() {
        List<Hero> heroes = new ArrayList<>(); //ArrayList实现了接口List  常会把引用声明为接口List类型

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero " + i, i));
        }
        Hero specialHero = new Hero("hero 5", 5);
        heroes.add(specialHero);
        System.out.println(heroes);

        //一、Hero类实现Comparable接口 不然直接sort报错 不知道比较哪个属性
        Collections.sort(heroes);
        System.out.println(heroes);

        //二、实现一个匿名类 从小到大
        Comparator<Hero> c = new Comparator<Hero>() {
            @Override
            public int compare(Hero h1, Hero h2) {
                if (h1.getNumber() > h2.getNumber())
                    return 1;
                else
                    return -1;
            }
        };
        heroes.sort(c);
        System.out.println(heroes);

        //迭代器遍历
        Iterator<Hero> iterator = heroes.iterator();
        while (iterator.hasNext()) {
            Hero h = iterator.next();
            System.out.println(h);
        }

        //增强for遍历
        for (Hero hero : heroes) {
            System.out.println(hero);
        }

        //转化为数组
        Hero[] hs = heroes.toArray(new Hero[]{});
        System.out.println("数组:" + Arrays.toString(hs));
    }

    public static void testLinkedList() {
        Deque<Hero> heroes = new LinkedList<>(); //LinkedList实现了双向链表结构Deque以及List,可以很方便的在头尾插入删除数据
        // 链表结构: 与数组结构相比较，数组结构，就好像是电影院，每个位置都有标示，每个位置之间的间隔都是一样的
        // 而链表就相当于佛珠，每个珠子，只连接前一个和后一个，不用关心除此之外的其他佛珠在哪里
        heroes.add(new Hero("0"));
        heroes.addFirst(new Hero("1"));
        heroes.addLast(new Hero("2"));
        heroes.add(new Hero("3"));
        System.out.println(heroes);
        System.out.println(heroes.getFirst());
        System.out.println(heroes.getLast());
        heroes.removeFirst();
        heroes.removeLast();
        System.out.println(heroes);
    }

    public static void testLinkedList2() {
        Queue<Hero> heroes = new LinkedList<>();//Deque继承Queue,因此LinkedList还实现了Queue 先进先出队列 FIFO
        //加在队列最后
        heroes.offer(new Hero("ASHE",10));
        heroes.offer(new Hero("RIVEN",100));
        heroes.add(new Hero("ZED",50));
        System.out.println(heroes);
        //看看第一个 但不会取出来
        Hero hero = heroes.peek();
        System.out.println(hero);
        System.out.println(heroes);
        //取出第一个
        Hero hero1 = heroes.poll();
        System.out.println(hero);
        System.out.println(heroes);
    }

    public static void stream() {
        //集合框架的聚合操作
        Random r = new Random();
        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        for (Hero hero : heroes) {
            System.out.println(hero.getDamage());
        }

        //传统方式 先排序 从大到小
        heroes.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o2.getDamage() - o1.getDamage();
            }
        });

        for (Hero hero : heroes) {
            System.out.println("排序后：" + hero.getDamage());
        }

        Hero hero = heroes.get(2);
        System.out.println("通过传统方式找出来的hp第三高的英雄名称是:" + hero.getName());

        //聚合方式
        String name =heroes
                .stream()
                .sorted((h1,h2)->h2.getDamage()>h1.getDamage()?1:-1)
                .skip(2)
                .map(Hero::getName)
                .findFirst()
                .get();

        System.out.println("通过聚合操作找出来的hp第三高的英雄名称是:" + name);
    }

    public static void main(String[] args) {
        //TestCollection.testArrayList();
        //TestCollection.testLinkedList();
        //TestCollection.testLinkedList2();
        TestCollection.stream();

    }
}
