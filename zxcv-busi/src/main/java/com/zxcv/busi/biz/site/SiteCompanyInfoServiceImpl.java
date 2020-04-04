package com.zxcv.busi.biz.site;
import com.zxcv.busi.domain.site.SiteCompanyInfo;
import com.zxcv.busi.dao.site.SiteCompanyInfoDao;
import com.zxcv.api.commom.service.site.SiteCompanyInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.site.dto.SiteCompanyInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteCompanyInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteCompanyInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分公司表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteCompanyInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.site.SiteCompanyInfoServiceImpl")
public class SiteCompanyInfoServiceImpl  implements SiteCompanyInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SiteCompanyInfoServiceImpl.class);

    @Autowired
    private SiteCompanyInfoDao siteCompanyInfoDao;

    /**
     * 新增分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> saveSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req) {
        logger.info("begin调用分公司表service层add()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int insertCount = siteCompanyInfoDao.saveSiteCompanyInfo(req);
        logger.info("end调用分公司表service层add()方法,插入条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 修改分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> updateSiteCompanyInfoById(SaveAndModifySiteCompanyInfoReq req) {
        logger.info("begin调用分公司表service层update()方法,入参={}", JSONObject.toJSON(req));
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int updateCount = siteCompanyInfoDao.updateSiteCompanyInfoById(req);
        logger.info("end调用分公司表service层update()方法,修改条数=【{}】条。", updateCount);
        return new BizResult<Integer>(updateCount);
    }

    /**
     * 删除分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> deleteSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req) {
        logger.info("begin调用分公司表service层delete()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        if (CollectionUtils.isEmpty(req.getIds())) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        int deleteCount = siteCompanyInfoDao.deleteSiteCompanyInfo(req);
        logger.info("end调用分公司表service层delete()方法,删除条数=【{}】条。", deleteCount);
        return new BizResult<Integer>(deleteCount);
    }

    /**
     * 查询分公司表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     *
     */
    @Override
    public BizResult<SiteCompanyInfoDTO> selectSiteCompanyInfo(QuerySiteCompanyInfoReq req) {
        logger.info("begin调用分公司表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        SiteCompanyInfoDTO siteCompanyInfoDTO = new SiteCompanyInfoDTO();
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        SiteCompanyInfo obj = siteCompanyInfoDao. selectSiteCompanyInfo(req);
        if (null != obj) {
            BeanUtils.copyProperties(obj,siteCompanyInfoDTO);
        }
        logger.info("end调用分公司表service层查询对象方法,结果=【{}】", JSONObject.toJSON(siteCompanyInfoDTO));
        return new BizResult<SiteCompanyInfoDTO>(siteCompanyInfoDTO);
    }

    /**
     * 分页-查询分公司表列表
     *
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<PageBean<SiteCompanyInfoDTO>> querySiteCompanyInfoForPage(QuerySiteCompanyInfoReq req) {
        logger.info("begin调用service层分页-查询分公司表列表()方法,入参={}", JSONObject.toJSON(req));
        PageBean<SiteCompanyInfoDTO> pageBean = new PageBean<SiteCompanyInfoDTO>();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        IPage<SiteCompanyInfo> pageInfo = siteCompanyInfoDao.querySiteCompanyInfoForPage(req);
        if (null != pageInfo) {
            PageBeanUtil.copyProperties(pageInfo, pageBean, SiteCompanyInfoDTO.class);
        }
        logger.info("end调用service-查询分公司表列表分页()方法,查询条数={}条。", pageBean.getTotal());
        return new BizResult<PageBean<SiteCompanyInfoDTO>>(pageBean);
    }
}
