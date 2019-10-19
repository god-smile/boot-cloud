package com.zxcv.commom.utils;


import java.math.BigDecimal;

import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.exception.BizException;


/**
 * 
 * Copyright: Copyright (c) 2017  ZTE-ITS
 * 
 * @ClassName: AmountUtils.java
 * @Description: 
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年6月27日   下午5:24:43 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年6月27日      wangbiao           v1.0.0               创建
 */

public class AmountUtils {
	/**金额为分的格式 */  
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";  
    
    private AmountUtils() {
    }
     
    /**  
     * 将分为单位的转换为元并返回金额格式的字符串 （除100） 
     *  
     * @param amount 
     * @return 
     * @throws Exception  
     */  
    public static String changeF2Y(Long amount){  
        if(!amount.toString().matches(CURRENCY_FEN_REGEX)) {  
        	throw new BizException(ErrorType.BIZ_ERROR, "金额格式有误!");
        }  
          
        int flag = 0;  
        String amString = amount.toString();  
        if(amString.charAt(0)=='-'){  
            flag = 1;  
            amString = amString.substring(1);  
        }  
        StringBuilder result = new StringBuilder();  
        if(amString.length()==1){  
            result.append("0.0").append(amString);  
        }else if(amString.length() == 2){  
            result.append("0.").append(amString);  
        }else{  
            String intString = amString.substring(0,amString.length()-2);  
            for(int i=1; i<=intString.length();i++){  
                if( (i-1)%3 == 0 && i !=1){  
                    result.append(",");  
                }  
                result.append(intString.substring(intString.length()-i,intString.length()-i+1));  
            }  
            result.reverse().append(".").append(amString.substring(amString.length()-2));  
        }  
        if(flag == 1){  
            return "-"+result.toString();  
        }else{  
            return result.toString();  
        }  
    }

    public static String changeZFBF2Y(Long amount){
        if(!amount.toString().matches(CURRENCY_FEN_REGEX)) {
            throw new BizException(ErrorType.BIZ_ERROR, "金额格式有误!");
        }

        int flag = 0;
        String amString = amount.toString();
        if(amString.charAt(0)=='-'){
            flag = 1;
            amString = amString.substring(1);
        }
        StringBuilder result = new StringBuilder();
        if(amString.length()==1){
            result.append("0.0").append(amString);
        }else if(amString.length() == 2){
            result.append("0.").append(amString);
        }else{
            String intString = amString.substring(0,amString.length()-2);
            for(int i=1; i<=intString.length();i++){
                result.append(intString.substring(intString.length()-i,intString.length()-i+1));
            }
            result.reverse().append(".").append(amString.substring(amString.length()-2));
        }
        if(flag == 1){
            return "-"+result.toString();
        }else{
            return result.toString();
        }
    }

    /** 
     * 将分为单位的转换为元 （除100） 
     *  
     * @param amount 
     * @return 
     * @throws Exception  
     */  
    public static String changeF2Y(String amount){  
        if(!amount.matches(CURRENCY_FEN_REGEX)) {  
        	throw new BizException(ErrorType.BIZ_ERROR, "金额格式有误!");
        }  
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();  
    }
    
      
    /**  
     * 将元为单位的转换为分 （乘100） 
     *  
     * @param amount 
     * @return 
     */  
    public static String changeY2F(Long amount){  
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();  
    }  
      
    /**  
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额 
     *  
     * @param amount 
     * @return 
     */  
    public static String changeY2F(String amount){  
    	if(amount==null){
    		return "0";
    	}
        String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额  
        int index = currency.indexOf('.');  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString();  
    }  
    
    
    /**
     * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
     * 要用到正则表达式
     */
    public static String moneyUpperCase(double n){
        String fraction[] = {"角", "分"};
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String unit[][] = {{"元", "万", "亿"},
                     {"", "拾", "佰", "仟"}};
 
        String head = n < 0? "负": "";
        n = Math.abs(n);
         
        String s = "";
        for (int i = 0; i < fraction.length; i++) {
        	double f1=  BigDecimal.valueOf(n).setScale(2,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(10 * Math.pow(10, i))).doubleValue();
        	s += (digit[(int) (Math.floor(f1) % 10)] + fraction[i]).replaceAll("(零.)+", ""); 
             
        }
        if(s.length()<1){
            s = "整";    
        }
        int integerPart = (int)Math.floor(n);
 
        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p ="";
            for (int j = 0; j < unit[1].length && n > 0; j++) {
                p = digit[integerPart%10]+unit[1][j] + p;
                integerPart = integerPart/10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }
  
}
