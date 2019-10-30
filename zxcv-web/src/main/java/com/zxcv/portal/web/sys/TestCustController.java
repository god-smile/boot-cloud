package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.TestCustService;
import com.zxcv.api.commom.service.sys.dto.TestCustDTO;
import com.zxcv.api.commom.service.sys.param.query.QueryTestCustReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTestCustReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 客户信息(测试) 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: TestCustController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-10-30
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-10-30         zxcv         v1.0.0               创建
  */
@Api(value = "客户信息(测试)管理", description = "客户信息(测试)管理")
@RestController
@RequestMapping("/testCust")
public class TestCustController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(TestCustController.class);

    @Autowired
    private TestCustService testCustService;


    @ApiOperation("新增客户信息(测试)")
    @PostMapping("/saveTestCust")
    public BizResultVO<Integer> saveTestCust(@RequestBody SaveAndModifyTestCustReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增客户信息(测试)信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = testCustService.saveTestCust(req);
        logger.info("end新增客户信息(测试)信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改客户信息(测试)")
    @PostMapping("/updateTestCustById")
    public BizResultVO<Integer> updateTestCustById(@RequestBody SaveAndModifyTestCustReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改客户信息(测试)信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = testCustService.updateTestCustById(req);
        logger.info("end修改客户信息(测试)信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除客户信息(测试)")
    @PostMapping("/deleteTestCust")
    public BizResultVO<Integer> deleteTestCust(@RequestBody SaveAndModifyTestCustReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除客户信息(测试)controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = testCustService.deleteTestCust(req);
        logger.info("end删除客户信息(测试) controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询客户信息(测试)对象")
    @PostMapping("/selectTestCust")
    public BizResultVO<TestCustDTO> selectTestCust(@RequestBody QueryTestCustReq req) {
        logger.info("begin查询客户信息(测试)对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<TestCustDTO> result = testCustService.selectTestCust(req);
        logger.info("end查询客户信息(测试)对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<TestCustDTO>(result);
    }

    @ApiOperation("分页-客户信息(测试)对象")
    @PostMapping("/queryTestCustForPage")
    public BizResultVO<PageBean<TestCustDTO>> queryTestCustForPage(@RequestBody QueryTestCustReq req) {
        logger.info("begin分页-查询客户信息(测试)controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<TestCustDTO>> result = testCustService.queryTestCustForPage(req);
        logger.info("end分页查询客户信息(测试)controller,结果...");
        return new BizResultVO<PageBean<TestCustDTO>>(result);
    }

}

