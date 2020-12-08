package collection;

import charactor.Hero;
import property.Consumables;
import property.Item;
import property.Weapon;

import java.util.LinkedList;

/*实现一个支持泛型接口的类*/
public class MyStack<T> implements Stack<T> { //类声明时也加上<T>
    LinkedList<T> values = new LinkedList<>();

    @Override
    public void push(T t) {
        values.addLast(t);
    }

    @Override
    public T pull() {
        return values.removeLast();
    }

    @Override
    public T peek() {
        return values.getLast();
    }

    public static void main(String[] args) {
        MyStack<Hero> heroMyStack = new MyStack<>(); //类实例时 使用泛型：在容器后面添加<type>，可以是类 抽象类 接口
        heroMyStack.push(new Hero("ashe"));
        heroMyStack.push(new Hero("Vladimir"));

        MyStack<Item> itemMyStack = new MyStack<>();
        itemMyStack.push(new Consumables());
        itemMyStack.push(new Weapon());
    }
}
