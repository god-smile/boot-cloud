package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.UserInfoDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyUserInfoReq;
import com.zxcv.api.commom.service.sys.param.query.QueryUserInfoReq;

/**
 * 操作员表(用户) Service服务类
 * Copyright: Copyright (c) ${year}
 *
 * @ClassName: UserInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: lh
 * @date: 2019-10-14
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-14         lh         v1.0.0               创建
 */
public interface UserInfoService
{
    /**
     * 新增操作员表(用户)
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    BizResult<Long> saveUserInfo(SaveAndModifyUserInfoReq req);

    /**
     * 修改操作员表(用户)
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    BizResult<Integer> updateUserInfoById(SaveAndModifyUserInfoReq req);

    /**
     * 删除操作员表(用户)
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    BizResult<Integer> deleteUserInfo(SaveAndModifyUserInfoReq req);

    /**
     * 查询操作员表(用户)对象
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    BizResult<UserInfoDTO> selectUserInfo(QueryUserInfoReq req);


    /**
     * 分页-查询操作员表(用户)列表
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    BizResult<PageBean<UserInfoDTO>> queryUserInfoForPage(QueryUserInfoReq req);

    /**
     * 通过组织id校验组织是否已经被用户使用,使用则不容许删除
     *
     * @param req
     * @return
     */
    // BizResult<Integer> checkOrgIdIsUsed(QueryUserInfoReq req);
}
