package com.zxcv.busi.biz.sys;

import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.sys.UserInfoService;
import com.zxcv.api.commom.service.sys.dto.UserInfoDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyUserInfoReq;
import com.zxcv.api.commom.service.sys.param.query.QueryUserInfoReq;
import com.zxcv.busi.domain.sys.UserInfo;
import com.zxcv.busi.mapper.sys.UserInfoMapper;
import com.zxcv.commom.utils.MD5Utils;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * 操作员表(用户) 服务实现类
 * Copyright: Copyright (c)
 *
 * @ClassName: UserInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: lh
 * @date: 2019-10-14
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-14         lh         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.UserInfoServiceImpl")
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 新增操作员表(用户)
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    @Override
    @Transactional
    public BizResult<Long> saveUserInfo(SaveAndModifyUserInfoReq req) {
        logger.info("begin调用操作员表(用户)service层add()方法,入参={}", JSONObject.toJSON(req));
        UserInfo userInfo = new UserInfo();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        if (StringUtils.isEmpty(req.getUserName())) {
        	throw new BizException(ErrorType.PARAMM_NULL, "登录账号为空!");
        }
        //先查询是否存在这个登录账号
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(true,UserInfo::getUserName,req.getUserName());
        UserInfo user = userInfoMapper.selectOne(queryWrapper);
        if(user != null){
        	throw new BizException(ErrorType.PARAM_NOT_VALID,"该账号已存在！");
        }
        String pwd = "123qwe";
        if (StringUtils.isEmpty(req.getUserPassword())) {
            req.setUserPassword(pwd);
        }
        req.setUserPassword(MD5Utils.enMD5(req.getUserPassword()));
        BeanUtils.copyProperties(req, userInfo);
        //userInfo.setCreateTime(new Date());
        int i = userInfoMapper.insert(userInfo);
        if (i < 1 || userInfo.getUserId() == null) {
            throw new BizException(ErrorType.BIZ_ERROR, "新增用户失败");
        }
        logger.info("end调用操作员表(用户)service层add()方法,opId={}。", userInfo.getUserId());
        return new BizResult<Long>(userInfo.getUserId());
    }

    /**
     * 修改操作员表(用户)
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    @Override
    @Transactional
    public BizResult<Integer> updateUserInfoById(SaveAndModifyUserInfoReq req) {
        logger.info("begin调用操作员表(用户)service层update()方法,入参={}", JSONObject.toJSON(req));
        UserInfo userInfo = new UserInfo();
        if (req == null || null == req.getUserId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        BeanUtils.copyProperties(req, userInfo);
        int insertCount = userInfoMapper.updateById(userInfo);
        logger.info("end调用操作员表(用户)service层update()方法,修改条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 删除操作员表(用户)
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    @Override
    public BizResult<Integer> deleteUserInfo(SaveAndModifyUserInfoReq req) {
        logger.info("begin调用操作员表(用户)service层update()方法,入参={}", JSONObject.toJSON(req));
        UserInfo userInfo = new UserInfo();
        if (req == null || null == req.getUserId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        BeanUtils.copyProperties(req, userInfo);
        int insertCount = userInfoMapper.updateById(userInfo);
        logger.info("end调用操作员表(用户)service层update()方法,修改条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 查询操作员表(用户)对象
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    @Override
    public BizResult<UserInfoDTO> selectUserInfo(QueryUserInfoReq req) {
        logger.info("begin调用操作员表(用户)service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        UserInfo userInfoQuery = new UserInfo();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        BeanUtils.copyProperties(req, userInfoQuery);
        QueryWrapper<UserInfo> querySQL = new QueryWrapper<UserInfo>();

        if (null != userInfoQuery.getUserId()) {
            querySQL.eq("id", userInfoQuery.getUserId());
        }
        if (StringUtils.isNotEmpty(userInfoQuery.getUserName())) {
            querySQL.eq("user_name", userInfoQuery.getUserName());
        }
        /*if (StringUtils.isNotEmpty(userInfoQuery.getUserPassword())) {
            querySQL.eq("login_password", userInfoQuery.getUserPassword());
        }*/
        // querySQL.ge("DATE_FORMAT(acct_end_date,'%Y-%m-%d')", DateUtil.format(new Date(),"yyyy-MM-dd"));

        UserInfo obj = userInfoMapper.selectOne(querySQL);
        if (null != obj) {
            BeanUtils.copyProperties(obj, userInfoDTO);
        }
        logger.info("end调用操作员表(用户)service层查询对象方法,结果=【{}】", JSONObject.toJSON(userInfoDTO));
        return new BizResult<UserInfoDTO>(userInfoDTO);
    }

    /**
     * 分页-查询操作员表(用户)列表
     *
     * @param req
     * @return
     * @author: lh
     * @since 2019-10-14
     */
    @Override
    public BizResult<PageBean<UserInfoDTO>> queryUserInfoForPage(QueryUserInfoReq req) {
        logger.info("begin调用service层分页-查询操作员表(用户)列表()方法,入参={}", JSONObject.toJSON(req));
        PageBean<UserInfoDTO> pageBean = new PageBean<UserInfoDTO>();

        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }

        //1.设置分页
        Page<UserInfo> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
        //2.查询数据
        //TODO自定义查询条件
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        if (StringUtils.isNotEmpty(req.getUserName())) {
            queryWrapper.like("user_name", "%" + req.getUserName() + "%");
        }
        if (StringUtils.isNotEmpty(req.getRealName())) {
            queryWrapper.like("real_name", "%" + req.getRealName() + "%");
        }
        queryWrapper.orderByDesc("id");
        IPage<UserInfo> pageInfo = userInfoMapper.selectPage(page, queryWrapper);
        if(pageInfo != null ){
        	PageBeanUtil.copyProperties(pageInfo, pageBean,UserInfoDTO.class);
        }
        logger.info("end调用service-查询操作员表(用户)列表分页()方法,查询条数={}条。", pageBean.getPageTotals());
        return new BizResult<PageBean<UserInfoDTO>>(pageBean);
    }

    /**
     * 通过组织id校验组织是否已经被用户使用,使用则不容许删除
     *
     * @param req
     * @return
     */
    /*@Override
    public BizResult<Integer> checkOrgIdIsUsed(QueryUserInfoReq req) {
        logger.info("begin调用service层通过组织id校验组织是否已经被用户使用()方法,入参={}", JSONObject.toJSON(req));
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        queryWrapper.lambda().eq(req.getOrgId() != null,UserInfo::getOrgId,req.getOrgId())
                .eq(UserInfo::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue());
        Integer intCount = userInfoMapper.selectCount(queryWrapper);
        logger.info("end调用service层通过组织id校验组织是否已经被用户使用()方法,结果={}",intCount);
        return new BizResult<Integer>(intCount);
    }*/
}
