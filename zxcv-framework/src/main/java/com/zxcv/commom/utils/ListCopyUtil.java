package com.zxcv.commom.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * list 拷贝util.<br/>
 * 
 * Copyright: Copyright (c) 2017  zteits
 * 
 * @ClassName: ListUtil.java
 * @Description: 
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2017年8月10日   下午4:31:27 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年8月10日      wangfs           v1.0.0               创建
 */
public class ListCopyUtil {

	/**
	 * list 拷贝.<br/>
	 * @param form
	 * @param to
	 * @param clazz
	 */
	public static<DO,DTO> void listCopyProperties(List<DO> form,List<DTO> to,Class<DTO> clazz){
		if(!CollectionUtils.isEmpty(form)){
			for(DO strDO:form){
				if(strDO != null){
					try {
						DTO dto =clazz.newInstance();
						BeanUtils.copyProperties(strDO, dto);
						to.add(dto);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
