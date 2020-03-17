package com.zxcv.busi.dao.site.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.site.SiteVisitLog;
import com.zxcv.busi.mapper.site.SiteVisitLogMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.site.SiteVisitLogDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import com.zxcv.api.commom.service.site.param.query.QuerySiteVisitLogReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteVisitLogReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 访问记录日志表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteVisitLogDaoImpl.java
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
public class SiteVisitLogDaoImpl  implements SiteVisitLogDao {


    @Autowired
    private SiteVisitLogMapper siteVisitLogMapper;

     /**
      * 新增访问记录日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public Integer saveSiteVisitLog(SaveAndModifySiteVisitLogReq req) {
         SiteVisitLog siteVisitLog = new SiteVisitLog();
         BeanUtils.copyProperties(req, siteVisitLog);
         siteVisitLog.setCreateTime(new Date());
         int insertCount = siteVisitLogMapper.insert(siteVisitLog);
         return insertCount;
     }

     /**
      * 修改访问记录日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public Integer updateSiteVisitLogById(SaveAndModifySiteVisitLogReq req) {
         SiteVisitLog siteVisitLog = new SiteVisitLog();
         BeanUtils.copyProperties(req, siteVisitLog);
         siteVisitLog.setModifyTime(new Date());
         int updateCount = siteVisitLogMapper.updateById(siteVisitLog);
         return updateCount;
     }

     /**
      * 删除访问记录日志表
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public Integer deleteSiteVisitLog(SaveAndModifySiteVisitLogReq req) {
         SiteVisitLog siteVisitLog = new SiteVisitLog();
         BeanUtils.copyProperties(req, siteVisitLog);
         UpdateWrapper<SiteVisitLog> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SiteVisitLog::getId, req.getIds());
         updateWrapper.lambda().set(SiteVisitLog::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SiteVisitLog::getModifyEmpId, req.getModifyEmpId())
         .set(SiteVisitLog::getModifyEmpName, req.getModifyEmpName())
         .set(SiteVisitLog::getModifyTime, new Date());
		 int deleteCount = siteVisitLogMapper.update(siteVisitLog, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询访问记录日志表对象
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      *
      */
     @Override
     public SiteVisitLog selectSiteVisitLog(QuerySiteVisitLogReq req) {
         SiteVisitLog siteVisitLogQuery = new SiteVisitLog();
         BeanUtils.copyProperties(req, siteVisitLogQuery);
         QueryWrapper<SiteVisitLog> querySQL = new QueryWrapper<SiteVisitLog>();
         querySQL.setEntity(siteVisitLogQuery);
         SiteVisitLog obj = siteVisitLogMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询访问记录日志表列表
      *
      * @author: zxcv
      * @since 2020-01-22
      * @param req
      * @return
      */
     @Override
     public IPage<SiteVisitLog> querySiteVisitLogForPage(QuerySiteVisitLogReq req) {
         //1.设置分页
         Page<SiteVisitLog> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SiteVisitLog> queryWrapper = new QueryWrapper<SiteVisitLog>();
         queryWrapper.lambda().eq(true, SiteVisitLog::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SiteVisitLog::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SiteVisitLog::getId);
	     IPage<SiteVisitLog> pageInfo = siteVisitLogMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
