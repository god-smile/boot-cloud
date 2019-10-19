package com.zxcv.commom.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * Copyright: Copyright (c) 2017 ZTE-ITS
 * 
 * @ClassName: JsonUtil.java
 * @Description:
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年5月16日 下午7:11:09 Modification History: Date Author Version
 *        Description ---------------------------------------------------------*
 *        2017年5月16日 wangbiao v1.0.0 创建
 */
public class JsonUtil {

	public static Map<String, Object> json2Objmap(String jsonMapStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(jsonMapStr)){
			JSONObject jsonObject = (JSONObject) JSON.parse(jsonMapStr);
			Set<Entry<String, Object>> entrySet = jsonObject.entrySet();
			
			for (Entry<String, Object> entry : entrySet) {
				map.put(entry.getKey(), entry.getValue().toString());
			}
		}else{
			throw new NullPointerException("空字符串.");
		}
		
		return map;
	}
	
	public static Map<String, String> json2map(String jsonMapStr) {
		Map<String, String> map = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(jsonMapStr)){
			JSONObject jsonObject = (JSONObject) JSON.parse(jsonMapStr);
			Set<Entry<String, Object>> entrySet = jsonObject.entrySet();
			
			for (Entry<String, Object> entry : entrySet) {
				map.put(entry.getKey(), entry.getValue().toString());
			}
		}else{
			throw new NullPointerException("空字符串.");
		}
		
		return map;
	}
	public static Map<String, String> json2map(String jsonMapStr,boolean order) {
		Map<String, String> map = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(jsonMapStr)){
			JSONObject jsonObject = (JSONObject) JSON.parse(jsonMapStr);
			Set<Entry<String, Object>> entrySet = jsonObject.entrySet();
			
			for (Entry<String, Object> entry : entrySet) {
				//map.put(entry.getKey(), entry.getValue().toString());
	            map.put(entry.getKey(),JSONObject.toJSONString(entry.getValue(),SerializerFeature.MapSortField));

			}
		}else{
			throw new NullPointerException("空字符串.");
		}
		
		return map;
	}
	

}