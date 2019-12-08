package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysProjectItemService;
import com.zxcv.api.commom.service.sys.dto.SysProjectItemDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectItemReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectItemReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 项目类别 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysProjectItemController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-12-08
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-12-08         zxcv         v1.0.0               创建
  */
@Api(value = "项目类别管理", description = "项目类别管理")
@RestController
@RequestMapping("/sysProjectItem")
public class SysProjectItemController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SysProjectItemController.class);

    @Autowired
    private SysProjectItemService sysProjectItemService;


    @ApiOperation("新增项目类别")
    @PostMapping("/saveSysProjectItem")
    public BizResultVO<Integer> saveSysProjectItem(@RequestBody SaveAndModifySysProjectItemReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增项目类别信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysProjectItemService.saveSysProjectItem(req);
        logger.info("end新增项目类别信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改项目类别")
    @PostMapping("/updateSysProjectItemById")
    public BizResultVO<Integer> updateSysProjectItemById(@RequestBody SaveAndModifySysProjectItemReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改项目类别信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysProjectItemService.updateSysProjectItemById(req);
        logger.info("end修改项目类别信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除项目类别")
    @PostMapping("/deleteSysProjectItem")
    public BizResultVO<Integer> deleteSysProjectItem(@RequestBody SaveAndModifySysProjectItemReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除项目类别controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysProjectItemService.deleteSysProjectItem(req);
        logger.info("end删除项目类别 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询项目类别对象")
    @PostMapping("/selectSysProjectItem")
    public BizResultVO<SysProjectItemDTO> selectSysProjectItem(@RequestBody QuerySysProjectItemReq req) {
        logger.info("begin查询项目类别对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysProjectItemDTO> result = sysProjectItemService.selectSysProjectItem(req);
        logger.info("end查询项目类别对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SysProjectItemDTO>(result);
    }

    @ApiOperation("分页-项目类别对象")
    @PostMapping("/querySysProjectItemForPage")
    public BizResultVO<PageBean<SysProjectItemDTO>> querySysProjectItemForPage(@RequestBody QuerySysProjectItemReq req) {
        logger.info("begin分页-查询项目类别controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysProjectItemDTO>> result = sysProjectItemService.querySysProjectItemForPage(req);
        logger.info("end分页查询项目类别controller,结果...");
        return new BizResultVO<PageBean<SysProjectItemDTO>>(result);
    }

}

