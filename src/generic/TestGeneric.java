package generic;

import charactor.Hero;
import property.Item;

import java.util.LinkedList;


public class TestGeneric<T> {
    LinkedList<T> values = new LinkedList<T>();

    public void push(T t) {
        values.addLast(t);
    }

    public T pull() {
        return values.removeLast();
    }

    public T peek() {
        return values.getLast();
    }

    public static void main(String[] args) {
        //在声明这个Stack的时候，使用泛型<Hero>就表示该Stack只能放Hero
        TestGeneric<Hero> heroStack = new TestGeneric<>();
        heroStack.push(new Hero());

        //不能放Item
        //heroStack.push(new Item());

        //在声明这个Stack的时候，使用泛型<Item>就表示该Stack只能放Item
        TestGeneric<Item> itemStack = new TestGeneric<>();
        itemStack.push(new Item());

        //不能放Hero
        //itemStack.push(new Hero());
    }
}
