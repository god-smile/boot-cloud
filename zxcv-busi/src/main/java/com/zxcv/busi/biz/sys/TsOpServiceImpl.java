package com.zxcv.busi.biz.sys;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.zxcv.api.commom.service.sys.TsOpService;
import com.zxcv.api.commom.service.sys.dto.TsOpDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTsOpReq;
import com.zxcv.api.commom.service.sys.param.query.QueryTsOpReq;
import com.zxcv.busi.domain.sys.TsOp;
import com.zxcv.busi.mapper.sys.TsOpMapper;
import com.zxcv.commom.utils.MD5Utils;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;

import cn.hutool.core.date.DateUtil;

/**
 * 操作员表(用户) 服务实现类
 * Copyright: Copyright (c)
 *
 * @ClassName: TsOpServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-06-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-06-04         wangfs         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.TsOpServiceImpl")
public class TsOpServiceImpl implements TsOpService {

    private static final Logger logger = LoggerFactory.getLogger(TsOpServiceImpl.class);

    @Autowired
    private TsOpMapper tsOpMapper;

    /**
     * 新增操作员表(用户)
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    @Override
    @Transactional
    public BizResult<Long> saveTsOp(SaveAndModifyTsOpReq req) {
        logger.info("begin调用操作员表(用户)service层add()方法,入参={}", JSONObject.toJSON(req));
        TsOp tsOp = new TsOp();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        if (StringUtils.isEmpty(req.getLoginCode())) {
        	throw new BizException(ErrorType.PARAMM_NULL, "登录账号为空!");
        }
        //先查询是否存在这个登录账号
        QueryWrapper<TsOp> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(true,TsOp::getLoginCode,req.getLoginCode())
        .eq(TsOp::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue());;
        TsOp op = tsOpMapper.selectOne(queryWrapper);
        if(op != null){
        	throw new BizException(ErrorType.PARAM_NOT_VALID,"该账号已存在！");
        }
        String pwd = "123qwe";
        if (StringUtils.isEmpty(req.getLoginPassword())) {
            req.setLoginPassword(pwd);
        }
        req.setLoginPassword(MD5Utils.enMD5(req.getLoginPassword()));
        BeanUtils.copyProperties(req, tsOp);
        tsOp.setCreateTime(new Date());
        int i = tsOpMapper.insert(tsOp);
        if (i < 1 || tsOp.getId() == null) {
            throw new BizException(ErrorType.BIZ_ERROR, "新增用户失败");
        }
        logger.info("end调用操作员表(用户)service层add()方法,opId={}。", tsOp.getId());
        return new BizResult<Long>(tsOp.getId());
    }

    /**
     * 修改操作员表(用户)
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    @Override
    @Transactional
    public BizResult<Integer> updateTsOpById(SaveAndModifyTsOpReq req) {
        logger.info("begin调用操作员表(用户)service层update()方法,入参={}", JSONObject.toJSON(req));
        TsOp tsOp = new TsOp();
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        BeanUtils.copyProperties(req, tsOp);
        int insertCount = tsOpMapper.updateById(tsOp);
        logger.info("end调用操作员表(用户)service层update()方法,修改条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 删除操作员表(用户)
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    @Override
    public BizResult<Integer> deleteTsOp(SaveAndModifyTsOpReq req) {
        logger.info("begin调用操作员表(用户)service层update()方法,入参={}", JSONObject.toJSON(req));
        TsOp tsOp = new TsOp();
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        BeanUtils.copyProperties(req, tsOp);
        int insertCount = tsOpMapper.updateById(tsOp);
        logger.info("end调用操作员表(用户)service层update()方法,修改条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 查询操作员表(用户)对象
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    @Override
    public BizResult<TsOpDTO> selectTsOp(QueryTsOpReq req) {
        logger.info("begin调用操作员表(用户)service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        TsOpDTO tsOpDTO = new TsOpDTO();
        TsOp tsOpQuery = new TsOp();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        BeanUtils.copyProperties(req, tsOpQuery);
        QueryWrapper<TsOp> querySQL = new QueryWrapper<TsOp>();

        if (null != tsOpQuery.getId()) {
            querySQL.eq("id", tsOpQuery.getId());
        }
        if (StringUtils.isNotEmpty(tsOpQuery.getLoginCode())) {
            querySQL.eq("login_code", tsOpQuery.getLoginCode());
        }
        if (StringUtils.isNotEmpty(tsOpQuery.getLoginPassword())) {
            querySQL.eq("login_password", tsOpQuery.getLoginPassword());
        }
        querySQL.ge("DATE_FORMAT(acct_end_date,'%Y-%m-%d')", DateUtil.format(new Date(),"yyyy-MM-dd"));
        querySQL.eq("data_state", DataStatusEnum.DATA_STATUS_VALID.getValue());

        TsOp obj = tsOpMapper.selectOne(querySQL);
        if (null != obj) {
            BeanUtils.copyProperties(obj, tsOpDTO);
        }
        logger.info("end调用操作员表(用户)service层查询对象方法,结果=【{}】", JSONObject.toJSON(tsOpDTO));
        return new BizResult<TsOpDTO>(tsOpDTO);
    }

    /**
     * 分页-查询操作员表(用户)列表
     *
     * @param req
     * @return
     * @author: wangfs
     * @since 2019-06-04
     */
    @Override
    public BizResult<PageBean<TsOpDTO>> queryTsOpForPage(QueryTsOpReq req) {
        logger.info("begin调用service层分页-查询操作员表(用户)列表()方法,入参={}", JSONObject.toJSON(req));
        PageBean<TsOpDTO> pageBean = new PageBean<TsOpDTO>();

        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }

        //1.设置分页
        Page<TsOp> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
        //2.查询数据
        //TODO自定义查询条件
        QueryWrapper<TsOp> queryWrapper = new QueryWrapper<TsOp>();
        if (req.getDataState() != null) {
            queryWrapper.eq("data_state", req.getDataState());
        }
        if (StringUtils.isNotEmpty(req.getLoginCode())) {
            queryWrapper.like("login_code", "%" + req.getLoginCode() + "%");
        }
        if (StringUtils.isNotEmpty(req.getOpName())) {
            queryWrapper.like("op_name", "%" + req.getOpName() + "%");
        }
        queryWrapper.orderByDesc("id");
        IPage<TsOp> pageInfo = tsOpMapper.selectPage(page, queryWrapper);
        if(pageInfo != null ){
        	PageBeanUtil.copyProperties(pageInfo, pageBean,TsOpDTO.class);
        }
        logger.info("end调用service-查询操作员表(用户)列表分页()方法,查询条数={}条。", pageBean.getPageTotals());
        return new BizResult<PageBean<TsOpDTO>>(pageBean);
    }

    /**
     * 通过组织id校验组织是否已经被用户使用,使用则不容许删除
     *
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> checkOrgIdIsUsed(QueryTsOpReq req) {
        logger.info("begin调用service层通过组织id校验组织是否已经被用户使用()方法,入参={}", JSONObject.toJSON(req));
        QueryWrapper<TsOp> queryWrapper = new QueryWrapper<TsOp>();
        queryWrapper.lambda().eq(req.getOrgId() != null,TsOp::getOrgId,req.getOrgId())
                .eq(TsOp::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue());
        Integer intCount = tsOpMapper.selectCount(queryWrapper);
        logger.info("end调用service层通过组织id校验组织是否已经被用户使用()方法,结果={}",intCount);
        return new BizResult<Integer>(intCount);
    }
}
