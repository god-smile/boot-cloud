package com.zxcv.busi.dao.site;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.site.SiteNewsInfo;
import com.zxcv.api.commom.service.site.dto.SiteNewsInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteNewsInfoReq;

/**
 * 新闻表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteNewsInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SiteNewsInfoDao {
    /**
     * 新增新闻表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSiteNewsInfo(SaveAndModifySiteNewsInfoReq req);

    /**
     * 修改新闻表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSiteNewsInfoById(SaveAndModifySiteNewsInfoReq req);

    /**
     * 删除新闻表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSiteNewsInfo(SaveAndModifySiteNewsInfoReq req);

    /**
     * 查询新闻表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SiteNewsInfo  selectSiteNewsInfo(QuerySiteNewsInfoReq req);


    /**
     * 分页-查询新闻表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SiteNewsInfo>  querySiteNewsInfoForPage(QuerySiteNewsInfoReq req);
}
