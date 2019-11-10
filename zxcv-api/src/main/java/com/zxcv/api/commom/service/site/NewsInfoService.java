package com.zxcv.api.commom.service.site;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.dto.NewsInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QueryNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifyNewsInfoReq;

/**
 * 新闻表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: NewsInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-11-09
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-11-09         zxcv         v1.0.0               创建
 */
public interface NewsInfoService {
    /**
     * 新增新闻表
     * @param req
     * @author: zxcv
     * @since 2019-11-09
     * @return
     */
    BizResult<Integer>  saveNewsInfo(SaveAndModifyNewsInfoReq req);

    /**
     * 修改新闻表
     * @author: zxcv
     * @since 2019-11-09
     * @param req
     * @return
     */
    BizResult<Integer>  updateNewsInfoById(SaveAndModifyNewsInfoReq req);

    /**
     * 删除新闻表
     * @author: zxcv
     * @since 2019-11-09
     * @param req
     * @return
     */
    BizResult<Integer>  deleteNewsInfo(SaveAndModifyNewsInfoReq req);

    /**
     * 查询新闻表对象
     * @author: zxcv
     * @since 2019-11-09
     * @param req
     * @return
     */
    BizResult<NewsInfoDTO>  selectNewsInfo(QueryNewsInfoReq req);


    /**
     * 分页-查询新闻表列表
     * @author: zxcv
     * @since 2019-11-09
     * @param req
     * @return
     */
    BizResult<PageBean<NewsInfoDTO>>  queryNewsInfoForPage(QueryNewsInfoReq req);
}
