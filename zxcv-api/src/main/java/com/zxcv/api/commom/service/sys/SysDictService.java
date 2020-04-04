package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.SysDictDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysDictReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysDictReq;

/**
 * 系统字典表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysDictService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
public interface SysDictService {
    /**
     * 新增系统字典表
     * @param req
     * @author: zxcv
     * @since 2020-04-04
     * @return
     */
    BizResult<Integer>  saveSysDict(SaveAndModifySysDictReq req);

    /**
     * 修改系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<Integer>  updateSysDictById(SaveAndModifySysDictReq req);

    /**
     * 删除系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSysDict(SaveAndModifySysDictReq req);

    /**
     * 查询系统字典表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<SysDictDTO>  selectSysDict(QuerySysDictReq req);


    /**
     * 分页-查询系统字典表列表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    BizResult<PageBean<SysDictDTO>>  querySysDictForPage(QuerySysDictReq req);
}
