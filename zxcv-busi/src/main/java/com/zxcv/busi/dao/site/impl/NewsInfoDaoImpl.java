package com.zxcv.busi.dao.site.impl;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.api.commom.constants.NoPrefixEnum;
import com.zxcv.busi.domain.site.NewsInfo;
import com.zxcv.busi.mapper.site.NewsInfoMapper;
import com.zxcv.commom.utils.SequenceUtil;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.site.NewsInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.site.param.query.QueryNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifyNewsInfoReq;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 新闻表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: NewsInfoDaoImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-11-09
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-11-09         zxcv         v1.0.0               创建
 */
@Component
public class NewsInfoDaoImpl  implements NewsInfoDao {


    @Autowired
    private NewsInfoMapper newsInfoMapper;


     /**
      * 新增新闻表
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public Integer saveNewsInfo(SaveAndModifyNewsInfoReq req) {
         NewsInfo newsInfo = new NewsInfo();
         BeanUtils.copyProperties(req, newsInfo);
         newsInfo.setCreateTime(new Date());
         newsInfo.setNewsNo(SequenceUtil.getNextId(NoPrefixEnum.NEWS_NO.getValue()));
         int insertCount = newsInfoMapper.insert(newsInfo);
         return insertCount;
     }

     /**
      * 修改新闻表
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public Integer updateNewsInfoById(SaveAndModifyNewsInfoReq req) {
         NewsInfo newsInfo = new NewsInfo();
         BeanUtils.copyProperties(req, newsInfo);
         int updateCount = newsInfoMapper.updateById(newsInfo);
         return updateCount;
     }

     /**
      * 删除新闻表
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public Integer deleteNewsInfo(SaveAndModifyNewsInfoReq req) {
         NewsInfo newsInfo = new NewsInfo();
         BeanUtils.copyProperties(req, newsInfo);
         UpdateWrapper<NewsInfo> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(NewsInfo::getId, req.getIds());
         updateWrapper.lambda().set(NewsInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(NewsInfo::getModifyEmpId, req.getModifyEmpId())
         .set(NewsInfo::getModifyEmpName, req.getModifyEmpName())
         .set(NewsInfo::getModifyTime, req.getModifyTime());
		 int deleteCount = newsInfoMapper.update(newsInfo, updateWrapper);
         return deleteCount;
     }

     /**
      * 查询新闻表对象
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      *
      */
     @Override
     public NewsInfo selectNewsInfo(QueryNewsInfoReq req) {
         NewsInfo newsInfoQuery = new NewsInfo();
         BeanUtils.copyProperties(req, newsInfoQuery);
         QueryWrapper<NewsInfo> querySQL = new QueryWrapper<NewsInfo>();
         querySQL.setEntity(newsInfoQuery);
         NewsInfo obj = newsInfoMapper.selectOne(querySQL);
         return obj;
     }

     /**
      * 分页-查询新闻表列表
      *
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public IPage<NewsInfo> queryNewsInfoForPage(QueryNewsInfoReq req) {
         //1.设置分页
         Page<NewsInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<NewsInfo> queryWrapper = new QueryWrapper<NewsInfo>();
         queryWrapper.lambda().eq(true, NewsInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
                 .eq(!StringUtils.isBlank(req.getNewsNo()),NewsInfo::getNewsNo,req.getNewsNo())
                 .eq(!StringUtils.isBlank(req.getProjectNo()),NewsInfo::getProjectNo,req.getProjectNo())
                 .eq(null != (req.getNewsType()),NewsInfo::getNewsType,req.getNewsType())
                 .like(!StringUtils.isBlank(req.getTitle()),NewsInfo::getTitle,req.getTitle())
         .eq(req.getId() != null, NewsInfo::getId,req.getId());
         queryWrapper.lambda().orderByDesc(NewsInfo::getId);
	     IPage<NewsInfo> pageInfo = newsInfoMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
