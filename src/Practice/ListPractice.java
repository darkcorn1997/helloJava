package Practice;

import charactor.Hero;

import java.util.*;

public class ListPractice { //集合遍历，删除掉名字编号是8的倍数的对象
    public static char getLevel(int grade) {
        return grade>= 90 ? 'A' : grade>=60 ? 'B':'C';
    }

    public static void main(String[] args) { //容器类LinkedList实现了双向列表、队列、List接口
        Deque<Hero> q1 = new LinkedList<>();
        Queue<Hero> q2 = new LinkedList<>();
        List<Hero> heroes = new ArrayList<>();
        List<Hero> delete = new ArrayList<>();

        for (int i=0; i<100; i++) {  //for循环遍历
            Hero h = new Hero("hero"+i, i);
            heroes.add(h);
        }

        Iterator<Hero> iterator = heroes.iterator(); //迭代器遍历
        while (iterator.hasNext()) {
            Hero h = iterator.next();
            if (h.getNumber()%8==0) {delete.add(h);}
        }

        for (Hero h:delete) { heroes.remove(h); } //增强型for循环

        for (Hero h:heroes) { System.out.println(h); }
        System.out.println(getLevel(59));
    }
}
