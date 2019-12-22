package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.SysProjectInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectInfoReq;

/**
 * 项目表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysProjectInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysProjectInfoService {
    /**
     * 新增项目表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    BizResult<Integer>  saveSysProjectInfo(SaveAndModifySysProjectInfoReq req);

    /**
     * 修改项目表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<Integer>  updateSysProjectInfoById(SaveAndModifySysProjectInfoReq req);

    /**
     * 删除项目表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSysProjectInfo(SaveAndModifySysProjectInfoReq req);

    /**
     * 查询项目表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<SysProjectInfoDTO>  selectSysProjectInfo(QuerySysProjectInfoReq req);


    /**
     * 分页-查询项目表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<PageBean<SysProjectInfoDTO>>  querySysProjectInfoForPage(QuerySysProjectInfoReq req);


    /**
     * 根据url，查询项目表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<SysProjectInfoDTO>  getSysProjectInfoByUrl(QuerySysProjectInfoReq req);
}
