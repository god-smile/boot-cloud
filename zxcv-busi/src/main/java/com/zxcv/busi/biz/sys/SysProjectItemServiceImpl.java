package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.SysProjectItem;
import com.zxcv.busi.dao.sys.SysProjectItemDao;
import com.zxcv.api.commom.service.sys.SysProjectItemService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysProjectItemDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectItemReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectItemReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 项目类别 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysProjectItemServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysProjectItemServiceImpl")
public class SysProjectItemServiceImpl  implements SysProjectItemService {

    private static final Logger logger = LoggerFactory.getLogger(SysProjectItemServiceImpl.class);

    @Autowired
    private SysProjectItemDao sysProjectItemDao;

     /**
      * 新增项目类别
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysProjectItem(SaveAndModifySysProjectItemReq req) {
         logger.info("begin调用项目类别service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysProjectItemDao.saveSysProjectItem(req);
         logger.info("end调用项目类别service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改项目类别
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysProjectItemById(SaveAndModifySysProjectItemReq req) {
         logger.info("begin调用项目类别service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysProjectItemDao.updateSysProjectItemById(req);
         logger.info("end调用项目类别service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除项目类别
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysProjectItem(SaveAndModifySysProjectItemReq req) {
         logger.info("begin调用项目类别service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysProjectItemDao.deleteSysProjectItem(req);
         logger.info("end调用项目类别service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询项目类别对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysProjectItemDTO> selectSysProjectItem(QuerySysProjectItemReq req) {
         logger.info("begin调用项目类别service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysProjectItemDTO sysProjectItemDTO = new SysProjectItemDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysProjectItem obj = sysProjectItemDao. selectSysProjectItem(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysProjectItemDTO);
         }
         logger.info("end调用项目类别service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysProjectItemDTO));
         return new BizResult<SysProjectItemDTO>(sysProjectItemDTO);
     }

     /**
      * 分页-查询项目类别列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysProjectItemDTO>> querySysProjectItemForPage(QuerySysProjectItemReq req) {
         logger.info("begin调用service层分页-查询项目类别列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysProjectItemDTO> pageBean = new PageBean<SysProjectItemDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysProjectItem> pageInfo = sysProjectItemDao.querySysProjectItemForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysProjectItemDTO.class);
         }
         logger.info("end调用service-查询项目类别列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysProjectItemDTO>>(pageBean);
     }
}
