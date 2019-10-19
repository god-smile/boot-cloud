package com.zxcv.commom.utils;

import java.nio.charset.Charset;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;


/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: com.clouds.common.utils
 * @Description: 微信配置信息工具类
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/7/26   下午2:17
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/7/26      atao          v1.0.0          创建
 */
public class WxConfigUtil {

    /**
     * AES加密的密钥
     */
    public static final String key = "gq1P3OIgSzKmZb2TDAcBlg==";

    /**
     * 加密
     *
     * @param dataStr 要加密的字符串
     * @return
     */
    public static String encode(String dataStr) {
        SymmetricCrypto symmetricCrypto = new SymmetricCrypto(SymmetricAlgorithm.AES, getKey());
        return Base64.encode(symmetricCrypto.encrypt(dataStr), Charset.defaultCharset());
    }

    /**
     * @param encryptText 要解密的字符串
     * @return
     */
    public static String decode(String encryptText) {
        SymmetricCrypto symmetricCrypto = new SymmetricCrypto(SymmetricAlgorithm.AES, getKey());
        return symmetricCrypto.decryptStr(Base64.decode(encryptText, Charset.defaultCharset()));
    }





    public static void main(String[] args) {
        String data = "wechat666888wechat666888wechat66";
        String encryptText = encode(data);
        data = decode(encryptText);
        System.out.println(encryptText);

        System.out.println(data);

    }

    private static byte[] getKey() {
        return Base64.decode(key, Charset.defaultCharset());
    }

    @SuppressWarnings("unused")
	private static String createNewKey() {
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        return Base64.encode(key);
    }

   /* public static void main(String[] args) {
        System.out.println( encode("E2C1204DF0FBC249178F92E45E4E6EEF"));

    }*/
    
//    public static void main(String[] args) {
//		System.out.println(WxConfigUtil.encode("246adb0289d3800b4fe6c5176df880e1"));
//	}

}
