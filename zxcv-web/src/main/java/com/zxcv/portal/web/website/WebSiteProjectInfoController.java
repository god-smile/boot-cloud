package com.zxcv.portal.web.website;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.service.sys.SysProjectInfoService;
import com.zxcv.api.commom.service.sys.dto.SysProjectInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.ProjectReq;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectInfoReq;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 项目表 前端控制器
 * Copyright: Copyright (c) ${year}
 * @ClassName: SysProjectInfoController.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Api(value = "项目表管理", description = "项目表管理")
@RestController
@RequestMapping("/webSiteProjectInfo")
public class WebSiteProjectInfoController extends BaseController {
private static final Logger logger = LoggerFactory.getLogger(WebSiteProjectInfoController.class);

   @Autowired
   private SysProjectInfoService sysProjectInfoService;

	@ApiOperation("根据url查询项目")
	@PostMapping("/getWebSiteProjectInfoByUrl")
	public BizResultVO<SysProjectInfoDTO> getWebSiteProjectInfoByUrl(@RequestBody ProjectReq req) {
		logger.info("begin-根据url查询项目,入参={}", JSONObject.toJSON(req));
		BizResult<SysProjectInfoDTO> result = sysProjectInfoService.getSysProjectInfoByUrl(req);
		logger.info("end根据url查询项目controller,结果={}", JSONObject.toJSON(result));
		return new BizResultVO<SysProjectInfoDTO>(result);
	}
}

