package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysAttachmentInfoService;
import com.zxcv.api.commom.service.sys.dto.SysAttachmentInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysAttachmentInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysAttachmentInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 合同附件信息表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysAttachmentInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-12-08
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-12-08         zxcv         v1.0.0               创建
  */
@Api(value = "合同附件信息表管理", description = "合同附件信息表管理")
@RestController
@RequestMapping("/sysAttachmentInfo")
public class SysAttachmentInfoController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SysAttachmentInfoController.class);

    @Autowired
    private SysAttachmentInfoService sysAttachmentInfoService;


    @ApiOperation("新增合同附件信息表")
    @PostMapping("/saveSysAttachmentInfo")
    public BizResultVO<Integer> saveSysAttachmentInfo(@RequestBody SaveAndModifySysAttachmentInfoReq req) {
        req.setCreateTime(new Date());
        req.setCreateEmpId(getLoginUserNo());
        req.setCreateEmpName(getLoginUserName());
        logger.info("begin新增合同附件信息表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysAttachmentInfoService.saveSysAttachmentInfo(req);
        logger.info("end新增合同附件信息表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改合同附件信息表")
    @PostMapping("/updateSysAttachmentInfoById")
    public BizResultVO<Integer> updateSysAttachmentInfoById(@RequestBody SaveAndModifySysAttachmentInfoReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin修改合同附件信息表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysAttachmentInfoService.updateSysAttachmentInfoById(req);
        logger.info("end修改合同附件信息表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除合同附件信息表")
    @PostMapping("/deleteSysAttachmentInfo")
    public BizResultVO<Integer> deleteSysAttachmentInfo(@RequestBody SaveAndModifySysAttachmentInfoReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin删除合同附件信息表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysAttachmentInfoService.deleteSysAttachmentInfo(req);
        logger.info("end删除合同附件信息表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询合同附件信息表对象")
    @PostMapping("/selectSysAttachmentInfo")
    public BizResultVO<SysAttachmentInfoDTO> selectSysAttachmentInfo(@RequestBody QuerySysAttachmentInfoReq req) {
        logger.info("begin查询合同附件信息表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysAttachmentInfoDTO> result = sysAttachmentInfoService.selectSysAttachmentInfo(req);
        logger.info("end查询合同附件信息表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SysAttachmentInfoDTO>(result);
    }

    @ApiOperation("分页-合同附件信息表对象")
    @PostMapping("/querySysAttachmentInfoForPage")
    public BizResultVO<PageBean<SysAttachmentInfoDTO>> querySysAttachmentInfoForPage(@RequestBody QuerySysAttachmentInfoReq req) {
        logger.info("begin分页-查询合同附件信息表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysAttachmentInfoDTO>> result = sysAttachmentInfoService.querySysAttachmentInfoForPage(req);
        logger.info("end分页查询合同附件信息表controller,结果...");
        return new BizResultVO<PageBean<SysAttachmentInfoDTO>>(result);
    }

}

