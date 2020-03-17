package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysOpLog;
import com.zxcv.api.commom.service.sys.dto.SysOpLogDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysOpLogReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysOpLogReq;

/**
 * 登录/操作日志表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysOpLogDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-01-22
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-01-22         zxcv         v1.0.0               创建
 */
public interface SysOpLogDao {
    /**
     * 新增登录/操作日志表
     * @param req
     * @author: zxcv
     * @since 2020-01-22
     * @return
     */
    Integer  saveSysOpLog(SaveAndModifySysOpLogReq req);

    /**
     * 修改登录/操作日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    Integer  updateSysOpLogById(SaveAndModifySysOpLogReq req);

    /**
     * 删除登录/操作日志表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    Integer  deleteSysOpLog(SaveAndModifySysOpLogReq req);

    /**
     * 查询登录/操作日志表对象
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
    SysOpLog  selectSysOpLog(QuerySysOpLogReq req);


    /**
     * 分页-查询登录/操作日志表列表
     * @author: zxcv
     * @since 2020-01-22
     * @param req
     * @return
     */
   IPage<SysOpLog>  querySysOpLogForPage(QuerySysOpLogReq req);
}
