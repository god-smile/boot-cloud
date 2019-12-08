package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysProjectItem;
import com.zxcv.api.commom.service.sys.dto.SysProjectItemDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectItemReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectItemReq;

/**
 * 项目类别 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysProjectItemDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysProjectItemDao {
    /**
     * 新增项目类别
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSysProjectItem(SaveAndModifySysProjectItemReq req);

    /**
     * 修改项目类别
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSysProjectItemById(SaveAndModifySysProjectItemReq req);

    /**
     * 删除项目类别
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSysProjectItem(SaveAndModifySysProjectItemReq req);

    /**
     * 查询项目类别对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SysProjectItem  selectSysProjectItem(QuerySysProjectItemReq req);


    /**
     * 分页-查询项目类别列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SysProjectItem>  querySysProjectItemForPage(QuerySysProjectItemReq req);
}
