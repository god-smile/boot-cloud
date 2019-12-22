package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.SysProjectInfo;
import com.zxcv.busi.mapper.sys.SysProjectInfoMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysProjectInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 项目表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysProjectInfoDaoImpl.java
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
public class SysProjectInfoDaoImpl  implements SysProjectInfoDao {


    @Autowired
    private SysProjectInfoMapper sysProjectInfoMapper;

     /**
      * 新增项目表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer saveSysProjectInfo(SaveAndModifySysProjectInfoReq req) {
         SysProjectInfo sysProjectInfo = new SysProjectInfo();
         BeanUtils.copyProperties(req, sysProjectInfo);
         int insertCount = sysProjectInfoMapper.insert(sysProjectInfo);
         return insertCount;
     }

     /**
      * 修改项目表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer updateSysProjectInfoById(SaveAndModifySysProjectInfoReq req) {
         SysProjectInfo sysProjectInfo = new SysProjectInfo();
         BeanUtils.copyProperties(req, sysProjectInfo);
         int updateCount = sysProjectInfoMapper.updateById(sysProjectInfo);
         return updateCount;
     }

     /**
      * 删除项目表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer deleteSysProjectInfo(SaveAndModifySysProjectInfoReq req) {
         SysProjectInfo sysProjectInfo = new SysProjectInfo();
         BeanUtils.copyProperties(req, sysProjectInfo);
         UpdateWrapper<SysProjectInfo> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SysProjectInfo::getId, req.getIds());
         updateWrapper.lambda().set(SysProjectInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SysProjectInfo::getModifyEmpId, req.getModifyEmpId())
         .set(SysProjectInfo::getModifyEmpName, req.getModifyEmpName())
         .set(SysProjectInfo::getModifyTime, req.getModifyTime());
		 int deleteCount = sysProjectInfoMapper.update(sysProjectInfo, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询项目表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public SysProjectInfo selectSysProjectInfo(QuerySysProjectInfoReq req) {
         SysProjectInfo sysProjectInfoQuery = new SysProjectInfo();
         BeanUtils.copyProperties(req, sysProjectInfoQuery);
         QueryWrapper<SysProjectInfo> querySQL = new QueryWrapper<SysProjectInfo>();
         querySQL.setEntity(sysProjectInfoQuery);
         SysProjectInfo obj = sysProjectInfoMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询项目表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public IPage<SysProjectInfo> querySysProjectInfoForPage(QuerySysProjectInfoReq req) {
         //1.设置分页
         Page<SysProjectInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SysProjectInfo> queryWrapper = new QueryWrapper<SysProjectInfo>();
         queryWrapper.lambda().eq(true, SysProjectInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SysProjectInfo::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SysProjectInfo::getId);
	     IPage<SysProjectInfo> pageInfo = sysProjectInfoMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }


    /**
     * 根据url，查询项目表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     *
     */
    @Override
    public SysProjectInfo getSysProjectInfoByUrl(QuerySysProjectInfoReq req) {
        SysProjectInfo sysProjectInfoQuery = new SysProjectInfo();
        BeanUtils.copyProperties(req, sysProjectInfoQuery);
        QueryWrapper<SysProjectInfo> querySQL = new QueryWrapper<SysProjectInfo>();
        querySQL.setEntity(sysProjectInfoQuery);
        SysProjectInfo obj = sysProjectInfoMapper.selectOne(querySQL);
        return obj;
    }
}
