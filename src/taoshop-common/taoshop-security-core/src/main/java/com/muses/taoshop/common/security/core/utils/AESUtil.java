package com.muses.taoshop.common.security.core.utils;

import sun.misc.BASE64Encoder;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * <pre>
 *  AES加密工具类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.05.20    修改内容:
 * </pre>
 */
public class AESUtil {

    /**
     * 加密
     * @param content
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //防止linux下 随机生成key
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
        secureRandom.setSeed(encryptKey.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        return cipher.doFinal(byteContent);
    }

    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * 解密
     * @param encryptBytes
     * @param decryptKey
     * @return
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //防止linux下 随机生成key
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
        secureRandom.setSeed(decryptKey.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(encryptBytes);

        return new String(result);
    }

    public static String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }
}
