package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.SysOpLog;
import com.zxcv.busi.dao.sys.SysOpLogDao;
import com.zxcv.api.commom.service.sys.SysOpLogService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysOpLogDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysOpLogReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysOpLogReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录/操作日志表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysOpLogServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-01-22
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-01-22         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysOpLogServiceImpl")
public class SysOpLogServiceImpl  implements SysOpLogService {

    private static final Logger logger = LoggerFactory.getLogger(SysOpLogServiceImpl.class);

    @Autowired
    private SysOpLogDao sysOpLogDao;

     /**
      * 新增登录/操作日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysOpLog(SaveAndModifySysOpLogReq req) {
         logger.info("begin调用登录/操作日志表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysOpLogDao.saveSysOpLog(req);
         logger.info("end调用登录/操作日志表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改登录/操作日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysOpLogById(SaveAndModifySysOpLogReq req) {
         logger.info("begin调用登录/操作日志表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysOpLogDao.updateSysOpLogById(req);
         logger.info("end调用登录/操作日志表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除登录/操作日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysOpLog(SaveAndModifySysOpLogReq req) {
         logger.info("begin调用登录/操作日志表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysOpLogDao.deleteSysOpLog(req);
         logger.info("end调用登录/操作日志表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询登录/操作日志表对象
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysOpLogDTO> selectSysOpLog(QuerySysOpLogReq req) {
         logger.info("begin调用登录/操作日志表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysOpLogDTO sysOpLogDTO = new SysOpLogDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysOpLog obj = sysOpLogDao. selectSysOpLog(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysOpLogDTO);
         }
         logger.info("end调用登录/操作日志表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysOpLogDTO));
         return new BizResult<SysOpLogDTO>(sysOpLogDTO);
     }

     /**
      * 分页-查询登录/操作日志表列表
      *
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysOpLogDTO>> querySysOpLogForPage(QuerySysOpLogReq req) {
         logger.info("begin调用service层分页-查询登录/操作日志表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysOpLogDTO> pageBean = new PageBean<SysOpLogDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysOpLog> pageInfo = sysOpLogDao.querySysOpLogForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysOpLogDTO.class);
         }
         logger.info("end调用service-查询登录/操作日志表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysOpLogDTO>>(pageBean);
     }
}
