package com.zxcv.commom.filter.dubbo;

import org.slf4j.MDC;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.zxcv.commom.constants.TrackLogConstants;

@Activate(group = Constants.PROVIDER)
public class RPCProviderFilter implements Filter {
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String trackId = invocation.getAttachment(TrackLogConstants.TRACKID);
		Result result = null;
		try{
			MDC.put(TrackLogConstants.TRACKID,trackId);
			result =  invoker.invoke(invocation);
		}finally {
			MDC.remove(TrackLogConstants.TRACKID);
		}
		return result;
	}

}
