package collection;

import charactor.Hero;
import dao.Stack;
import property.Consumables;
import property.Item;
import property.Weapon;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*实现一个支持泛型接口的类*/
public class MyStack<T> implements Stack<T> { //类声明时也加上<T>
    LinkedList<T> values = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //往里塞一个; 插入的时候，加上synchronized，同步对象是当前实例
    @Override
    public synchronized void push(T t) {
        while (values.size() >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        values.addLast(t);
    }

    //取出一个; 使用lock占用锁
    @Override
    public T pull() {
        try {
            lock.lock();
            while (values.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            return values.removeLast();
        } finally {
            //使用unlock释放锁，必须放在finally执行，万一removeLast()抛出异常也会执行
            lock.unlock();
        }
    }

    @Override
    public T peek() {
        //看看一个; 查看没必要线程同步，因为不修改数据
        return values.getLast();
    }

    public static void main(String[] args) {
        MyStack<Hero> heroMyStack = new MyStack<>(); //类实例时 使用泛型：在容器后面添加<type>，可以是类 抽象类 接口
        heroMyStack.push(new Hero("ashe"));
        heroMyStack.push(new Hero("Vladimir"));
        heroMyStack.push(new Hero("garen"));
        System.out.println(heroMyStack.peek());
        System.out.println(heroMyStack.pull());
        System.out.println(heroMyStack.peek());

        MyStack<Item> itemMyStack = new MyStack<>();
        itemMyStack.push(new Consumables());
        itemMyStack.push(new Weapon());
    }
}
