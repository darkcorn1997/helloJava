package dao;

public interface AP {

    /**
     * 接口和抽象类的区别
     * 区别1：
     * 子类只能继承一个抽象类，不能继承多个
     * 子类可以实现多个接口
     *
     * 区别2：
     * 抽象类可以定义
     * public,protected,package,private
     * 静态和非静态属性
     * final和非final属性
     * 但是接口中声明的属性，只能是
     * public 静态 final的
     * 即便没有显式的声明
     *
     * 注: 抽象类和接口都可以有实体方法。 接口中的实体方法，叫做默认方法
     */

    String type = "法师";
    default void attack() {
        System.out.println("attack");
    };

    void magicAttack();

    static void main(String[] args) {

    }

}
