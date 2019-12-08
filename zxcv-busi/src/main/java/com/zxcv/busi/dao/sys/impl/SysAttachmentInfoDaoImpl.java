package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.SysAttachmentInfo;
import com.zxcv.busi.mapper.sys.SysAttachmentInfoMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysAttachmentInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.sys.param.query.QuerySysAttachmentInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysAttachmentInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 合同附件信息表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysAttachmentInfoDaoImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Component
public class SysAttachmentInfoDaoImpl  implements SysAttachmentInfoDao {


    @Autowired
    private SysAttachmentInfoMapper sysAttachmentInfoMapper;

     /**
      * 新增合同附件信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer saveSysAttachmentInfo(SaveAndModifySysAttachmentInfoReq req) {
         SysAttachmentInfo sysAttachmentInfo = new SysAttachmentInfo();
         BeanUtils.copyProperties(req, sysAttachmentInfo);
         int insertCount = sysAttachmentInfoMapper.insert(sysAttachmentInfo);
         return insertCount;
     }

     /**
      * 修改合同附件信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer updateSysAttachmentInfoById(SaveAndModifySysAttachmentInfoReq req) {
         SysAttachmentInfo sysAttachmentInfo = new SysAttachmentInfo();
         BeanUtils.copyProperties(req, sysAttachmentInfo);
         int updateCount = sysAttachmentInfoMapper.updateById(sysAttachmentInfo);
         return updateCount;
     }

     /**
      * 删除合同附件信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer deleteSysAttachmentInfo(SaveAndModifySysAttachmentInfoReq req) {
         SysAttachmentInfo sysAttachmentInfo = new SysAttachmentInfo();
         BeanUtils.copyProperties(req, sysAttachmentInfo);
         UpdateWrapper<SysAttachmentInfo> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SysAttachmentInfo::getId, req.getIds());
         updateWrapper.lambda().set(SysAttachmentInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SysAttachmentInfo::getModifyEmpId, req.getModifyEmpId())
         .set(SysAttachmentInfo::getModifyEmpName, req.getModifyEmpName())
         .set(SysAttachmentInfo::getModifyTime, req.getModifyTime());
		 int deleteCount = sysAttachmentInfoMapper.update(sysAttachmentInfo, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询合同附件信息表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public SysAttachmentInfo selectSysAttachmentInfo(QuerySysAttachmentInfoReq req) {
         SysAttachmentInfo sysAttachmentInfoQuery = new SysAttachmentInfo();
         BeanUtils.copyProperties(req, sysAttachmentInfoQuery);
         QueryWrapper<SysAttachmentInfo> querySQL = new QueryWrapper<SysAttachmentInfo>();
         querySQL.setEntity(sysAttachmentInfoQuery);
         SysAttachmentInfo obj = sysAttachmentInfoMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询合同附件信息表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public IPage<SysAttachmentInfo> querySysAttachmentInfoForPage(QuerySysAttachmentInfoReq req) {
         //1.设置分页
         Page<SysAttachmentInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SysAttachmentInfo> queryWrapper = new QueryWrapper<SysAttachmentInfo>();
         queryWrapper.lambda().eq(true, SysAttachmentInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SysAttachmentInfo::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SysAttachmentInfo::getId);
	     IPage<SysAttachmentInfo> pageInfo = sysAttachmentInfoMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
