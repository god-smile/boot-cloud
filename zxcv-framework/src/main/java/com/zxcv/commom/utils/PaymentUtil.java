package com.zxcv.commom.utils;

import com.google.common.base.Charsets;

import cn.hutool.http.HttpUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * Copyright: Copyright (c) 2017  ZTE-ITS
 *
 * @ClassName: PaymentKit.java
 * @Description:
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年5月16日   下午2:01:53
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年5月16日      wangbiao           v1.0.0               创建
 */
public class PaymentUtil {
    private static final Logger log = LoggerFactory.getLogger(PaymentUtil.class);

    /**
     * 组装签名的字段
     *
     * @param params     参数
     * @param urlEncoder 是否urlEncoder
     * @return String
     */
    public static String packageSign(Map<String, String> params, boolean urlEncoder) {
        // 先将参数以其参数名的字典序升序进行排序
        TreeMap<String, String> sortedParams = new TreeMap<String, String>(params);
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Entry<String, String> param : sortedParams.entrySet()) {
            String value = param.getValue();
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(param.getKey()).append("=");
            if (urlEncoder) {
                try { value = urlEncode(value); } catch (UnsupportedEncodingException e) {}
            }
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * urlEncode
     *
     * @param src 微信参数
     * @return String
     * @throws UnsupportedEncodingException 编码错误
     */
    public static String urlEncode(String src) throws UnsupportedEncodingException {
        return URLEncoder.encode(src, Charsets.UTF_8.name()).replace("+", "%20");
    }

    /**
     * 生成签名
     *
     * @param params      参数
     * @param paternerKey 支付密钥
     * @return sign
     */
    public static String createSign(Map<String, String> params, String paternerKey) {
        // 生成签名前先去除sign
        params.remove("sign");
        log.debug("sign paternerKey:" + paternerKey);
        String stringA = packageSign(params, false);
        log.debug("生成字符串 stringA:" + stringA);
        String stringSignTemp = stringA + "&key=" + paternerKey;
        log.debug("连接商户stringSignTemp:" + stringSignTemp);
        return MD5Utils.enMD5(stringSignTemp).toUpperCase();
    }

    /**
     * 支付异步通知时校验sign
     *
     * @param params      参数
     * @param paternerKey 支付密钥
     * @return {boolean}
     */
    public static boolean verifyNotify(Map<String, String> params, String paternerKey) {
        String sign = params.get("sign");
        String localSign = PaymentUtil.createSign(params, paternerKey);
        return sign.equals(localSign);
    }

    /**
     * 微信下单，map to xml
     *
     * @param params 参数
     * @return String
     */
    public static String toXml(Map<String, String> params) {
        StringBuilder xml = new StringBuilder();
        xml.append("<xml>");
        for (Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // 略过空值
            if (StringUtils.isEmpty(value)) { continue;}
            ;
            xml.append("<").append(key).append(">");
            xml.append(entry.getValue());
            xml.append("</").append(key).append(">");
        }
        xml.append("</xml>");
        return xml.toString();
    }

    /**
     * 针对支付的xml，没有嵌套节点的简单处理
     *
     * @param xmlStr xml字符串
     * @return map集合
     */
    public static Map<String, String> xmlToMap(String xmlStr) {
        XmlHelper xmlHelper = XmlHelper.of(xmlStr);
        return xmlHelper.toMap();
    }

    private static String downloadBillUrl = "https://api.mch.weixin.qq.com/pay/downloadbill";

    /**
     * <pre>
     * ALL，返回当日所有订单信息，默认值
     * SUCCESS，返回当日成功支付的订单
     * REFUND，返回当日退款订单
     * REVOKED，已撤销的订单
     * </pre>
     */
    public static enum BillType {
        ALL,
        SUCCESS,
        REFUND,
        REVOKED
    }

    /**
     * 下载对账单
     * <pre>
     * 公众账号ID    appid        是    String(32)    wx8888888888888888    微信分配的公众账号ID（企业号corpid即为此appId）
     * 商户号        mch_id        是    String(32)    1900000109    微信支付分配的商户号
     * 设备号        device_info    否    String(32)    013467007045764    微信支付分配的终端设备号
     * 随机字符串    nonce_str    是    String(32)    5K8264ILTKCH16CQ2502SI8ZNMTM67VS    随机字符串，不长于32位。推荐随机数生成算法
     * 签名        sign        是    String(32)    C380BEC2BFD727A4B6845133519F3AD6    签名，详见签名生成算法
     * 对账单日期    bill_date    是    String(8)    20140603    下载对账单的日期，格式：20140603
     * 账单类型        bill_type    否    String(8)
     * </pre>
     *
     * @param appid       公众账号ID
     * @param mch_id      商户号
     * @param paternerKey 签名密匙
     * @param billDate    对账单日期
     * @return String
     */
    public static String downloadBill(String appid, String mch_id, String paternerKey, String billDate) {
        return downloadBill(appid, mch_id, paternerKey, billDate, null);
    }

    /**
     * 下载对账单
     * <pre>
     * 公众账号ID    appid        是    String(32)    wx8888888888888888    微信分配的公众账号ID（企业号corpid即为此appId）
     * 商户号        mch_id        是    String(32)    1900000109    微信支付分配的商户号
     * 设备号        device_info    否    String(32)    013467007045764    微信支付分配的终端设备号
     * 随机字符串    nonce_str    是    String(32)    5K8264ILTKCH16CQ2502SI8ZNMTM67VS    随机字符串，不长于32位。推荐随机数生成算法
     * 签名        sign        是    String(32)    C380BEC2BFD727A4B6845133519F3AD6    签名，详见签名生成算法
     * 对账单日期    bill_date    是    String(8)    20140603    下载对账单的日期，格式：20140603
     * 账单类型        bill_type    否    String(8)
     * </pre>
     *
     * @param appid       公众账号ID
     * @param mch_id      商户号
     * @param paternerKey 签名密匙
     * @param billDate    对账单日期
     * @param billType    账单类型
     * @return String
     */
    public static String downloadBill(String appid, String mch_id, String paternerKey, String billDate,
        PaymentUtil.BillType billType) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", appid);
        params.put("mch_id", mch_id);
        params.put("nonce_str", System.currentTimeMillis() + "");
        params.put("bill_date", billDate);
        if (null != billType) {
            params.put("bill_type", billType.name());
        } else {
            params.put("bill_type", PaymentUtil.BillType.ALL.name());
        }
        String sign = PaymentUtil.createSign(params, paternerKey);
        params.put("sign", sign);
        return HttpUtil.post(downloadBillUrl, PaymentUtil.toXml(params));
    }

    public static void main(String[] args) {
        //String appid = "wx099b7a61d9867fe0";
        //String mch_id = "1452886602";
        //String paternerKey = "CJ8qjI3isPNbAZghtTcQJB3c5N9PQmlI";

        String appid = "wxc70ad87faf3c67b9";
        String mch_id = "1291652301";
        String paternerKey = "d4624c36b6795d1d99dcf0547af5443d";
        String billDate = "20170716";
        String billStr = PaymentUtil.downloadBill(appid, mch_id, paternerKey, billDate, BillType.ALL);

        System.out.println(billStr);
        String[] res = billStr.split("\n");

        List<String> result = Arrays.asList(res);
        int length = result.size();
        result = result.subList(1,length-2);

        System.out.println(result.toString());

        



    }

}
