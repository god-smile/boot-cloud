package com.zxcv.busi.dao.sys.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.api.commom.constants.NoInitEnum;
import com.zxcv.busi.domain.sys.SysUserInfo;
import com.zxcv.busi.mapper.sys.SysUserInfoMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.SysUserInfoDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用户表 服务实现类
 * Copyright: Copyright (c)
 *
 * @ClassName: SysUserInfoDaoImpl.java
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
public class SysUserInfoDaoImpl implements SysUserInfoDao {


    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     * 新增用户表
     *
     * @param req
     * @return
     * @author: zxcv
     * @since 2019-12-08
     */
    @Override
    public Integer saveSysUserInfo(SaveAndModifySysUserInfoReq req) {
        SysUserInfo sysUserInfo = new SysUserInfo();
        BeanUtils.copyProperties(req, sysUserInfo);
        sysUserInfo.setUserNo(getNextUserNo());
        int insertCount = sysUserInfoMapper.insert(sysUserInfo);
        return insertCount;
    }

    /**
     * 修改用户表
     *
     * @param req
     * @return
     * @author: zxcv
     * @since 2019-12-08
     */
    @Override
    public Integer updateSysUserInfoById(SaveAndModifySysUserInfoReq req) {
        SysUserInfo sysUserInfo = new SysUserInfo();
        BeanUtils.copyProperties(req, sysUserInfo);
        int updateCount = sysUserInfoMapper.updateById(sysUserInfo);
        return updateCount;
    }

    /**
     * 删除用户表
     *
     * @param req
     * @return
     * @author: zxcv
     * @since 2019-12-08
     */
    @Override
    public Integer deleteSysUserInfo(SaveAndModifySysUserInfoReq req) {
        SysUserInfo sysUserInfo = new SysUserInfo();
        BeanUtils.copyProperties(req, sysUserInfo);
        UpdateWrapper<SysUserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().in(SysUserInfo::getId, req.getIds());
        updateWrapper.lambda().set(SysUserInfo::getDataState, DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
                .set(SysUserInfo::getModifyEmpId, req.getModifyEmpId())
                .set(SysUserInfo::getModifyEmpName, req.getModifyEmpName())
                .set(SysUserInfo::getModifyTime, req.getModifyTime());
        int deleteCount = sysUserInfoMapper.update(sysUserInfo, updateWrapper);
        return deleteCount;
    }

    /**
     * 查询用户表对象
     *
     * @param req
     * @return
     * @author: zxcv
     * @since 2019-12-08
     */
    @Override
    public SysUserInfo selectSysUserInfo(QuerySysUserInfoReq req) {
        SysUserInfo sysUserInfoQuery = new SysUserInfo();
        BeanUtils.copyProperties(req, sysUserInfoQuery);
        QueryWrapper<SysUserInfo> querySQL = new QueryWrapper<SysUserInfo>();
        querySQL.setEntity(sysUserInfoQuery);
        SysUserInfo obj = sysUserInfoMapper.selectOne(querySQL);
        return obj;
    }

    /**
     * 分页-查询用户表列表
     *
     * @param req
     * @return
     * @author: zxcv
     * @since 2019-12-08
     */
    @Override
    public IPage<SysUserInfo> querySysUserInfoForPage(QuerySysUserInfoReq req) {
        //1.设置分页
        Page<SysUserInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
        //2.查询数据
        QueryWrapper<SysUserInfo> queryWrapper = new QueryWrapper<SysUserInfo>();
        queryWrapper.lambda().eq(true, SysUserInfo::getDataState, DataStatusEnum.DATA_STATUS_VALID.getValue())
                .eq(req.getId() != null, SysUserInfo::getId, req.getId());
        queryWrapper.lambda().like(!StringUtils.isBlank(req.getUserName()), SysUserInfo::getUserName, req.getUserName());
        //TODO自定义查询条件
        queryWrapper.lambda().orderByDesc(SysUserInfo::getId);
        IPage<SysUserInfo> pageInfo = sysUserInfoMapper.selectPage(page, queryWrapper);

        return pageInfo;
    }

    private String getNextUserNo() {
        //1.设置分页
        Page<SysUserInfo> page = new Page<>(1, 1);
        //2.查询数据
        QueryWrapper<SysUserInfo> queryWrapper = new QueryWrapper<SysUserInfo>();

        queryWrapper.lambda().orderByDesc(SysUserInfo::getId);
        IPage<SysUserInfo> pageInfo = sysUserInfoMapper.selectPage(page, queryWrapper);
        if (pageInfo == null || CollectionUtils.isEmpty(pageInfo.getRecords())
                || StringUtils.isBlank(pageInfo.getRecords().get(0).getUserNo())) {
            return NoInitEnum.USER_NO.getValue();
        }
        String templateNo = pageInfo.getRecords().get(0).getUserNo();
        //切割字母+数字
        String[] strs = templateNo.split("(?<=\\D)(?=\\d+\\b)");
        String letter = strs[0];
        String number = strs[1];
        Integer num = Integer.valueOf(number);
        return letter + (num + 1);
    }


    /**
     * 查询用户表对象
     *
     * @param req
     * @return
     * @author: zxcv
     * @since 2019-12-08
     */
    @Override
    public List<SysUserInfo> selectSysUserInfoByUserName(QuerySysUserInfoReq req) {
        SysUserInfo sysUserInfoQuery = new SysUserInfo();
        // 密码取出来 加密，set 进去
        BeanUtils.copyProperties(req, sysUserInfoQuery);
        QueryWrapper<SysUserInfo> querySQL = new QueryWrapper<SysUserInfo>();

        QueryWrapper<SysUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(true, SysUserInfo::getDataState, DataStatusEnum.DATA_STATUS_VALID.getValue())
                .eq(true, SysUserInfo::getLevel, DataStatusEnum.USER_LEVEL_USER.getValue())
                .eq(true, SysUserInfo::getUserName, req.getUserName())
                .eq(true, SysUserInfo::getPassword, req.getPassword());
        return sysUserInfoMapper.selectList(queryWrapper);
    }
}
