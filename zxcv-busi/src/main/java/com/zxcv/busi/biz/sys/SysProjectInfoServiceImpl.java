package com.zxcv.busi.biz.sys;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.sys.SysProjectInfoService;
import com.zxcv.api.commom.service.sys.dto.SysProjectInfoDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectInfoReq;
import com.zxcv.api.commom.service.sys.param.query.ProjectReq;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectInfoReq;
import com.zxcv.busi.dao.sys.SysProjectInfoDao;
import com.zxcv.busi.domain.sys.SysProjectInfo;
import com.zxcv.commom.utils.ListCopyUtil;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: SysProjectInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.SysProjectInfoServiceImpl")
public class SysProjectInfoServiceImpl  implements SysProjectInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SysProjectInfoServiceImpl.class);

    @Autowired
    private SysProjectInfoDao sysProjectInfoDao;

     /**
      * 新增项目表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveSysProjectInfo(SaveAndModifySysProjectInfoReq req) {
         logger.info("begin调用项目表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = sysProjectInfoDao.saveSysProjectInfo(req);
         logger.info("end调用项目表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改项目表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateSysProjectInfoById(SaveAndModifySysProjectInfoReq req) {
         logger.info("begin调用项目表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = sysProjectInfoDao.updateSysProjectInfoById(req);
         logger.info("end调用项目表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除项目表
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteSysProjectInfo(SaveAndModifySysProjectInfoReq req) {
         logger.info("begin调用项目表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = sysProjectInfoDao.deleteSysProjectInfo(req);
         logger.info("end调用项目表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询项目表对象
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<SysProjectInfoDTO> selectSysProjectInfo(QuerySysProjectInfoReq req) {
         logger.info("begin调用项目表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         SysProjectInfoDTO sysProjectInfoDTO = new SysProjectInfoDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         SysProjectInfo obj = sysProjectInfoDao. selectSysProjectInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,sysProjectInfoDTO);
         }
         logger.info("end调用项目表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysProjectInfoDTO));
         return new BizResult<SysProjectInfoDTO>(sysProjectInfoDTO);
     }

     /**
      * 分页-查询项目表列表
      *
      * @author: zxcv
      * @since 2019-12-08
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<SysProjectInfoDTO>> querySysProjectInfoForPage(QuerySysProjectInfoReq req) {
         logger.info("begin调用service层分页-查询项目表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<SysProjectInfoDTO> pageBean = new PageBean<SysProjectInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<SysProjectInfo> pageInfo = sysProjectInfoDao.querySysProjectInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, SysProjectInfoDTO.class);
         }
         logger.info("end调用service-查询项目表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<SysProjectInfoDTO>>(pageBean);
     }


    /**
     * 根据url，查询项目表对象
     * @author: zxcv
     * @since 2019-12-08
     * @param req
     * @return
     *
     */
    @Override
    public BizResult<SysProjectInfoDTO> getSysProjectInfoByUrl(ProjectReq req) {
        logger.info("begin调用项目表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
        SysProjectInfoDTO sysProjectInfoDTO = new SysProjectInfoDTO();
        if (req == null || null == req.getIndexUrl()) {
            throw new BizException(ErrorType.PARAMM_NULL, "url为空!");
        }
        SysProjectInfo obj = sysProjectInfoDao. getSysProjectInfoByUrl(req);
        if (null != obj) {
            BeanUtils.copyProperties(obj,sysProjectInfoDTO);
        }
        logger.info("end调用项目表service层查询对象方法,结果=【{}】", JSONObject.toJSON(sysProjectInfoDTO));
        return new BizResult<SysProjectInfoDTO>(sysProjectInfoDTO);
    }

    @Override
    public BizResult<List<SysProjectInfoDTO>> getSysProjectInfoByUserNo(ProjectReq req) {
        List<SysProjectInfoDTO> dtos = new ArrayList<>();
        List<SysProjectInfo> list = sysProjectInfoDao.getSysProjectInfoByUserNo(req.getUserNo());
        if(CollectionUtils.isNotEmpty(list)){
            ListCopyUtil.listCopyProperties(list,dtos,SysProjectInfoDTO.class);
        }
        return new BizResult<List<SysProjectInfoDTO>>(dtos);
    }
}
