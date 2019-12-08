package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.SysUserInfo;
import com.zxcv.busi.dao.sys.SysUserInfoDao;
import com.zxcv.api.commom.service.sys.SysUserInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysUserInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysUserInfoServiceImpl")
public class SysUserInfoServiceImpl  implements SysUserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserInfoServiceImpl.class);

    @Autowired
    private SysUserInfoDao sysUserInfoDao;

     /**
      * 新增用户表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysUserInfo(SaveAndModifySysUserInfoReq req) {
         logger.info("begin调用用户表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysUserInfoDao.saveSysUserInfo(req);
         logger.info("end调用用户表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改用户表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysUserInfoById(SaveAndModifySysUserInfoReq req) {
         logger.info("begin调用用户表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysUserInfoDao.updateSysUserInfoById(req);
         logger.info("end调用用户表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除用户表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysUserInfo(SaveAndModifySysUserInfoReq req) {
         logger.info("begin调用用户表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysUserInfoDao.deleteSysUserInfo(req);
         logger.info("end调用用户表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询用户表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysUserInfoDTO> selectSysUserInfo(QuerySysUserInfoReq req) {
         logger.info("begin调用用户表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysUserInfoDTO sysUserInfoDTO = new SysUserInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysUserInfo obj = sysUserInfoDao. selectSysUserInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysUserInfoDTO);
         }
         logger.info("end调用用户表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysUserInfoDTO));
         return new BizResult<SysUserInfoDTO>(sysUserInfoDTO);
     }

     /**
      * 分页-查询用户表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysUserInfoDTO>> querySysUserInfoForPage(QuerySysUserInfoReq req) {
         logger.info("begin调用service层分页-查询用户表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysUserInfoDTO> pageBean = new PageBean<SysUserInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysUserInfo> pageInfo = sysUserInfoDao.querySysUserInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysUserInfoDTO.class);
         }
         logger.info("end调用service-查询用户表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysUserInfoDTO>>(pageBean);
     }
}
