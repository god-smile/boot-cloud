package com.zxcv.busi.dao.site.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.site.SiteConfig;
import com.zxcv.busi.mapper.site.SiteConfigMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.site.SiteConfigDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import com.zxcv.api.commom.service.site.param.query.QuerySiteConfigReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteConfigReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户配置表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteConfigDaoImpl.java
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
public class SiteConfigDaoImpl  implements SiteConfigDao {


    @Autowired
    private SiteConfigMapper siteConfigMapper;

     /**
      * 新增用户配置表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer saveSiteConfig(SaveAndModifySiteConfigReq req) {
         SiteConfig siteConfig = new SiteConfig();
         BeanUtils.copyProperties(req, siteConfig);
         siteConfig.setCreateTime(new Date());
         int insertCount = siteConfigMapper.insert(siteConfig);
         return insertCount;
     }

     /**
      * 修改用户配置表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer updateSiteConfigById(SaveAndModifySiteConfigReq req) {
         SiteConfig siteConfig = new SiteConfig();
         BeanUtils.copyProperties(req, siteConfig);
         siteConfig.setModifyTime(new Date());
         int updateCount = siteConfigMapper.updateById(siteConfig);
         return updateCount;
     }

     /**
      * 删除用户配置表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer deleteSiteConfig(SaveAndModifySiteConfigReq req) {
         SiteConfig siteConfig = new SiteConfig();
         BeanUtils.copyProperties(req, siteConfig);
         UpdateWrapper<SiteConfig> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SiteConfig::getId, req.getIds());
         updateWrapper.lambda().set(SiteConfig::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SiteConfig::getModifyEmpId, req.getModifyEmpId())
         .set(SiteConfig::getModifyEmpName, req.getModifyEmpName())
         .set(SiteConfig::getModifyTime, new Date());
		 int deleteCount = siteConfigMapper.update(siteConfig, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询用户配置表对象
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      *
      */
     @Override
     public SiteConfig selectSiteConfig(QuerySiteConfigReq req) {
         SiteConfig siteConfigQuery = new SiteConfig();
         BeanUtils.copyProperties(req, siteConfigQuery);
         QueryWrapper<SiteConfig> querySQL = new QueryWrapper<SiteConfig>();
         querySQL.setEntity(siteConfigQuery);
         SiteConfig obj = siteConfigMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询用户配置表列表
      *
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public IPage<SiteConfig> querySiteConfigForPage(QuerySiteConfigReq req) {
         //1.设置分页
         Page<SiteConfig> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SiteConfig> queryWrapper = new QueryWrapper<SiteConfig>();
         queryWrapper.lambda().eq(true, SiteConfig::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SiteConfig::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SiteConfig::getId);
	     IPage<SiteConfig> pageInfo = siteConfigMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
