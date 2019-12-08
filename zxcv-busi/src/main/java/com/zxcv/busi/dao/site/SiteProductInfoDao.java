package com.zxcv.busi.dao.site;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.site.SiteProductInfo;
import com.zxcv.api.commom.service.site.dto.SiteProductInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;

/**
 * 产品表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteProductInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SiteProductInfoDao {
    /**
     * 新增产品表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSiteProductInfo(SaveAndModifySiteProductInfoReq req);

    /**
     * 修改产品表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSiteProductInfoById(SaveAndModifySiteProductInfoReq req);

    /**
     * 删除产品表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSiteProductInfo(SaveAndModifySiteProductInfoReq req);

    /**
     * 查询产品表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SiteProductInfo  selectSiteProductInfo(QuerySiteProductInfoReq req);


    /**
     * 分页-查询产品表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SiteProductInfo>  querySiteProductInfoForPage(QuerySiteProductInfoReq req);
}
