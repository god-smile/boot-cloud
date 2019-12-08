package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.SysAttachmentInfo;
import com.zxcv.api.commom.service.sys.dto.SysAttachmentInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysAttachmentInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysAttachmentInfoReq;

/**
 * 合同附件信息表 Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysAttachmentInfoDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
public interface SysAttachmentInfoDao {
    /**
     * 新增合同附件信息表
     * @param req
     * @author: zxcv
     * @since 2019-12-08
     * @return
     */
    Integer  saveSysAttachmentInfo(SaveAndModifySysAttachmentInfoReq req);

    /**
     * 修改合同附件信息表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  updateSysAttachmentInfoById(SaveAndModifySysAttachmentInfoReq req);

    /**
     * 删除合同附件信息表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    Integer  deleteSysAttachmentInfo(SaveAndModifySysAttachmentInfoReq req);

    /**
     * 查询合同附件信息表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    SysAttachmentInfo  selectSysAttachmentInfo(QuerySysAttachmentInfoReq req);


    /**
     * 分页-查询合同附件信息表列表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
   IPage<SysAttachmentInfo>  querySysAttachmentInfoForPage(QuerySysAttachmentInfoReq req);
}
