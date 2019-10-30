package com.zxcv.busi.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.busi.domain.sys.TestCust;
import com.zxcv.api.commom.service.sys.param.query.QueryTestCustReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTestCustReq;

/**
 * 客户信息(测试) Dao接口
 * Copyright: Copyright (c) ${year}
 * @ClassName: TestCustDao.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-10-30
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-30         zxcv         v1.0.0               创建
 */
public interface TestCustDao {
    /**
     * 新增客户信息(测试)
     * @param req
     * @author: zxcv
     * @since 2019-10-30
     * @return
     */
    Integer  saveTestCust(SaveAndModifyTestCustReq req);

    /**
     * 修改客户信息(测试)
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    Integer  updateTestCustById(SaveAndModifyTestCustReq req);

    /**
     * 删除客户信息(测试)
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    Integer  deleteTestCust(SaveAndModifyTestCustReq req);

    /**
     * 查询客户信息(测试)对象
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    TestCust  selectTestCust(QueryTestCustReq req);


    /**
     * 分页-查询客户信息(测试)列表
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
   IPage<TestCust>  queryTestCustForPage(QueryTestCustReq req);
}
