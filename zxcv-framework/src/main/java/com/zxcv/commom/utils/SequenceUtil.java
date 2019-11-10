package com.zxcv.commom.utils;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.StringUtils;

/**
 * Copyright: Copyright (c) 2019  zxcv
 *
 * @ClassName:
 * @Description:
 * @version: v1.0.0
 * @author: wangfei
 * @date: 2019/11/09   下午14:53
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019/11/09      wangfei          v1.0.0          创建
 */
@Component
public class SequenceUtil {
	private static String workerId = null;
	private static String datacenterId = null;
	
	static {
		
		if(StringUtils.isEmpty(workerId)) {
			workerId = new java.util.Random().nextInt(30)+"";
		}
		
		if (datacenterId == null) {
			datacenterId = new java.util.Random().nextInt(30)+"";
		}
	}
    
     
    /**
     *
     * @param typeEnum 序列枚举值	
     */
    public static String getNextId(String typeEnum) {
        SnowflakeIdWorker idWorker =SnowflakeIdWorker.newInstance(Long.parseLong(workerId),Long.parseLong(datacenterId));
        long id = idWorker.nextId();
        return typeEnum+id;
    }

    /**
     * @param workerId 工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     */
    public static Long getNextId(int workerId,int datacenterId) {
        SnowflakeIdWorker idWorker = SnowflakeIdWorker.newInstance(workerId,datacenterId);
        long id = idWorker.nextId();
        return id;
    }
    /**
    *序列枚举值
    */
   public static Long getNextId() {
       SnowflakeIdWorker idWorker =SnowflakeIdWorker.newInstance(Long.parseLong(workerId),Long.parseLong(datacenterId));
       long id = idWorker.nextId();
       return id;
   }
   
}
