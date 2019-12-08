package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysProjectInfo;
import com.zxcv.api.commom.service.sys.dto.SysProjectInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectInfoReq;

/**
 * 项目表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysProjectInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysProjectInfoDao {
    /**
     * 新增项目表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSysProjectInfo(SaveAndModifySysProjectInfoReq req);

    /**
     * 修改项目表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSysProjectInfoById(SaveAndModifySysProjectInfoReq req);

    /**
     * 删除项目表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSysProjectInfo(SaveAndModifySysProjectInfoReq req);

    /**
     * 查询项目表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SysProjectInfo  selectSysProjectInfo(QuerySysProjectInfoReq req);


    /**
     * 分页-查询项目表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SysProjectInfo>  querySysProjectInfoForPage(QuerySysProjectInfoReq req);
}
