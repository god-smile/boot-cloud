package com.zxcv.api.commom.service.site;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.dto.SiteConfigDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteConfigReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteConfigReq;

/**
 * 用户配置表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteConfigService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
public interface SiteConfigService {
    /**
     * 新增用户配置表
     * @param req
     * @author: zxcv
     * @since 2020-04-04
     * @return
     */
    BizResult<Integer>  saveSiteConfig(SaveAndModifySiteConfigReq req);

    /**
     * 修改用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<Integer>  updateSiteConfigById(SaveAndModifySiteConfigReq req);

    /**
     * 删除用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSiteConfig(SaveAndModifySiteConfigReq req);

    /**
     * 查询用户配置表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<SiteConfigDTO>  selectSiteConfig(QuerySiteConfigReq req);


    /**
     * 分页-查询用户配置表列表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<PageBean<SiteConfigDTO>>  querySiteConfigForPage(QuerySiteConfigReq req);
}
