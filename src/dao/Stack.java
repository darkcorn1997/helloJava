/*接口也支持泛型*/

package dao;
import charactor.Hero;

public interface Stack<T> { //自定义一个栈接口，先进后出
    public void push(T t); //把英雄推入到最后位置

    public T pull(); //把最后一个英雄取出来

    public T peek(); //查看最后一个英雄
}
