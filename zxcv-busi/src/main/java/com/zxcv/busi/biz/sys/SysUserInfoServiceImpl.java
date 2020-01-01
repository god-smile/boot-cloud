package com.zxcv.busi.biz.sys;
import com.zxcv.api.commom.constants.ConstantEnum;
import com.zxcv.busi.dao.sys.SysProjectInfoDao;
import com.zxcv.busi.domain.sys.SysProjectInfo;
import com.zxcv.busi.domain.sys.SysUserInfo;
import com.zxcv.busi.dao.sys.SysUserInfoDao;
import com.zxcv.api.commom.service.sys.SysUserInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * 用户表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysUserInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysUserInfoServiceImpl")
public class SysUserInfoServiceImpl  implements SysUserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserInfoServiceImpl.class);

    @Autowired
    private SysUserInfoDao sysUserInfoDao;

    @Autowired
    private SysProjectInfoDao sysProjectInfoDao;

     /**
      * 新增用户表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysUserInfo(SaveAndModifySysUserInfoReq req) {
         logger.info("begin调用用户表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysUserInfoDao.saveSysUserInfo(req);
         logger.info("end调用用户表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改用户表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysUserInfoById(SaveAndModifySysUserInfoReq req) {
         logger.info("begin调用用户表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysUserInfoDao.updateSysUserInfoById(req);
         logger.info("end调用用户表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除用户表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysUserInfo(SaveAndModifySysUserInfoReq req) {
         logger.info("begin调用用户表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysUserInfoDao.deleteSysUserInfo(req);
         logger.info("end调用用户表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询用户表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysUserInfoDTO> selectSysUserInfo(QuerySysUserInfoReq req) {
         logger.info("begin调用用户表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysUserInfoDTO sysUserInfoDTO = new SysUserInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysUserInfo obj = sysUserInfoDao. selectSysUserInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysUserInfoDTO);
         }
         logger.info("end调用用户表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysUserInfoDTO));
         return new BizResult<SysUserInfoDTO>(sysUserInfoDTO);
     }

     /**
      * 分页-查询用户表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysUserInfoDTO>> querySysUserInfoForPage(QuerySysUserInfoReq req) {
         logger.info("begin调用service层分页-查询用户表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysUserInfoDTO> pageBean = new PageBean<SysUserInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysUserInfo> pageInfo = sysUserInfoDao.querySysUserInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysUserInfoDTO.class);
         }
         logger.info("end调用service-查询用户表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysUserInfoDTO>>(pageBean);
     }


    /**
     * 用户登录
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     *
     */
    @Override
    public BizResult<SysUserInfoDTO> userLogin(QuerySysUserInfoReq req) {
        logger.info("begin调用用户表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        SysUserInfoDTO sysUserInfoDTO = new SysUserInfoDTO();
        if (req == null || null == req.getUserName()) {
            throw new BizException(ErrorType.PARAMM_NULL, "用户名为空!");
        }
        if (null == req.getPassword()) {
            throw new BizException(ErrorType.PARAMM_NULL, "密码为空!");
        }
        List<SysUserInfo> userList = sysUserInfoDao. selectSysUserInfoByUserName(req);
        if (null == userList || userList.isEmpty()) {
            // 没有 该用户名对应的用户 或 密码不对。提示 “用户名或密码不正确”
            throw new BizException(ErrorType.AUTH_PASS_ERROR, "用户名或密码不正确");
        }
        if (userList.size() > 1) {
            // 用户名匹配到多条记录
            throw new BizException(ErrorType.AUTH_MULTIPLE_USER, "账号匹配出错");
        }
        SysUserInfo obj = userList.get(0);
        if (null != obj ) {
            // 判断 用户 是否被冻结， 是否过了登录期限
            if (obj.getUserState() == 0) {
                throw new BizException(ErrorType.AUTH_LOGIN_FREEZED, "账号被冻结!");
            }
            if (obj.getBeginTime() != null && obj.getEndTime() != null) {
                Date now = new Date();
                if (obj.getBeginTime().compareTo(now) > 0 || obj.getEndTime().compareTo(now) < 0) {
                    throw new BizException(ErrorType.AUTH_LOGIN_ENDTIME, "账号已过期!");
                }
            }

            // 根据 用户编号 查询 项目表，根据 id 排序，取 第一个
            List<SysProjectInfo> list = sysProjectInfoDao.getSysProjectInfoByUserNo(obj.getUserNo());
            if (list == null || list.isEmpty()) {
                throw new BizException(ErrorType.AUTH_PROJECT_EMPTY, "该账号未关联项目!");
            }

            BeanUtils.copyProperties(obj,sysUserInfoDTO);
            sysUserInfoDTO.setProjectNo(list.get(0).getProjectNo());
            sysUserInfoDTO.setLoginUrl(list.get(0).getIndexUrl());
            sysUserInfoDTO.setIndexUrl(ConstantEnum.INDEX_URL.key());
        }else {
            // 没有 该用户名对应的用户 或 密码不对。提示 “用户名或密码不正确”
            throw new BizException(ErrorType.AUTH_PASS_ERROR, "用户名或密码不正确");
        }
        logger.info("end调用用户表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysUserInfoDTO));
        return new BizResult<SysUserInfoDTO>(sysUserInfoDTO);
    }
}
