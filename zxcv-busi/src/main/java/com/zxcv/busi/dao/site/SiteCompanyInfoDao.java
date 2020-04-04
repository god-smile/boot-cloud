package com.zxcv.busi.dao.site;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.site.SiteCompanyInfo;
import com.zxcv.api.commom.service.site.dto.SiteCompanyInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteCompanyInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteCompanyInfoReq;

/**
 * 分公司表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteCompanyInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
public interface SiteCompanyInfoDao {
    /**
     * 新增分公司表
     * @param req
     * @author: zxcv
     * @since 2020-04-04
     * @return
     */
    Integer  saveSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req);

    /**
     * 修改分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    Integer  updateSiteCompanyInfoById(SaveAndModifySiteCompanyInfoReq req);

    /**
     * 删除分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    Integer  deleteSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req);

    /**
     * 查询分公司表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    SiteCompanyInfo  selectSiteCompanyInfo(QuerySiteCompanyInfoReq req);


    /**
     * 分页-查询分公司表列表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
   IPage<SiteCompanyInfo>  querySiteCompanyInfoForPage(QuerySiteCompanyInfoReq req);
}
