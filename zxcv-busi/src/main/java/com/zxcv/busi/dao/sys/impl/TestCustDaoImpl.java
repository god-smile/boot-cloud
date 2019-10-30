package com.zxcv.busi.dao.sys.impl;
import com.zxcv.api.commom.constants.DataStatusEnum;
import com.zxcv.busi.domain.sys.TestCust;
import com.zxcv.busi.mapper.sys.TestCustMapper;
import org.springframework.stereotype.Component;
import com.zxcv.busi.dao.sys.TestCustDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zxcv.api.commom.service.sys.param.query.QueryTestCustReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTestCustReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 客户信息(测试) 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: TestCustDaoImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-10-30
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-30         zxcv         v1.0.0               创建
 */
@Component
public class TestCustDaoImpl  implements TestCustDao {

    @Autowired
    private TestCustMapper testCustMapper;

     /**
      * 新增客户信息(测试)
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public Integer saveTestCust(SaveAndModifyTestCustReq req) {
         TestCust testCust = new TestCust();
         BeanUtils.copyProperties(req, testCust);
         int insertCount = testCustMapper.insert(testCust);
         return insertCount;
     }

     /**
      * 修改客户信息(测试)
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public Integer updateTestCustById(SaveAndModifyTestCustReq req) {
         TestCust testCust = new TestCust();
         BeanUtils.copyProperties(req, testCust);
         int updateCount = testCustMapper.updateById(testCust);
         return updateCount;
     }

     /**
      * 删除客户信息(测试)
      * @author: zxcv
      * @since 2019-10-30
      * @param req
      * @return
      */
     @Override
     public Integer deleteTestCust(SaveAndModifyTestCustReq req) {
         TestCust testCust = new TestCust();
         BeanUtils.copyProperties(req, testCust);
         UpdateWrapper<TestCust> updateWrapper = new UpdateWrapper<>();
         updateWrapper.lambda().in(TestCust::getId, req.getIds());
         updateWrapper.lambda().set(TestCust::getDataState,DataStatusEnum.DATA_STATUS_NO_VALID.getValue())
         .set(TestCust::getModifyEmpId, req.getModifyEmpId())
         .set(TestCust::getModifyEmpName, req.getModifyEmpName())
         .set(TestCust::getModifyTime, req.getModifyTime());
		 int deleteCount = testCustMapper.update(testCust, updateWrapper);
         return deleteCount;
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
     public TestCust selectTestCust(QueryTestCustReq req) {
         TestCust testCustQuery = new TestCust();
         BeanUtils.copyProperties(req, testCustQuery);
         QueryWrapper<TestCust> querySQL = new QueryWrapper<TestCust>();
         querySQL.setEntity(testCustQuery);
         TestCust obj = testCustMapper.selectOne(querySQL);
         return obj;
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
     public IPage<TestCust> queryTestCustForPage(QueryTestCustReq req) {
         //1.设置分页
         Page<TestCust> page = new Page<>(req.getPageReq().getPageNum(), req.getPageReq().getPageSize());
         //2.查询数据
         QueryWrapper<TestCust> queryWrapper = new QueryWrapper<TestCust>();
         queryWrapper.lambda().eq(true, TestCust::getDataState,DataStatusEnum.DATA_STATUS_VALID.getValue())
         .eq(req.getId() != null, TestCust::getId,req.getId());
         //TODO自定义查询条件
         queryWrapper.lambda().orderByDesc(TestCust::getId);
	     IPage<TestCust> pageInfo = testCustMapper.selectPage(page, queryWrapper);

         return pageInfo;
     }
}
