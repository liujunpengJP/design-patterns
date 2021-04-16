package com.design.patterns;

/**
 *
 * 原型模式的优点：
 * Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 * 可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 * 原型模式的缺点：
 * 需要为每一个类都配置一个 clone 方法
 * clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
 * 当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。
 *
 * @Description: 原型设计模式
 * http://c.biancheng.net/view/1343.html
 * 原型模式包含以下主要角色。
 * 抽象原型类：规定了具体原型对象必须实现的接口。
 * 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 * @Author: liujunpeng
 * @Date: 2021/3/3 9:59
 * @Version: 1.0
 */
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        System.out.println(realizetype);
        Realizetype realizetypekl = (Realizetype) realizetype.clone();
        System.out.println(realizetypekl);
    }

    /**
     * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
     * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
     */
    static class Realizetype implements Cloneable {
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
