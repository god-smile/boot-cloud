package com.zxcv.api.commom.service.site;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.dto.SiteProductInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;

/**
 * 用户产品表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteProductInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-21
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-21         zxcv         v1.0.0               创建
 */
public interface SiteProductInfoService {
    /**
     * 新增用户产品表
     * @param req
     * @author: zxcv
     * @since 2019-12-21
     * @return
     */
    BizResult<Integer>  saveSiteProductInfo(SaveAndModifySiteProductInfoReq req);

    /**
     * 修改用户产品表
     * @author: zxcv
     * @since 2019-12-21
     * @param req
     * @return
     */
    BizResult<Integer>  updateSiteProductInfoById(SaveAndModifySiteProductInfoReq req);

    /**
     * 删除用户产品表
     * @author: zxcv
     * @since 2019-12-21
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSiteProductInfo(SaveAndModifySiteProductInfoReq req);

    /**
     * 查询用户产品表对象
     * @author: zxcv
     * @since 2019-12-21
     * @param req
     * @return
     */
    BizResult<SiteProductInfoDTO>  selectSiteProductInfo(QuerySiteProductInfoReq req);


    /**
     * 分页-查询用户产品表列表
     * @author: zxcv
     * @since 2019-12-21
     * @param req
     * @return
     */
    BizResult<PageBean<SiteProductInfoDTO>>  querySiteProductInfoForPage(QuerySiteProductInfoReq req);
}
