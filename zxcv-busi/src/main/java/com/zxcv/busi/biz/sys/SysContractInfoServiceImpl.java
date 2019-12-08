package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.SysContractInfo;
import com.zxcv.busi.dao.sys.SysContractInfoDao;
import com.zxcv.api.commom.service.sys.SysContractInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysContractInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysContractInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysContractInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户合同信息表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysContractInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysContractInfoServiceImpl")
public class SysContractInfoServiceImpl  implements SysContractInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SysContractInfoServiceImpl.class);

    @Autowired
    private SysContractInfoDao sysContractInfoDao;

     /**
      * 新增用户合同信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysContractInfo(SaveAndModifySysContractInfoReq req) {
         logger.info("begin调用用户合同信息表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysContractInfoDao.saveSysContractInfo(req);
         logger.info("end调用用户合同信息表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改用户合同信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysContractInfoById(SaveAndModifySysContractInfoReq req) {
         logger.info("begin调用用户合同信息表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysContractInfoDao.updateSysContractInfoById(req);
         logger.info("end调用用户合同信息表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除用户合同信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysContractInfo(SaveAndModifySysContractInfoReq req) {
         logger.info("begin调用用户合同信息表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysContractInfoDao.deleteSysContractInfo(req);
         logger.info("end调用用户合同信息表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询用户合同信息表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysContractInfoDTO> selectSysContractInfo(QuerySysContractInfoReq req) {
         logger.info("begin调用用户合同信息表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysContractInfoDTO sysContractInfoDTO = new SysContractInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysContractInfo obj = sysContractInfoDao. selectSysContractInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysContractInfoDTO);
         }
         logger.info("end调用用户合同信息表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysContractInfoDTO));
         return new BizResult<SysContractInfoDTO>(sysContractInfoDTO);
     }

     /**
      * 分页-查询用户合同信息表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysContractInfoDTO>> querySysContractInfoForPage(QuerySysContractInfoReq req) {
         logger.info("begin调用service层分页-查询用户合同信息表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysContractInfoDTO> pageBean = new PageBean<SysContractInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysContractInfo> pageInfo = sysContractInfoDao.querySysContractInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysContractInfoDTO.class);
         }
         logger.info("end调用service-查询用户合同信息表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysContractInfoDTO>>(pageBean);
     }
}
