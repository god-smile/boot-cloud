package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.TsOpDTO;
import com.zxcv.api.commom.service.sys.param.query.QueryTsOpReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTsOpReq;

/**
 * 操作员表(用户) Service服务类
 * Copyright: Copyright (c) ${year}
 *
 * @ClassName: TsOpService.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-06-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-06-04         wangfs         v1.0.0               创建
 */
public interface TsOpService {
    /**
     * 新增操作员表(用户)
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    BizResult<Long> saveTsOp(SaveAndModifyTsOpReq req);

    /**
     * 修改操作员表(用户)
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    BizResult<Integer> updateTsOpById(SaveAndModifyTsOpReq req);

    /**
     * 删除操作员表(用户)
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    BizResult<Integer> deleteTsOp(SaveAndModifyTsOpReq req);

    /**
     * 查询操作员表(用户)对象
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    BizResult<TsOpDTO> selectTsOp(QueryTsOpReq req);


    /**
     * 分页-查询操作员表(用户)列表
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    BizResult<PageBean<TsOpDTO>> queryTsOpForPage(QueryTsOpReq req);

    /**
     * 通过组织id校验组织是否已经被用户使用,使用则不容许删除
     *
     * @param req
     * @return
     */
    BizResult<Integer> checkOrgIdIsUsed(QueryTsOpReq req);
}
