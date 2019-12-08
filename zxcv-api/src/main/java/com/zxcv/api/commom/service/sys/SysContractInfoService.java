package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.SysContractInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysContractInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysContractInfoReq;

/**
 * 用户合同信息表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysContractInfoService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysContractInfoService {
    /**
     * 新增用户合同信息表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    BizResult<Integer>  saveSysContractInfo(SaveAndModifySysContractInfoReq req);

    /**
     * 修改用户合同信息表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<Integer>  updateSysContractInfoById(SaveAndModifySysContractInfoReq req);

    /**
     * 删除用户合同信息表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSysContractInfo(SaveAndModifySysContractInfoReq req);

    /**
     * 查询用户合同信息表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<SysContractInfoDTO>  selectSysContractInfo(QuerySysContractInfoReq req);


    /**
     * 分页-查询用户合同信息表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    BizResult<PageBean<SysContractInfoDTO>>  querySysContractInfoForPage(QuerySysContractInfoReq req);
}
