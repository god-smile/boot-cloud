package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.SysOpLog;
import com.zxcv.busi.mapper.sys.SysOpLogMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysOpLogDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import com.zxcv.api.commom.service.sys.param.query.QuerySysOpLogReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysOpLogReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 登录/操作日志表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysOpLogDaoImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-01-22
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-01-22         zxcv         v1.0.0               创建
 */
@Component
public class SysOpLogDaoImpl  implements SysOpLogDao {


    @Autowired
    private SysOpLogMapper sysOpLogMapper;

     /**
      * 新增登录/操作日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public Integer saveSysOpLog(SaveAndModifySysOpLogReq req) {
         SysOpLog sysOpLog = new SysOpLog();
         BeanUtils.copyProperties(req, sysOpLog);
         sysOpLog.setCreateTime(new Date());
         int insertCount = sysOpLogMapper.insert(sysOpLog);
         return insertCount;
     }

     /**
      * 修改登录/操作日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public Integer updateSysOpLogById(SaveAndModifySysOpLogReq req) {
         SysOpLog sysOpLog = new SysOpLog();
         BeanUtils.copyProperties(req, sysOpLog);
         sysOpLog.setModifyTime(new Date());
         int updateCount = sysOpLogMapper.updateById(sysOpLog);
         return updateCount;
     }

     /**
      * 删除登录/操作日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public Integer deleteSysOpLog(SaveAndModifySysOpLogReq req) {
         SysOpLog sysOpLog = new SysOpLog();
         BeanUtils.copyProperties(req, sysOpLog);
         UpdateWrapper<SysOpLog> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SysOpLog::getId, req.getIds());
         updateWrapper.lambda().set(SysOpLog::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SysOpLog::getModifyEmpId, req.getModifyEmpId())
         .set(SysOpLog::getModifyEmpName, req.getModifyEmpName())
         .set(SysOpLog::getModifyTime, new Date());
		 int deleteCount = sysOpLogMapper.update(sysOpLog, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询登录/操作日志表对象
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      *
      */
     @Override
     public SysOpLog selectSysOpLog(QuerySysOpLogReq req) {
         SysOpLog sysOpLogQuery = new SysOpLog();
         BeanUtils.copyProperties(req, sysOpLogQuery);
         QueryWrapper<SysOpLog> querySQL = new QueryWrapper<SysOpLog>();
         querySQL.setEntity(sysOpLogQuery);
         SysOpLog obj = sysOpLogMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询登录/操作日志表列表
      *
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public IPage<SysOpLog> querySysOpLogForPage(QuerySysOpLogReq req) {
         //1.设置分页
         Page<SysOpLog> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SysOpLog> queryWrapper = new QueryWrapper<SysOpLog>();
         queryWrapper.lambda().eq(true, SysOpLog::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SysOpLog::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SysOpLog::getId);
	     IPage<SysOpLog> pageInfo = sysOpLogMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
