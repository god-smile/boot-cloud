package com.zxcv.busi.biz.site;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.site.SiteVisitLogService;
import com.zxcv.api.commom.service.site.dto.SiteVisitLogDTO;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteVisitLogReq;
import com.zxcv.api.commom.service.site.param.query.QuerySiteVisitLogReq;
import com.zxcv.busi.dao.site.SiteVisitLogDao;
import com.zxcv.busi.domain.site.SiteVisitLog;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 访问记录日志表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteVisitLogServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-01-22
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-01-22         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.site.SiteVisitLogServiceImpl")
public class SiteVisitLogServiceImpl  implements SiteVisitLogService {

    private static final Logger logger = LoggerFactory.getLogger(SiteVisitLogServiceImpl.class);

    @Autowired
    private SiteVisitLogDao siteVisitLogDao;

    /**
     * 新增访问记录日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> saveSiteVisitLog(SaveAndModifySiteVisitLogReq req) {
        logger.info("begin调用访问记录日志表service层add()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int insertCount = siteVisitLogDao.saveSiteVisitLog(req);
        logger.info("end调用访问记录日志表service层add()方法,插入条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

     /**
      * 修改访问记录日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSiteVisitLogById(SaveAndModifySiteVisitLogReq req) {
         logger.info("begin调用访问记录日志表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = siteVisitLogDao.updateSiteVisitLogById(req);
         logger.info("end调用访问记录日志表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除访问记录日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSiteVisitLog(SaveAndModifySiteVisitLogReq req) {
         logger.info("begin调用访问记录日志表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = siteVisitLogDao.deleteSiteVisitLog(req);
         logger.info("end调用访问记录日志表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询访问记录日志表对象
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SiteVisitLogDTO> selectSiteVisitLog(QuerySiteVisitLogReq req) {
         logger.info("begin调用访问记录日志表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SiteVisitLogDTO siteVisitLogDTO = new SiteVisitLogDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SiteVisitLog obj = siteVisitLogDao. selectSiteVisitLog(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,siteVisitLogDTO);
         }
         logger.info("end调用访问记录日志表service层查询对象方法,结果=【{}】", JSONObject.toJSON(siteVisitLogDTO));
         return new BizResult<SiteVisitLogDTO>(siteVisitLogDTO);
     }

     /**
      * 分页-查询访问记录日志表列表
      *
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SiteVisitLogDTO>> querySiteVisitLogForPage(QuerySiteVisitLogReq req) {
         logger.info("begin调用service层分页-查询访问记录日志表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SiteVisitLogDTO> pageBean = new PageBean<SiteVisitLogDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SiteVisitLog> pageInfo = siteVisitLogDao.querySiteVisitLogForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SiteVisitLogDTO.class);
         }
         logger.info("end调用service-查询访问记录日志表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SiteVisitLogDTO>>(pageBean);
     }
}
