package Practice; /*普通方法完成筛选*/

import charactor.Hero;

import java.util.*;
import java.util.stream.Collectors;

public class TestLambda1 {
    private static void filter(List<Hero> heroes) {
        for (Hero h:heroes) {
            if (h.getNumber()>100 && h.getDamage()<50) {
                System.out.println(h);
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for(int i=0; i<10; i++) {
            heroes.add(new Hero("hero"+i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println(heroes);
        System.out.println("筛选后的");
        filter(heroes);
        System.out.println("聚合方式 管道筛选");
        /*
        对元素进行筛选：
filter 匹配
distinct 去除重复(根据equals判断)
sorted 自然排序
sorted(Comparator<T>) 指定排序
limit 保留
skip 忽略
转换为其他形式的流
mapToDouble 转换为double的流
map 转换为任意类型的流
         */
        System.out.println(        heroes
                .stream()
                .filter(hero -> hero.getNumber()>100 && hero.getDamage()<50)
                .collect(Collectors.toList()));
    }
}
