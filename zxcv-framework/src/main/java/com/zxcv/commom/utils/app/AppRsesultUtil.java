package com.zxcv.commom.utils.app;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.zxcv.api.commom.constants.app.AppPublicArgsEnum;
import com.zxcv.commom.redis.RedisUtils;
import com.zxcv.commom.web.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 *
 * Copyright: Copyright (c) 2017  ZTE-ITS
 *
 * @ClassName: AppRsesultUtil.java
 * @Description: app统一返回封装
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年5月17日   下午4:18:36 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年5月17日      wangbiao           v1.0.0               创建
 */
public class AppRsesultUtil {


    private static RedisUtils redisUtil;

    static {
        if (AppRsesultUtil.redisUtil == null) {
            AppRsesultUtil.redisUtil = (RedisUtils) SpringContextUtil.getBean("redisUtil");
        }
    }


    private static final Logger logger = LoggerFactory.getLogger(AppRsesultUtil.class);
    /**
     * 私钥key.
     */
    public static final String secret_key = "0eca8f5373ca4866aec2f8e9d9367104";

    /**
     * 私钥value.
     */
    public static final String secret_value = "14318527b13840c2a4af63fef52c2d6e";

    /**
     * 返回成功
     *
     * @return
     * @throws IOException
     */
    public static String success(Object o, String secret_key, String secret_value) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("data", JSONObject.toJSON(o));
        returnMap.put(AppPublicArgsEnum.APP_RETURN_CODE.getCode(), "0");
        returnMap.put(AppPublicArgsEnum.APP_RETURN_MESSAGE.getCode(), "success");

