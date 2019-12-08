package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.SysProjectItem;
import com.zxcv.busi.mapper.sys.SysProjectItemMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysProjectItemDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectItemReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectItemReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 项目类别 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysProjectItemDaoImpl.java
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
public class SysProjectItemDaoImpl  implements SysProjectItemDao {


    @Autowired
    private SysProjectItemMapper sysProjectItemMapper;

     /**
      * 新增项目类别
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer saveSysProjectItem(SaveAndModifySysProjectItemReq req) {
         SysProjectItem sysProjectItem = new SysProjectItem();
         BeanUtils.copyProperties(req, sysProjectItem);
         int insertCount = sysProjectItemMapper.insert(sysProjectItem);
         return insertCount;
     }

     /**
      * 修改项目类别
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer updateSysProjectItemById(SaveAndModifySysProjectItemReq req) {
         SysProjectItem sysProjectItem = new SysProjectItem();
         BeanUtils.copyProperties(req, sysProjectItem);
         int updateCount = sysProjectItemMapper.updateById(sysProjectItem);
         return updateCount;
     }

     /**
      * 删除项目类别
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public Integer deleteSysProjectItem(SaveAndModifySysProjectItemReq req) {
         SysProjectItem sysProjectItem = new SysProjectItem();
         BeanUtils.copyProperties(req, sysProjectItem);
         UpdateWrapper<SysProjectItem> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SysProjectItem::getId, req.getIds());
         updateWrapper.lambda().set(SysProjectItem::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SysProjectItem::getModifyEmpId, req.getModifyEmpId())
         .set(SysProjectItem::getModifyEmpName, req.getModifyEmpName())
         .set(SysProjectItem::getModifyTime, req.getModifyTime());
		 int deleteCount = sysProjectItemMapper.update(sysProjectItem, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询项目类别对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public SysProjectItem selectSysProjectItem(QuerySysProjectItemReq req) {
         SysProjectItem sysProjectItemQuery = new SysProjectItem();
         BeanUtils.copyProperties(req, sysProjectItemQuery);
         QueryWrapper<SysProjectItem> querySQL = new QueryWrapper<SysProjectItem>();
         querySQL.setEntity(sysProjectItemQuery);
         SysProjectItem obj = sysProjectItemMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询项目类别列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public IPage<SysProjectItem> querySysProjectItemForPage(QuerySysProjectItemReq req) {
         //1.设置分页
         Page<SysProjectItem> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SysProjectItem> queryWrapper = new QueryWrapper<SysProjectItem>();
         queryWrapper.lambda().eq(true, SysProjectItem::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SysProjectItem::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SysProjectItem::getId);
	     IPage<SysProjectItem> pageInfo = sysProjectItemMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
