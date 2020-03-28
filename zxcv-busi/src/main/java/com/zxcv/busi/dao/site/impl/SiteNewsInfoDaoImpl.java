package com.zxcv.busi.dao.site.impl;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.api.commom.constants.NoPrefixEnum;
import com.zxcv.busi.domain.site.SiteNewsInfo;
import com.zxcv.busi.mapper.site.SiteNewsInfoMapper;
import com.zxcv.commom.utils.DateUtil;
import com.zxcv.commom.utils.SequenceUtil;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.site.SiteNewsInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.site.param.query.QuerySiteNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteNewsInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新闻表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SiteNewsInfoDaoImpl.java
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
public class SiteNewsInfoDaoImpl  implements SiteNewsInfoDao {


    @Autowired
    private SiteNewsInfoMapper siteNewsInfoMapper;

    /**
     * 新增新闻表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    @Override
    public Integer saveSiteNewsInfo(SaveAndModifySiteNewsInfoReq req) {
        SiteNewsInfo siteNewsInfo = new SiteNewsInfo();
        BeanUtils.copyProperties(req, siteNewsInfo);

        if (siteNewsInfo.getBeginTime() == null) {
            siteNewsInfo.setBeginTime(DateUtil.getGlobalBeginTime());
        }

        if (siteNewsInfo.getEndTime() == null) {
            siteNewsInfo.setEndTime(DateUtil.getGlobalEndTime());
        }

        siteNewsInfo.setNewsNo(SequenceUtil.getNextId(NoPrefixEnum.NEWS_NO.getValue()));
        int insertCount = siteNewsInfoMapper.insert(siteNewsInfo);
        return insertCount;
    }

    /**
     * 修改新闻表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    @Override
    public Integer updateSiteNewsInfoById(SaveAndModifySiteNewsInfoReq req) {
        SiteNewsInfo siteNewsInfo = new SiteNewsInfo();
        BeanUtils.copyProperties(req, siteNewsInfo);

        if (siteNewsInfo.getBeginTime() == null) {
            siteNewsInfo.setBeginTime(DateUtil.getGlobalBeginTime());
        }

        if (siteNewsInfo.getEndTime() == null) {
            siteNewsInfo.setEndTime(DateUtil.getGlobalEndTime());
        }

        int updateCount = siteNewsInfoMapper.updateById(siteNewsInfo);
        return updateCount;
    }

    /**
     * 删除新闻表
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    @Override
    public Integer deleteSiteNewsInfo(SaveAndModifySiteNewsInfoReq req) {
        SiteNewsInfo siteNewsInfo = new SiteNewsInfo();
        BeanUtils.copyProperties(req, siteNewsInfo);
        UpdateWrapper<SiteNewsInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().in(SiteNewsInfo::getId, req.getIds());
        updateWrapper.lambda().set(SiteNewsInfo::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
                .set(SiteNewsInfo::getModifyEmpId, req.getModifyEmpId())
                .set(SiteNewsInfo::getModifyEmpName, req.getModifyEmpName())
                .set(SiteNewsInfo::getModifyTime, req.getModifyTime());
        int deleteCount = siteNewsInfoMapper.update(siteNewsInfo, updateWrapper);
        return deleteCount;
    }

    /**
     * 查询新闻表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     *
     */
    @Override
    public SiteNewsInfo selectSiteNewsInfo(QuerySiteNewsInfoReq req) {
        SiteNewsInfo siteNewsInfoQuery = new SiteNewsInfo();
        BeanUtils.copyProperties(req, siteNewsInfoQuery);
        QueryWrapper<SiteNewsInfo> querySQL = new QueryWrapper<SiteNewsInfo>();
        querySQL.setEntity(siteNewsInfoQuery);
        querySQL.lambda().le(req.getEntrance() == DataStatusEnum.DATA_STATUS_VALID.getValue(), SiteNewsInfo::getBeginTime, new Date())
                .ge(req.getEntrance() == DataStatusEnum.DATA_STATUS_VALID.getValue(), SiteNewsInfo::getEndTime, new Date());

        SiteNewsInfo obj = siteNewsInfoMapper.selectOne(querySQL);
        return obj;
    }

    /**
     * 分页-查询新闻表列表
     *
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     */
    @Override
    public IPage<SiteNewsInfo> querySiteNewsInfoForPage(QuerySiteNewsInfoReq req) {
        //1.设置分页
        Page<SiteNewsInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
        //2.查询数据
        QueryWrapper<SiteNewsInfo> queryWrapper = new QueryWrapper<SiteNewsInfo>();
        queryWrapper.lambda().eq(true, SiteNewsInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
                .le(req.getEntrance() == DataStatusEnum.DATA_STATUS_VALID.getValue(), SiteNewsInfo::getBeginTime, new Date())
                .ge(req.getEntrance() == DataStatusEnum.DATA_STATUS_VALID.getValue(), SiteNewsInfo::getEndTime, new Date())
                .eq(!StringUtils.isBlank(req.getNewsNo()),SiteNewsInfo::getNewsNo,req.getNewsNo())
                .eq(!StringUtils.isBlank(req.getProjectNo()),SiteNewsInfo::getProjectNo,req.getProjectNo())
                .eq(null != (req.getNewsType()),SiteNewsInfo::getNewsType,req.getNewsType())
                .like(!StringUtils.isBlank(req.getTitle()),SiteNewsInfo::getTitle,req.getTitle())
                .eq(req.getId() != null, SiteNewsInfo::getId,req.getId());
        queryWrapper.lambda().orderByDesc(SiteNewsInfo::getId);
        IPage<SiteNewsInfo> pageInfo = siteNewsInfoMapper.selectPage(page, queryWrapper);

        return pageInfo;
    }
}
