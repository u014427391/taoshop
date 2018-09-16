package com.muses.taoshop.common.core.util;

import java.io.*;

/**
 * <pre>
 *  序列化工具类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:2018.05.26     修改内容:
 * </pre>
 */
public class SerializeUtils {

    /**
     * 序列化对象
     * @param obj
     *      创建一个对象
     * @return
     *      字节流byte
     */
    public static byte[] doSerialize(Object obj){
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        baos = new ByteArrayOutputStream();

        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);

            byte[] byteArray = baos.toByteArray();
            return  byteArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化对象
     * @param byteArray
     *          字节流byte
     * @return
     *          返回一个对象
     */
    public static Object unSerialize(byte[] byteArray){
        ByteArrayInputStream bais = null;
        bais = new ByteArrayInputStream(byteArray);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            return  ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
