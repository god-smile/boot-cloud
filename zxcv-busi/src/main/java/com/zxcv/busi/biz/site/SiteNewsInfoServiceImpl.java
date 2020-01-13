package com.zxcv.busi.biz.site;
import com.zxcv.busi.domain.site.SiteNewsInfo;
import com.zxcv.busi.dao.site.SiteNewsInfoDao;
import com.zxcv.api.commom.service.site.SiteNewsInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.site.dto.SiteNewsInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteNewsInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 新闻表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteNewsInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.site.SiteNewsInfoServiceImpl")
public class SiteNewsInfoServiceImpl  implements SiteNewsInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SiteNewsInfoServiceImpl.class);

    @Autowired
    private SiteNewsInfoDao siteNewsInfoDao;

     /**
      * 新增新闻表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSiteNewsInfo(SaveAndModifySiteNewsInfoReq req) {
         logger.info("begin调用新闻表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }

         // 用户添加 或 修改新闻以后，需要 根据 userNo 去 sys_project_info 表里查projectNo set 到该请求对象中

         int insertCount = siteNewsInfoDao.saveSiteNewsInfo(req);
         logger.info("end调用新闻表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改新闻表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSiteNewsInfoById(SaveAndModifySiteNewsInfoReq req) {
         logger.info("begin调用新闻表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = siteNewsInfoDao.updateSiteNewsInfoById(req);
         logger.info("end调用新闻表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除新闻表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSiteNewsInfo(SaveAndModifySiteNewsInfoReq req) {
         logger.info("begin调用新闻表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = siteNewsInfoDao.deleteSiteNewsInfo(req);
         logger.info("end调用新闻表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询新闻表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SiteNewsInfoDTO> selectSiteNewsInfo(QuerySiteNewsInfoReq req) {
         logger.info("begin调用新闻表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SiteNewsInfoDTO siteNewsInfoDTO = new SiteNewsInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SiteNewsInfo obj = siteNewsInfoDao. selectSiteNewsInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,siteNewsInfoDTO);
         }
         logger.info("end调用新闻表service层查询对象方法,结果=【{}】", JSONObject.toJSON(siteNewsInfoDTO));
         return new BizResult<SiteNewsInfoDTO>(siteNewsInfoDTO);
     }

     /**
      * 分页-查询新闻表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SiteNewsInfoDTO>> querySiteNewsInfoForPage(QuerySiteNewsInfoReq req) {
         logger.info("begin调用service层分页-查询新闻表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SiteNewsInfoDTO> pageBean = new PageBean<SiteNewsInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SiteNewsInfo> pageInfo = siteNewsInfoDao.querySiteNewsInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SiteNewsInfoDTO.class);
         }
         logger.info("end调用service-查询新闻表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SiteNewsInfoDTO>>(pageBean);
     }


    /**
     * 查询新闻表，增加阅读量
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    @Override
    public BizResult<SiteNewsInfoDTO> selectWebSiteNewsInfo(QuerySiteNewsInfoReq req) {
        logger.info("begin调用新闻表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        SiteNewsInfoDTO siteNewsInfoDTO = new SiteNewsInfoDTO();
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        SiteNewsInfo obj = siteNewsInfoDao. selectSiteNewsInfo(req);
        if (null != obj) {
            BeanUtils.copyProperties(obj,siteNewsInfoDTO);
        }

        // 阅读量加1
        SaveAndModifySiteNewsInfoReq saveAndModifySiteNewsInfoReq = new SaveAndModifySiteNewsInfoReq();
        saveAndModifySiteNewsInfoReq.setId(req.getId());
        saveAndModifySiteNewsInfoReq.setReadNum(obj.getReadNum()+1);

        int updateCount = siteNewsInfoDao.updateSiteNewsInfoById(saveAndModifySiteNewsInfoReq);

        if (updateCount <= 0) {
            throw new BizException(ErrorType.BIZ_FAILED, "未知异常!");
        }

        logger.info("end调用新闻表service层查询对象方法,结果=【{}】", JSONObject.toJSON(siteNewsInfoDTO));
        return new BizResult<SiteNewsInfoDTO>(siteNewsInfoDTO);
    }
}
