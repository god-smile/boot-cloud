package com.zxcv.commom.filter.dubbo;

import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.commom.constants.TrackLogConstants;
import com.zxcv.commom.utils.BeanValidatorsUtils;
import com.zxcv.commom.utils.ExceptionUtil;

@Activate(group = Constants.CONSUMER)
public class RPCConsumerFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(RPCConsumerFilter.class);
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
//		Object[] invocat = invocation.getArguments();

		Long startTime = System.currentTimeMillis();
		logger.info("开始调用Dubbo接口,本机IP:{},方法名称："+invoker.getInterface().getName()+"."+invocation.getMethodName()+"() 方法。", RpcContext.getContext().getLocalHost());

		String trackId = MDC.get(TrackLogConstants.TRACKID);
		if(StringUtils.isBlank(trackId)){
			trackId = UUID.randomUUID().toString().replaceAll("-","");
		}
		RpcContext.getContext().setAttachment(TrackLogConstants.TRACKID,trackId);

		Result result =  invoker.invoke(invocation);

		Long endTime = System.currentTimeMillis();
		logger.info("结束调用Dubbo接口,远程IP:{},耗时:{}秒,方法名称："+invoker.getInterface().getName()+"."+invocation.getMethodName()+"() 方法。", RpcContext.getContext().getRemoteHost(),(endTime-startTime)/1000);

		Throwable t = result.getException();
		
		if(t!=null && (t instanceof BizException)) {
			BizException bizException = (BizException)t;
			
			BizResult<?> rs = new BizResult<Object>((ErrorType) bizException.getErrCode(),bizException.getErrMsg());
			rs.setHelpMsg(ExceptionUtil.getTrace(bizException));
			RpcResult rpcr = (RpcResult)result;
			rpcr.setValue(rs);
			//判断是否需要打印异常信息
			if(bizException.isPrintExceptionMsg()){
				logger.error("[业务异常->errorCode="+bizException.getErrCode()+",errorMsg="+bizException.getErrMsg()+"]",t);

			}else{
				logger.error("[业务异常->errorCode="+bizException.getErrCode()+",errorMsg="+bizException.getErrMsg()+"]");
			}

			rpcr.setException(null);
		}else if(t!=null && (t instanceof ConstraintViolationException)){
			List<String> errMsgs = BeanValidatorsUtils.extractPropertyAndMessageAsList((ConstraintViolationException)t, ": ");
			BizResult<?> rs = new BizResult<>(ErrorType.PARAM_NOT_VALID, "参数校验失败:"+ JSONObject.toJSONString(errMsgs));
			RpcResult rpcr = (RpcResult)result;
			rpcr.setValue(rs);
			logger.error("[业务异常->errorCode="+ErrorType.PARAM_NOT_VALID.getCode()+",errorMsg="+"参数校验失败:"+ JSONObject.toJSONString(errMsgs)+"]",t);
			rpcr.setException(null);
		}
		return result;
	}

}
