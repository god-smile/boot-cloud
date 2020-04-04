package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.SysDict;
import com.zxcv.busi.mapper.sys.SysDictMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysDictDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import com.zxcv.api.commom.service.sys.param.query.QuerySysDictReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysDictReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统字典表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysDictDaoImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
@Component
public class SysDictDaoImpl  implements SysDictDao {


    @Autowired
    private SysDictMapper sysDictMapper;

     /**
      * 新增系统字典表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer saveSysDict(SaveAndModifySysDictReq req) {
         SysDict sysDict = new SysDict();
         BeanUtils.copyProperties(req, sysDict);
         sysDict.setCreateTime(new Date());
         int insertCount = sysDictMapper.insert(sysDict);
         return insertCount;
     }

     /**
      * 修改系统字典表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer updateSysDictById(SaveAndModifySysDictReq req) {
         SysDict sysDict = new SysDict();
         BeanUtils.copyProperties(req, sysDict);
         sysDict.setModifyTime(new Date());
         int updateCount = sysDictMapper.updateById(sysDict);
         return updateCount;
     }

     /**
      * 删除系统字典表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer deleteSysDict(SaveAndModifySysDictReq req) {
         SysDict sysDict = new SysDict();
         BeanUtils.copyProperties(req, sysDict);
         UpdateWrapper<SysDict> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SysDict::getId, req.getIds());
         updateWrapper.lambda().set(SysDict::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SysDict::getModifyEmpId, req.getModifyEmpId())
         .set(SysDict::getModifyEmpName, req.getModifyEmpName())
         .set(SysDict::getModifyTime, new Date());
		 int deleteCount = sysDictMapper.update(sysDict, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询系统字典表对象
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      *
      */
     @Override
     public SysDict selectSysDict(QuerySysDictReq req) {
         SysDict sysDictQuery = new SysDict();
         BeanUtils.copyProperties(req, sysDictQuery);
         QueryWrapper<SysDict> querySQL = new QueryWrapper<SysDict>();
         querySQL.setEntity(sysDictQuery);
         SysDict obj = sysDictMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询系统字典表列表
      *
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public IPage<SysDict> querySysDictForPage(QuerySysDictReq req) {
         //1.设置分页
         Page<SysDict> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SysDict> queryWrapper = new QueryWrapper<SysDict>();
         queryWrapper.lambda().eq(true, SysDict::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SysDict::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SysDict::getId);
	     IPage<SysDict> pageInfo = sysDictMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
