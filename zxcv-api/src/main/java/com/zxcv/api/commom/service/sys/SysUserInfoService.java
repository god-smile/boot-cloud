package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;

/**
 * 用户表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysUserInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysUserInfoService {
    /**
     * 新增用户表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    BizResult<Integer>  saveSysUserInfo(SaveAndModifySysUserInfoReq req);

    /**
     * 修改用户表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<Integer>  updateSysUserInfoById(SaveAndModifySysUserInfoReq req);

    /**
     * 删除用户表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSysUserInfo(SaveAndModifySysUserInfoReq req);

    /**
     * 查询用户表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<SysUserInfoDTO>  selectSysUserInfo(QuerySysUserInfoReq req);


    /**
     * 分页-查询用户表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<PageBean<SysUserInfoDTO>>  querySysUserInfoForPage(QuerySysUserInfoReq req);
}
