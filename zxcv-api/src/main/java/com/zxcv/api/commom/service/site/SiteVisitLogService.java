package com.zxcv.api.commom.service.site;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.dto.SiteVisitLogDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteVisitLogReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteVisitLogReq;

/**
 * 访问记录日志表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteVisitLogService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-01-22
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-01-22         zxcv         v1.0.0               创建
 */
public interface SiteVisitLogService {
    /**
     * 新增访问记录日志表
     * @param req
     * @author: zxcv
     * @since 2020-01-22
     * @return
     */
    BizResult<Integer>  saveSiteVisitLog(SaveAndModifySiteVisitLogReq req);

    /**
     * 修改访问记录日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<Integer>  updateSiteVisitLogById(SaveAndModifySiteVisitLogReq req);

    /**
     * 删除访问记录日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSiteVisitLog(SaveAndModifySiteVisitLogReq req);

    /**
     * 查询访问记录日志表对象
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<SiteVisitLogDTO>  selectSiteVisitLog(QuerySiteVisitLogReq req);


    /**
     * 分页-查询访问记录日志表列表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<PageBean<SiteVisitLogDTO>>  querySiteVisitLogForPage(QuerySiteVisitLogReq req);
}
