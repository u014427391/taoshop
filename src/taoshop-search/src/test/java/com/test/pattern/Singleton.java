package com.test.pattern;
/**
 * <pre>
 * 	设计模式之单例模式
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 *
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:2018年04月18日     修改内容:
 *          </pre>
 */
public class Singleton {
    private static Singleton instance;
    //定义private构造函数，使类不可以被实例
    private Singleton (){}

//    /**
//     * 懒汉模式，线程不安全，懒加载
//     * @return
//     */
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

//    /**
//     * 懒汉模式，线程安全，懒加载
//     * @return
//     */
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    //加载类的时候，利用JVM的类加载机制创建对象，保证了线程安全，但是效率不好
//    private static Singleton instance = new Singleton();

//    /**
//     * 饿汉模式，线程安全，非懒加载
//     * @return
//     */
//    public static Singleton getInstance() {
//        return instance;
//    }

//    private volatile static Singleton instance;

//    /**
//     * 双检锁/双重校验锁（DCL，即 double-checked locking）线程安全，懒加载
//     * @return
//     */
//    public static Singleton getInstance(){
//        if(instance == null){
//            synchronized (Singleton.class){
//                if(instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    public static class SingletonHolder{
        private final static Singleton INSTANCE = new Singleton();
    }

    /**
     * 登记式/静态内部类，线程安全，懒加载
     * @return
     */
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

//    /**
//     * 枚举方式
//     */
//    public enum Singleton {
//        INSTANCE;
//        public void whateverMethod() {
//        }
//    }
}  