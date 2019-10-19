package com.zxcv.commom.redis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.commom.constants.TimeConstants;

/**
 * Redis缓存工具类.<br/>
 * 使用描述: 1.使用的时候需要在用的地方 @Autowired 进去.<br/>
 *
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: RedisCacheUtil.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2017年6月23日   上午9:05:16
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年6月23日      wangfs           v1.0.0               创建
 */
@Component
public class RedisCacheUtil {
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheUtil.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 通过key获取value值.<br/>
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
	public <T> T get(String key) {
        if (StringUtils.isNotEmpty(key)) {
            return (T)redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * 刷新缓存.<br/>
     *
     * @return
     */
    public String flushDB() {
        return (String)redisTemplate.execute(new RedisCallback<Object>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 查询对应的key是否存在.<br/>
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return (boolean)redisTemplate.execute(new RedisCallback<Object>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    /**
     * 将key-value存入缓存.<br/>
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        if (StringUtils.isNotEmpty(key)) {
            redisTemplate.opsForValue().set(key, value);

        }
    }

    /**
     * 将key-value存入缓存.<br/>
     *
     * @param key
     * @param value
     * @param livetime 失效时间 单位:秒.<br/>
     */
    public void put(String key, Object value, Long livetime) {
        if (StringUtils.isNotEmpty(key)) {
            redisTemplate.opsForValue().set(key, value, livetime, TimeUnit.SECONDS);
        }
    }

    /**
     * 通过key删除缓存.<br/>
     *
     * @param key
     */
    public void remove(String key) {
        if (key != null && key.length() > 0) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 删除多个key.<br/>
     *
     * @param key String[].<br/>
     */
    public void remove(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

    /**
     * 将list放入缓存.<br/>
     *
     * @param key
     * @param list
     */
    public void putList(String key, List<?> list) {
        if (StringUtils.isNotEmpty(key) && list != null && list.size() > 0) {
            redisTemplate.boundListOps(key).leftPushAll(list);
        }

    }

    /**
     * 将list放入缓存.<br/>
     *
     * @param key
     */
    public List<?> getList(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        } else {
            List<Object> list = redisTemplate.boundListOps(key).range(0, -1);
            return CollectionUtils.isEmpty(list) ? null : list.subList(1, list.size() - 1);

        }

    }

    /**
     * hash 保存数据
     *
     * @param key
     * @param hashKey
     * @param value   2017年5月24日 zhaowg
     */
    public void hPut(String key, String hashKey, Object value) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(hashKey)) {
            return;
        }
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * hash multiGet
     *
     * @param key
     * @param hashKey
     * 2017年5月24日 zhaowg
     */
    public <T> T hGet(String key, String hashKey) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(hashKey)) {
            return null;
        }
        @SuppressWarnings("unchecked")
		T value = (T)redisTemplate.opsForHash().get(key, hashKey);
        return value;
    }

    /**
     * hash multiGet
     *
     * @param key
     */
    public <T> List<T> hmultiGet(String key, List<String> hashKeys) {
        if (StringUtils.isBlank(key) || CollectionUtils.isEmpty(hashKeys)) {
            return Lists.newArrayList();
        }
        HashOperations<String, String, T> hashOperations = redisTemplate.opsForHash();
        List<T> hvalues = hashOperations.multiGet(key, hashKeys);
        return hvalues;
    }

    /**
     * 获取hash 全部的键值对
     *
     * @param key
     * @return 2017年9月13日 zhaowg
     */
    public <T> Map<String, T> hentries(String key) {
        if (StringUtils.isBlank(key)) {
            return Maps.newHashMap();
        }
        HashOperations<String, String, T> hashOperations = redisTemplate.opsForHash();
        Map<String, T> hvalues = hashOperations.entries(key);
        return hvalues;
    }

    /**
     * 删除某个hashkey
     *
     * @param key
     * @param hashKey 2017年9月13日 zhaowg
     */
    public <T> void hDelete(String key, String hashKey) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(hashKey)) {
            return;
        }
        HashOperations<String, String, T> hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key, hashKey);
    }

    

    /**
     * 原子递增或者递减
     *
     * @param key     redis中的key值
     * @param hashKey redis hash结构中的key值
     * @param incrVal 递增或者递减的值，如果递减传负数
     * @return 递增或者递减后的值
     * @Author: atao
     * @Date: 2018/4/10 下午4:02
     */
    public Long hincrby(String key, String hashKey, Long incrVal) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(hashKey)) {
            return null;
        }
        Long val = redisTemplate.opsForHash().increment(key,hashKey,incrVal);
        return val;
    }

    /**
     * redis 消息队列 不使用了，改为RocketMQ了
     * @param channel
     * @param message
     */
	/*public void convertAndSend(String channel,Object message){
		if(StringUtils.isBlank(channel)){
			return;
		}
		redisTemplate.convertAndSend(channel, message);
	}*/






    /**
     * 支付时锁定订单5秒，在5秒内不允许对同一个订单发起多次支付
     * @param orderId
     */
    public void checkPayLock(String orderId){
        this._checkLock(orderId,TimeConstants.ORDER_LOOK_SECOND_FOR_PAYING,"请勿重复发起支付");
    }
    public void checkPayLock(String orderId,Long timeOutSecond){
        this._checkLock(orderId,timeOutSecond,"请勿重复发起支付");
    }

    public void checkBatchOutLock(String parkAreaCode){
        this._checkLock(parkAreaCode,TimeConstants.ORDER_LOOK_SECOND_FOR_PAYING,"请勿重复发起批量出场");
    }

    String  _LOOK = "_LOOK";

    /**
     * @author wangbiao
     * @date 2018/11/27 21:22
     * @param secondLock 锁定秒数
     * @return boolean
     */
    private void _checkLock(String key,long secondLock,String errMsg) {
        logger.info("锁定key:"+key+",锁定秒数："+secondLock);
        String _key = key+_LOOK;
        long  endTime= System.currentTimeMillis() + secondLock*1000;
        Long currentValue = (Long) redisTemplate.opsForValue().get(_key);
        if (currentValue !=null && System.currentTimeMillis() < currentValue) {
            throw new BizException(ErrorType.REPEAT_OPERATE,secondLock+"秒内，"+errMsg,false);
        }else {
            Boolean locked = redisTemplate.opsForValue().setIfAbsent(_key, endTime);
            if (locked) {
                redisTemplate.expire(_key, secondLock, TimeUnit.SECONDS);
            }else{
                throw new BizException(ErrorType.REPEAT_OPERATE,secondLock+"秒内，"+errMsg,false);
            }
        }
    }

    /**
     *解锁
     * @author wangbiao
     * @date 2018/11/27 21:22
     * @return void
     */
    public void unlock(String key) {
        String redisKey = key+_LOOK;
        String currentValue = redisTemplate.opsForValue().get(redisKey)+"";
        if (!StringUtils.isEmpty(currentValue)) {
            redisTemplate.opsForValue().getOperations().delete(redisKey);
        }
    }
}
