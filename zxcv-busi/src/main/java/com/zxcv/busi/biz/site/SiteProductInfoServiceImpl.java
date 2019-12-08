package com.zxcv.busi.biz.site;
import com.zxcv.busi.domain.site.SiteProductInfo;
import com.zxcv.busi.dao.site.SiteProductInfoDao;
import com.zxcv.api.commom.service.site.SiteProductInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.site.dto.SiteProductInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 产品表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteProductInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.site.SiteProductInfoServiceImpl")
public class SiteProductInfoServiceImpl  implements SiteProductInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SiteProductInfoServiceImpl.class);

    @Autowired
    private SiteProductInfoDao siteProductInfoDao;

     /**
      * 新增产品表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSiteProductInfo(SaveAndModifySiteProductInfoReq req) {
         logger.info("begin调用产品表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = siteProductInfoDao.saveSiteProductInfo(req);
         logger.info("end调用产品表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改产品表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSiteProductInfoById(SaveAndModifySiteProductInfoReq req) {
         logger.info("begin调用产品表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = siteProductInfoDao.updateSiteProductInfoById(req);
         logger.info("end调用产品表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除产品表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSiteProductInfo(SaveAndModifySiteProductInfoReq req) {
         logger.info("begin调用产品表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = siteProductInfoDao.deleteSiteProductInfo(req);
         logger.info("end调用产品表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询产品表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SiteProductInfoDTO> selectSiteProductInfo(QuerySiteProductInfoReq req) {
         logger.info("begin调用产品表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SiteProductInfoDTO siteProductInfoDTO = new SiteProductInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SiteProductInfo obj = siteProductInfoDao. selectSiteProductInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,siteProductInfoDTO);
         }
         logger.info("end调用产品表service层查询对象方法,结果=【{}】", JSONObject.toJSON(siteProductInfoDTO));
         return new BizResult<SiteProductInfoDTO>(siteProductInfoDTO);
     }

     /**
      * 分页-查询产品表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SiteProductInfoDTO>> querySiteProductInfoForPage(QuerySiteProductInfoReq req) {
         logger.info("begin调用service层分页-查询产品表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SiteProductInfoDTO> pageBean = new PageBean<SiteProductInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SiteProductInfo> pageInfo = siteProductInfoDao.querySiteProductInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SiteProductInfoDTO.class);
         }
         logger.info("end调用service-查询产品表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SiteProductInfoDTO>>(pageBean);
     }
}
