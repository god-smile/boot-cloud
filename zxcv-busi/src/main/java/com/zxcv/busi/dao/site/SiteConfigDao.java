package com.zxcv.busi.dao.site;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.site.SiteConfig;
import com.zxcv.api.commom.service.site.dto.SiteConfigDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteConfigReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteConfigReq;

/**
 * 用户配置表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteConfigDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
public interface SiteConfigDao {
    /**
     * 新增用户配置表
     * @param req
     * @author: zxcv
     * @since 2020-04-04
     * @return
     */
    Integer  saveSiteConfig(SaveAndModifySiteConfigReq req);

    /**
     * 修改用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    Integer  updateSiteConfigById(SaveAndModifySiteConfigReq req);

    /**
     * 删除用户配置表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    Integer  deleteSiteConfig(SaveAndModifySiteConfigReq req);

    /**
     * 查询用户配置表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    SiteConfig  selectSiteConfig(QuerySiteConfigReq req);


    /**
     * 分页-查询用户配置表列表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
   IPage<SiteConfig>  querySiteConfigForPage(QuerySiteConfigReq req);
}
