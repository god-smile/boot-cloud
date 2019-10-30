package com.zxcv.busi.biz.sys;
import com.zxcv.busi.domain.sys.TestCust;
import com.zxcv.busi.dao.sys.TestCustDao;
import com.zxcv.api.commom.service.sys.TestCustService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;

import com.zxcv.api.commom.service.sys.dto.TestCustDTO;
import com.zxcv.api.commom.service.sys.param.query.QueryTestCustReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTestCustReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户信息(测试) 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: TestCustServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-10-30
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-30         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.sys.TestCustServiceImpl")
public class TestCustServiceImpl  implements TestCustService {

    private static final Logger logger = LoggerFactory.getLogger(TestCustServiceImpl.class);

    @Autowired
    private TestCustDao testCustDao;

     /**
      * 新增客户信息(测试)
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveTestCust(SaveAndModifyTestCustReq req) {
         logger.info("begin调用客户信息(测试)service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = testCustDao.saveTestCust(req);
         logger.info("end调用客户信息(测试)service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改客户信息(测试)
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateTestCustById(SaveAndModifyTestCustReq req) {
         logger.info("begin调用客户信息(测试)service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         int updateCount = testCustDao.updateTestCustById(req);
         logger.info("end调用客户信息(测试)service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除客户信息(测试)
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteTestCust(SaveAndModifyTestCustReq req) {
         logger.info("begin调用客户信息(测试)service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = testCustDao.deleteTestCust(req);
         logger.info("end调用客户信息(测试)service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询客户信息(测试)对象
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<TestCustDTO> selectTestCust(QueryTestCustReq req) {
         logger.info("begin调用客户信息(测试)service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         TestCustDTO testCustDTO = new TestCustDTO();
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
         TestCust obj = testCustDao. selectTestCust(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,testCustDTO);
         }
         logger.info("end调用客户信息(测试)service层查询对象方法,结果=【{}】", JSONObject.toJSON(testCustDTO));
         return new BizResult<TestCustDTO>(testCustDTO);
     }

     /**
      * 分页-查询客户信息(测试)列表
      *
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<TestCustDTO>> queryTestCustForPage(QueryTestCustReq req) {
         logger.info("begin调用service层分页-查询客户信息(测试)列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<TestCustDTO> pageBean = new PageBean<TestCustDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<TestCust> pageInfo = testCustDao.queryTestCustForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, TestCustDTO.class);
         }
         logger.info("end调用service-查询客户信息(测试)列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<TestCustDTO>>(pageBean);
     }
}
