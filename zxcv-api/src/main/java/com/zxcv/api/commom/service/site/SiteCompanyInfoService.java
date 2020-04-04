package com.zxcv.api.commom.service.site;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.dto.SiteCompanyInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteCompanyInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteCompanyInfoReq;

/**
 * 分公司表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteCompanyInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
public interface SiteCompanyInfoService {
    /**
     * 新增分公司表
     * @param req
     * @author: zxcv
     * @since 2020-04-04
     * @return
     */
    BizResult<Integer>  saveSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req);

    /**
     * 修改分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<Integer>  updateSiteCompanyInfoById(SaveAndModifySiteCompanyInfoReq req);

    /**
     * 删除分公司表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req);

    /**
     * 查询分公司表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<SiteCompanyInfoDTO>  selectSiteCompanyInfo(QuerySiteCompanyInfoReq req);


    /**
     * 分页-查询分公司表列表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<PageBean<SiteCompanyInfoDTO>>  querySiteCompanyInfoForPage(QuerySiteCompanyInfoReq req);
}
