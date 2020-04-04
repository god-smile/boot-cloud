package com.zxcv.busi.dao.site.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.site.SiteCompanyInfo;
import com.zxcv.busi.mapper.site.SiteCompanyInfoMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.site.SiteCompanyInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import com.zxcv.api.commom.service.site.param.query.QuerySiteCompanyInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteCompanyInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 分公司表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteCompanyInfoDaoImpl.java
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
public class SiteCompanyInfoDaoImpl  implements SiteCompanyInfoDao {


    @Autowired
    private SiteCompanyInfoMapper siteCompanyInfoMapper;

     /**
      * 新增分公司表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer saveSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req) {
         SiteCompanyInfo siteCompanyInfo = new SiteCompanyInfo();
         BeanUtils.copyProperties(req, siteCompanyInfo);
         siteCompanyInfo.setCreateTime(new Date());
         int insertCount = siteCompanyInfoMapper.insert(siteCompanyInfo);
         return insertCount;
     }

     /**
      * 修改分公司表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer updateSiteCompanyInfoById(SaveAndModifySiteCompanyInfoReq req) {
         SiteCompanyInfo siteCompanyInfo = new SiteCompanyInfo();
         BeanUtils.copyProperties(req, siteCompanyInfo);
         siteCompanyInfo.setModifyTime(new Date());
         int updateCount = siteCompanyInfoMapper.updateById(siteCompanyInfo);
         return updateCount;
     }

     /**
      * 删除分公司表
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public Integer deleteSiteCompanyInfo(SaveAndModifySiteCompanyInfoReq req) {
         SiteCompanyInfo siteCompanyInfo = new SiteCompanyInfo();
         BeanUtils.copyProperties(req, siteCompanyInfo);
         UpdateWrapper<SiteCompanyInfo> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(SiteCompanyInfo::getId, req.getIds());
         updateWrapper.lambda().set(SiteCompanyInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(SiteCompanyInfo::getModifyEmpId, req.getModifyEmpId())
         .set(SiteCompanyInfo::getModifyEmpName, req.getModifyEmpName())
         .set(SiteCompanyInfo::getModifyTime, new Date());
		 int deleteCount = siteCompanyInfoMapper.update(siteCompanyInfo, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询分公司表对象
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      *
      */
     @Override
     public SiteCompanyInfo selectSiteCompanyInfo(QuerySiteCompanyInfoReq req) {
         SiteCompanyInfo siteCompanyInfoQuery = new SiteCompanyInfo();
         BeanUtils.copyProperties(req, siteCompanyInfoQuery);
         QueryWrapper<SiteCompanyInfo> querySQL = new QueryWrapper<SiteCompanyInfo>();
         querySQL.setEntity(siteCompanyInfoQuery);
         SiteCompanyInfo obj = siteCompanyInfoMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询分公司表列表
      *
      * @author: zxcv
      * @since 2020-04-04
      * @param req
      * @return
      */
     @Override
     public IPage<SiteCompanyInfo> querySiteCompanyInfoForPage(QuerySiteCompanyInfoReq req) {
         //1.设置分页
         Page<SiteCompanyInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<SiteCompanyInfo> queryWrapper = new QueryWrapper<SiteCompanyInfo>();
         queryWrapper.lambda().eq(true, SiteCompanyInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, SiteCompanyInfo::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(SiteCompanyInfo::getId);
	     IPage<SiteCompanyInfo> pageInfo = siteCompanyInfoMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
