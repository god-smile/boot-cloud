package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.SysAttachmentInfo;
import com.zxcv.busi.dao.sys.SysAttachmentInfoDao;
import com.zxcv.api.commom.service.sys.SysAttachmentInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysAttachmentInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysAttachmentInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysAttachmentInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 合同附件信息表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysAttachmentInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysAttachmentInfoServiceImpl")
public class SysAttachmentInfoServiceImpl  implements SysAttachmentInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SysAttachmentInfoServiceImpl.class);

    @Autowired
    private SysAttachmentInfoDao sysAttachmentInfoDao;

     /**
      * 新增合同附件信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysAttachmentInfo(SaveAndModifySysAttachmentInfoReq req) {
         logger.info("begin调用合同附件信息表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysAttachmentInfoDao.saveSysAttachmentInfo(req);
         logger.info("end调用合同附件信息表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改合同附件信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysAttachmentInfoById(SaveAndModifySysAttachmentInfoReq req) {
         logger.info("begin调用合同附件信息表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysAttachmentInfoDao.updateSysAttachmentInfoById(req);
         logger.info("end调用合同附件信息表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除合同附件信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysAttachmentInfo(SaveAndModifySysAttachmentInfoReq req) {
         logger.info("begin调用合同附件信息表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysAttachmentInfoDao.deleteSysAttachmentInfo(req);
         logger.info("end调用合同附件信息表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询合同附件信息表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysAttachmentInfoDTO> selectSysAttachmentInfo(QuerySysAttachmentInfoReq req) {
         logger.info("begin调用合同附件信息表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysAttachmentInfoDTO sysAttachmentInfoDTO = new SysAttachmentInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysAttachmentInfo obj = sysAttachmentInfoDao. selectSysAttachmentInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysAttachmentInfoDTO);
         }
         logger.info("end调用合同附件信息表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysAttachmentInfoDTO));
         return new BizResult<SysAttachmentInfoDTO>(sysAttachmentInfoDTO);
     }

     /**
      * 分页-查询合同附件信息表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysAttachmentInfoDTO>> querySysAttachmentInfoForPage(QuerySysAttachmentInfoReq req) {
         logger.info("begin调用service层分页-查询合同附件信息表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysAttachmentInfoDTO> pageBean = new PageBean<SysAttachmentInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysAttachmentInfo> pageInfo = sysAttachmentInfoDao.querySysAttachmentInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysAttachmentInfoDTO.class);
         }
         logger.info("end调用service-查询合同附件信息表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysAttachmentInfoDTO>>(pageBean);
     }
}
