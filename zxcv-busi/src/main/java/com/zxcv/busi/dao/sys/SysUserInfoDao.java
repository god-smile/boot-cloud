package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysUserInfo;
import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;

/**
 * 用户表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysUserInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysUserInfoDao {
    /**
     * 新增用户表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSysUserInfo(SaveAndModifySysUserInfoReq req);

    /**
     * 修改用户表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSysUserInfoById(SaveAndModifySysUserInfoReq req);

    /**
     * 删除用户表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSysUserInfo(SaveAndModifySysUserInfoReq req);

    /**
     * 查询用户表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SysUserInfo  selectSysUserInfo(QuerySysUserInfoReq req);


    /**
     * 分页-查询用户表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SysUserInfo>  querySysUserInfoForPage(QuerySysUserInfoReq req);
}
