package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysDict;
import com.zxcv.api.commom.service.sys.dto.SysDictDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysDictReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysDictReq;

/**
 * 系统字典表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysDictDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
public interface SysDictDao {
    /**
     * 新增系统字典表
     * @param req
     * @author: zxcv
     * @since 2020-04-04
     * @return
     */
    Integer  saveSysDict(SaveAndModifySysDictReq req);

    /**
     * 修改系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    Integer  updateSysDictById(SaveAndModifySysDictReq req);

    /**
     * 删除系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    Integer  deleteSysDict(SaveAndModifySysDictReq req);

    /**
     * 查询系统字典表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    SysDict  selectSysDict(QuerySysDictReq req);


    /**
     * 分页-查询系统字典表列表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
   IPage<SysDict>  querySysDictForPage(QuerySysDictReq req);
}