        /***平台分配的secret_key*/
        returnMap.put(AppPublicArgsEnum.APP_ID.getCode(), secret_key);
        /**随机数生成的盐值*/
        returnMap.put(AppPublicArgsEnum.APP_SALT.getCode(), getRandomStringByLength(32));
        /**签名的摘要算法*/
        returnMap.put(AppPublicArgsEnum.APP_SIGN_TYPE.getCode(), "md5");
        String appSign = "";
        try {
            appSign = ApprntSignUtil.signRequest(returnMap, secret_value, "md5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnMap.put(AppPublicArgsEnum.APP_SIGN.getCode(), appSign);
        logger.info("app 返回:" + JSONObject.toJSON(returnMap).toString());
        return JSONObject.toJSON(returnMap).toString();
    }

    /**
     * 返回成功
     *
     * @return
     * @throws IOException
     */
    public static String success(Object o) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (o == null) {
            returnMap.put("data", "");
        } else {
            returnMap.put("data", JSONObject.toJSON(o));
        }
        returnMap.put(AppPublicArgsEnum.APP_RETURN_CODE.getCode(), "0");
        returnMap.put(AppPublicArgsEnum.APP_RETURN_MESSAGE.getCode(), "success");

        /***平台分配的secret_key*/
        returnMap.put(AppPublicArgsEnum.APP_ID.getCode(), secret_key);
        /**随机数生成的盐值*/
        returnMap.put(AppPublicArgsEnum.APP_SALT.getCode(), getRandomStringByLength(32));
        /**签名的摘要算法*/
        returnMap.put(AppPublicArgsEnum.APP_SIGN_TYPE.getCode(), "md5");
        String appSign = "";
        try {
            appSign = ApprntSignUtil.signRequest(returnMap, secret_value, "md5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnMap.put(AppPublicArgsEnum.APP_SIGN.getCode(), appSign);
        String resultStr = JSONObject.toJSONString(returnMap, new ValueFilter() {
            @Override
            public Object process(Object object, String name, Object value) {

                if (value == null) {
                    value = "";
                }
                return value;
            }
        }, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
        logger.info("app 返回:" + JSONObject.toJSON(returnMap).toString());
        logger.info("resultStr:" + resultStr);
        return JSONObject.toJSON(returnMap).toString();
    }

    public static String success() {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(AppPublicArgsEnum.APP_RETURN_CODE.getCode(), 0);
        returnMap.put(AppPublicArgsEnum.APP_RETURN_MESSAGE.getCode(), "success");

        /**API接口名称*/
        /***平台分配的secret_key*/
        returnMap.put(AppPublicArgsEnum.APP_ID.getCode(), secret_key);
        /**随机数生成的盐值*/
        returnMap.put(AppPublicArgsEnum.APP_SALT.getCode(), getRandomStringByLength(32));
        /**签名的摘要算法*/
        returnMap.put(AppPublicArgsEnum.APP_SIGN_TYPE.getCode(), "md5");
        String appSign = "";
        try {
            appSign = ApprntSignUtil.signRequest(returnMap, secret_value, "md5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnMap.put(AppPublicArgsEnum.APP_SIGN.getCode(), appSign);
        logger.info("app 返回:" + JSONObject.toJSON(returnMap).toString());
        return JSONObject.toJSON(returnMap).toString();
    }

    /**
     * 验证签名
     *
     * @param params
     * @return
     */
    public static boolean validateSigin(Map<String, String> params) {
        String resgin = params.get(AppPublicArgsEnum.APP_SIGN.getCode());
        String newsign = AppRsesultUtil.createSigin(params, secret_value);
        return resgin.equals(newsign);
    }

    /**
     * 验证签名
     *
     * @return
     */
    public static boolean validateSigin(JSONObject obj, String secret_value) {
        Map<String, String> params = JsonUtil.json2map(obj.toJSONString());
        String resgin = params.get(AppPublicArgsEnum.APP_SIGN.getCode());
        String newsign = AppRsesultUtil.createSigin(params, secret_value);
        if (!resgin.equals(newsign)) {
            logger.error("签名不一致：原签名：" + resgin + ",本地签名：" + newsign);
        }
        return resgin.equals(newsign);
    }

    /**
     * 验证签名
     *
     * @return
     */
    public static boolean validateSigin(JSONObject obj) {
        Map<String, String> params = JsonUtil.json2map(obj.toJSONString());
        String resgin = params.get(AppPublicArgsEnum.APP_SIGN.getCode());
        String newsign = AppRsesultUtil.createSigin(params, secret_value);
        return resgin.equals(newsign);
    }

    /**
     * 生成签名
     *
     * @param map
     * @return
     */
    public static String createSigin(Map<String, String> map, String secret_value) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String appSign = "";
        if (map != null && map.size() > 0) {
            Set<Entry<String, String>> set = map.entrySet();
            for (Iterator<Entry<String, String>> iter = set.iterator(); iter.hasNext(); ) {
                Entry<String, String> entry = iter.next();
                if (!AppPublicArgsEnum.APP_SIGN.getCode().equals(entry.getKey())) {
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }
            try {
                appSign = ApprntSignUtil.signRequest(resultMap, secret_value, "md5");
            } catch (IOException e) {
                logger.info("app 错误返回:创建签名失败");
            }
        } else {
            logger.info("签名的数据为空,无法签名.");
        }
        return appSign;
    }

    /**
     * 返回失败
     *
     * @param code
     * @param msg
     * @return
     */
    public static String fail(String code, String msg) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(AppPublicArgsEnum.APP_RETURN_CODE.getCode(), code);
        returnMap.put(AppPublicArgsEnum.APP_RETURN_MESSAGE.getCode(), msg);

        /**API接口名称*/
        /***平台分配的appid*/
        returnMap.put(AppPublicArgsEnum.APP_ID.getCode(), secret_key);
        /**随机数生成的盐值*/
        returnMap.put(AppPublicArgsEnum.APP_SALT.getCode(), getRandomStringByLength(32));
        /**签名的摘要算法*/
        returnMap.put(AppPublicArgsEnum.APP_SIGN_TYPE.getCode(), "md5");
        String appSign = "";
        try {
            appSign = ApprntSignUtil.signRequest(returnMap, secret_value, "md5");
        } catch (IOException e) {
            logger.info("app 错误返回:创建签名失败");
        }
        returnMap.put(AppPublicArgsEnum.APP_SIGN.getCode(), appSign);

        logger.info("app 错误返回:" + JSONObject.toJSON(returnMap));
        return JSONObject.toJSON(returnMap).toString();
    }

    /**
     * 随机数生成的盐值.<br/>
     *
     * @param length
     * @return
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static boolean isMobils(String phone) {
        Pattern p = Pattern.compile("^((17[0-9])|(14[0-9])|(16[0-9])|(19[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,0-9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }


}
