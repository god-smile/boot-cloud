package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.SysOpLogDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysOpLogReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysOpLogReq;

/**
 * 登录/操作日志表 Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysOpLogService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-01-22
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-01-22         zxcv         v1.0.0               创建
 */
public interface SysOpLogService {
    /**
     * 新增登录/操作日志表
     * @param req
     * @author: zxcv
     * @since 2020-01-22
     * @return
     */
    BizResult<Integer>  saveSysOpLog(SaveAndModifySysOpLogReq req);

    /**
     * 修改登录/操作日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<Integer>  updateSysOpLogById(SaveAndModifySysOpLogReq req);

    /**
     * 删除登录/操作日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<Integer>  deleteSysOpLog(SaveAndModifySysOpLogReq req);

    /**
     * 查询登录/操作日志表对象
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<SysOpLogDTO>  selectSysOpLog(QuerySysOpLogReq req);


    /**
     * 分页-查询登录/操作日志表列表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    BizResult<PageBean<SysOpLogDTO>>  querySysOpLogForPage(QuerySysOpLogReq req);
}
