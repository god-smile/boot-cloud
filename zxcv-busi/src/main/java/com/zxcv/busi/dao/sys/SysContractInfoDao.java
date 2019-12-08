package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysContractInfo;
import com.zxcv.api.commom.service.sys.dto.SysContractInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysContractInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysContractInfoReq;

/**
 * 用户合同信息表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysContractInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysContractInfoDao {
    /**
     * 新增用户合同信息表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSysContractInfo(SaveAndModifySysContractInfoReq req);

    /**
     * 修改用户合同信息表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSysContractInfoById(SaveAndModifySysContractInfoReq req);

    /**
     * 删除用户合同信息表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSysContractInfo(SaveAndModifySysContractInfoReq req);

    /**
     * 查询用户合同信息表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SysContractInfo  selectSysContractInfo(QuerySysContractInfoReq req);


    /**
     * 分页-查询用户合同信息表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SysContractInfo>  querySysContractInfoForPage(QuerySysContractInfoReq req);
}
