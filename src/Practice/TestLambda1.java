package Practice;

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

    //普通方法完成筛选
    public static void main(String[] args) {
        var r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for(int i=0; i<10; i++) {
            heroes.add(new Hero("hero"+i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println(heroes);
        System.out.println("筛选后的");
        filter(heroes);

        System.out.println("流式处理");
        /*
        Collection.stream() 流处理；但数组没有stream()方法，需要使用Arrays.stream(hs)或者Stream.of(hs)
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
        结束操作
          forEach() 遍历每个元素
          toArray() 转换为数组
          min(Comparator<T>) 取最小的元素
          max(Comparator<T>) 取最大的元素
          count() 总数
          findFirst() 第一个元素
          get()
         */
        System.out.println(
                heroes.stream()
                        .filter(hero -> hero.getNumber()>100 && hero.getDamage()<50)
                        .collect(Collectors.toList()));
    }
}
