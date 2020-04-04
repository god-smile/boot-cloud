package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.SysDict;
import com.zxcv.busi.dao.sys.SysDictDao;
import com.zxcv.api.commom.service.sys.SysDictService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;

import com.zxcv.api.commom.service.sys.dto.SysDictDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysDictReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysDictReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统字典表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysDictServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2020-04-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2020-04-04         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysDictServiceImpl")
public class SysDictServiceImpl  implements SysDictService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Autowired
    private SysDictDao sysDictDao;

    /**
     * 新增系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> saveSysDict(SaveAndModifySysDictReq req) {
        logger.info("begin调用系统字典表service层add()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int insertCount = sysDictDao.saveSysDict(req);
        logger.info("end调用系统字典表service层add()方法,插入条数=【{}】条。", insertCount);
        return new BizResult<Integer>(insertCount);
    }

    /**
     * 修改系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> updateSysDictById(SaveAndModifySysDictReq req) {
        logger.info("begin调用系统字典表service层update()方法,入参={}", JSONObject.toJSON(req));
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        int updateCount = sysDictDao.updateSysDictById(req);
        logger.info("end调用系统字典表service层update()方法,修改条数=【{}】条。", updateCount);
        return new BizResult<Integer>(updateCount);
    }

    /**
     * 删除系统字典表
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<Integer> deleteSysDict(SaveAndModifySysDictReq req) {
        logger.info("begin调用系统字典表service层delete()方法,入参={}", JSONObject.toJSON(req));
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        if (CollectionUtils.isEmpty(req.getIds())) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        int deleteCount = sysDictDao.deleteSysDict(req);
        logger.info("end调用系统字典表service层delete()方法,删除条数=【{}】条。", deleteCount);
        return new BizResult<Integer>(deleteCount);
    }

    /**
     * 查询系统字典表对象
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     *
     */
    @Override
    public BizResult<SysDictDTO> selectSysDict(QuerySysDictReq req) {
        logger.info("begin调用系统字典表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        SysDictDTO sysDictDTO = new SysDictDTO();
        if (req == null || null == req.getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
        }
        SysDict obj = sysDictDao. selectSysDict(req);
        if (null != obj) {
            BeanUtils.copyProperties(obj,sysDictDTO);
        }
        logger.info("end调用系统字典表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysDictDTO));
        return new BizResult<SysDictDTO>(sysDictDTO);
    }

    /**
     * 分页-查询系统字典表列表
     *
     * @author: zxcv
     * @since 2020-04-04
     * @param req
     * @return
     */
    @Override
    public BizResult<PageBean<SysDictDTO>> querySysDictForPage(QuerySysDictReq req) {
        logger.info("begin调用service层分页-查询系统字典表列表()方法,入参={}", JSONObject.toJSON(req));
        PageBean<SysDictDTO> pageBean = new PageBean<SysDictDTO>();
        if (req == null) {
            throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
        }
        IPage<SysDict> pageInfo = sysDictDao.querySysDictForPage(req);
        if (null != pageInfo) {
            PageBeanUtil.copyProperties(pageInfo, pageBean, SysDictDTO.class);
        }
        logger.info("end调用service-查询系统字典表列表分页()方法,查询条数={}条。", pageBean.getTotal());
        return new BizResult<PageBean<SysDictDTO>>(pageBean);
    }
}
