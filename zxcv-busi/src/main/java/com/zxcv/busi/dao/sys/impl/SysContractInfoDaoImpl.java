package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.SysContractInfo;
import com.zxcv.busi.mapper.sys.SysContractInfoMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysContractInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.sys.param.query.QuerySysContractInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysContractInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户合同信息表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysContractInfoDaoImpl.java
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
public class SysContractInfoDaoImpl  implements SysContractInfoDao {


    @Autowired
    private SysContractInfoMapper sysContractInfoMapper;

     /**
      * 新增用户合同信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer saveSysContractInfo(SaveAndModifySysContractInfoReq req) {
         SysContractInfo sysContractInfo = new SysContractInfo();
         BeanUtils.copyProperties(req, sysContractInfo);
         int insertCount = sysContractInfoMapper.insert(sysContractInfo);
         return insertCount;
     }

     /**
      * 修改用户合同信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer updateSysContractInfoById(SaveAndModifySysContractInfoReq req) {
         SysContractInfo sysContractInfo = new SysContractInfo();
         BeanUtils.copyProperties(req, sysContractInfo);
         int updateCount = sysContractInfoMapper.updateById(sysContractInfo);
         return updateCount;
     }

     /**
      * 删除用户合同信息表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer deleteSysContractInfo(SaveAndModifySysContractInfoReq req) {
         SysContractInfo sysContractInfo = new SysContractInfo();
         BeanUtils.copyProperties(req, sysContractInfo);
         UpdateWrapper<SysContractInfo> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SysContractInfo::getId, req.getIds());
         updateWrapper.lambda().set(SysContractInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SysContractInfo::getModifyEmpId, req.getModifyEmpId())
         .set(SysContractInfo::getModifyEmpName, req.getModifyEmpName())
         .set(SysContractInfo::getModifyTime, req.getModifyTime());
		 int deleteCount = sysContractInfoMapper.update(sysContractInfo, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询用户合同信息表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public SysContractInfo selectSysContractInfo(QuerySysContractInfoReq req) {
         SysContractInfo sysContractInfoQuery = new SysContractInfo();
         BeanUtils.copyProperties(req, sysContractInfoQuery);
         QueryWrapper<SysContractInfo> querySQL = new QueryWrapper<SysContractInfo>();
         querySQL.setEntity(sysContractInfoQuery);
         SysContractInfo obj = sysContractInfoMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询用户合同信息表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public IPage<SysContractInfo> querySysContractInfoForPage(QuerySysContractInfoReq req) {
         //1.设置分页
         Page<SysContractInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SysContractInfo> queryWrapper = new QueryWrapper<SysContractInfo>();
         queryWrapper.lambda().eq(true, SysContractInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SysContractInfo::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SysContractInfo::getId);
	     IPage<SysContractInfo> pageInfo = sysContractInfoMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
