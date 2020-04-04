package com.zxcv.busi.biz.site;
import com.zxcv.busi.domain.site.SiteConfig;
import com.zxcv.busi.dao.site.SiteConfigDao;
import com.zxcv.api.commom.service.site.SiteConfigService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.site.dto.SiteConfigDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteConfigReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteConfigReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户配置表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteConfigServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.site.SiteConfigServiceImpl")
public class SiteConfigServiceImpl  implements SiteConfigService {

    private static final Logger logger = LoggerFactory.getLogger(SiteConfigServiceImpl.class);

    @Autowired
    private SiteConfigDao siteConfigDao;

    /**
     * 新增用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> saveSiteConfig(SaveAndModifySiteConfigReq req) {
        logger.info("begin调用用户配置表service层add()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int insertCount = siteConfigDao.saveSiteConfig(req);
        logger.info("end调用用户配置表service层add()方法,插入条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 修改用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> updateSiteConfigById(SaveAndModifySiteConfigReq req) {
        logger.info("begin调用用户配置表service层update()方法,入参={}", JSONObject.toJSON(req));
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int updateCount = siteConfigDao.updateSiteConfigById(req);
        logger.info("end调用用户配置表service层update()方法,修改条数=【{}】条。", updateCount);
        return new BizResult<Integer>(updateCount);
    }

    /**
     * 删除用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> deleteSiteConfig(SaveAndModifySiteConfigReq req) {
        logger.info("begin调用用户配置表service层delete()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        if (CollectionUtils.isEmpty(req.getIds())) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        int deleteCount = siteConfigDao.deleteSiteConfig(req);
        logger.info("end调用用户配置表service层delete()方法,删除条数=【{}】条。", deleteCount);
        return new BizResult<Integer>(deleteCount);
    }

    /**
     * 查询用户配置表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     *
     */
    @Override
    public BizResult<SiteConfigDTO> selectSiteConfig(QuerySiteConfigReq req) {
        logger.info("begin调用用户配置表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        SiteConfigDTO siteConfigDTO = new SiteConfigDTO();
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        SiteConfig obj = siteConfigDao. selectSiteConfig(req);
        if (null != obj) {
            BeanUtils.copyProperties(obj,siteConfigDTO);
        }
        logger.info("end调用用户配置表service层查询对象方法,结果=【{}】", JSONObject.toJSON(siteConfigDTO));
        return new BizResult<SiteConfigDTO>(siteConfigDTO);
    }

    /**
     * 分页-查询用户配置表列表
     *
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<PageBean<SiteConfigDTO>> querySiteConfigForPage(QuerySiteConfigReq req) {
        logger.info("begin调用service层分页-查询用户配置表列表()方法,入参={}", JSONObject.toJSON(req));
        PageBean<SiteConfigDTO> pageBean = new PageBean<SiteConfigDTO>();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        IPage<SiteConfig> pageInfo = siteConfigDao.querySiteConfigForPage(req);
        if (null != pageInfo) {
            PageBeanUtil.copyProperties(pageInfo, pageBean, SiteConfigDTO.class);
        }
        logger.info("end调用service-查询用户配置表列表分页()方法,查询条数={}条。", pageBean.getTotal());
        return new BizResult<PageBean<SiteConfigDTO>>(pageBean);
    }
}
