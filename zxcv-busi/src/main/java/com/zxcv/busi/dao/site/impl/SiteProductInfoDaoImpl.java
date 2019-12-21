package com.zxcv.busi.dao.site.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.site.SiteProductInfo;
import com.zxcv.busi.mapper.site.SiteProductInfoMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.site.SiteProductInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户产品表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteProductInfoDaoImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-21
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-21         zxcv         v1.0.0               创建
 */
@Component
public class SiteProductInfoDaoImpl  implements SiteProductInfoDao {


    @Autowired
    private SiteProductInfoMapper siteProductInfoMapper;

     /**
      * 新增用户产品表
      * @author: zxcv
      * @since 2019-12-21
      * @param req
      * @return
      */
     @Override
     public Integer saveSiteProductInfo(SaveAndModifySiteProductInfoReq req) {
         SiteProductInfo siteProductInfo = new SiteProductInfo();
         BeanUtils.copyProperties(req, siteProductInfo);
         siteProductInfo.setCreateTime(new Date());
         int insertCount = siteProductInfoMapper.insert(siteProductInfo);
         return insertCount;
     }

     /**
      * 修改用户产品表
      * @author: zxcv
      * @since 2019-12-21
      * @param req
      * @return
      */
     @Override
     public Integer updateSiteProductInfoById(SaveAndModifySiteProductInfoReq req) {
         SiteProductInfo siteProductInfo = new SiteProductInfo();
         BeanUtils.copyProperties(req, siteProductInfo);
         siteProductInfo.setModifyTime(new Date());
         int updateCount = siteProductInfoMapper.updateById(siteProductInfo);
         return updateCount;
     }

     /**
      * 删除用户产品表
      * @author: zxcv
      * @since 2019-12-21
      * @param req
      * @return
      */
     @Override
     public Integer deleteSiteProductInfo(SaveAndModifySiteProductInfoReq req) {
         SiteProductInfo siteProductInfo = new SiteProductInfo();
         BeanUtils.copyProperties(req, siteProductInfo);
         UpdateWrapper<SiteProductInfo> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SiteProductInfo::getId, req.getIds());
         updateWrapper.lambda().set(SiteProductInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SiteProductInfo::getModifyEmpId, req.getModifyEmpId())
         .set(SiteProductInfo::getModifyEmpName, req.getModifyEmpName())
         .set(SiteProductInfo::getModifyTime, new Date());
		 int deleteCount = siteProductInfoMapper.update(siteProductInfo, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询用户产品表对象
      * @author: zxcv
      * @since 2019-12-21
      * @param req
      * @return
      *
      */
     @Override
     public SiteProductInfo selectSiteProductInfo(QuerySiteProductInfoReq req) {
         SiteProductInfo siteProductInfoQuery = new SiteProductInfo();
         BeanUtils.copyProperties(req, siteProductInfoQuery);
         QueryWrapper<SiteProductInfo> querySQL = new QueryWrapper<SiteProductInfo>();
         querySQL.setEntity(siteProductInfoQuery);
         SiteProductInfo obj = siteProductInfoMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询用户产品表列表
      *
      * @author: zxcv
      * @since 2019-12-21
      * @param req
      * @return
      */
     @Override
     public IPage<SiteProductInfo> querySiteProductInfoForPage(QuerySiteProductInfoReq req) {
         //1.设置分页
         Page<SiteProductInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SiteProductInfo> queryWrapper = new QueryWrapper<SiteProductInfo>();
         queryWrapper.lambda().eq(true, SiteProductInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SiteProductInfo::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SiteProductInfo::getId);
	     IPage<SiteProductInfo> pageInfo = siteProductInfoMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
