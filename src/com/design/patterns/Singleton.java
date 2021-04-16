package com.design.patterns;

import java.util.Objects;

/**
 * @Description: 单例设计模式
 * http://c.biancheng.net/view/1338.html
 * @Author: liujunpeng
 * @Date: 2021/3/3 9:30
 * @Version: 1.0
 */
public class Singleton {

    public static void main(String[] args) {
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());

        System.out.println(new Singleton());
        System.out.println(new Singleton());

        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());

    }

    /**
     * 懒汉式单例
     * 该模式的特点是类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例。
     * 注意：如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
     * 如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
     */
    static class LazySingleton {

        private static volatile LazySingleton instance = null;

        //private 避免类在外部被实例化
        private LazySingleton() {
        }

        //getInstance 方法前加同步
        private static synchronized LazySingleton getInstance() {
            if (Objects.isNull(instance)) {
                return instance = new LazySingleton();
            }
            return instance;
        }
    }

    /**
     * 饿汉式
     * 该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
     * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
     */
    static class HungrySingleton {

        private static final HungrySingleton instance = new HungrySingleton();

        //private 避免类在外部被实例化
        private HungrySingleton() {
        }

        private static HungrySingleton getInstance() {
            return instance;
        }

    }

}

