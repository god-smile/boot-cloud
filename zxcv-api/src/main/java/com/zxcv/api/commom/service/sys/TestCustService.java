package com.zxcv.api.commom.service.sys;

import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.dto.TestCustDTO;
import com.zxcv.api.commom.service.sys.param.query.QueryTestCustReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTestCustReq;

/**
 * 客户信息(测试) Service服务类
 * Copyright: Copyright (c) ${year}
 * @ClassName: TestCustService.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-10-30
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-30         zxcv         v1.0.0               创建
 */
public interface TestCustService {
    /**
     * 新增客户信息(测试)
     * @param req
     * @author: zxcv
     * @since 2019-10-30
     * @return
     */
    BizResult<Integer>  saveTestCust(SaveAndModifyTestCustReq req);

    /**
     * 修改客户信息(测试)
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    BizResult<Integer>  updateTestCustById(SaveAndModifyTestCustReq req);

    /**
     * 删除客户信息(测试)
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    BizResult<Integer>  deleteTestCust(SaveAndModifyTestCustReq req);

    /**
     * 查询客户信息(测试)对象
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    BizResult<TestCustDTO>  selectTestCust(QueryTestCustReq req);


    /**
     * 分页-查询客户信息(测试)列表
     * @author: zxcv
     * @since 2019-10-30
     * @param req
     * @return
     */
    BizResult<PageBean<TestCustDTO>>  queryTestCustForPage(QueryTestCustReq req);
}
