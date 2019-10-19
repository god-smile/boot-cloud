package com.zxcv.commom.utils;

import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.exception.BizException;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: com.zteits.oauth.portal.util
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/5/10   下午3:12
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/5/10      atao          v1.0.0          创建
 */
public class ResultUtils {

    public static boolean isSuccess(BizResult<?> result) {
        if (null != result && result.isSuccess() && ErrorType.BIZ_SUCCESS.getCode().equals(result.getErrCode().getCode())) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isError(BizResult<?> result) {
        return !isSuccess(result);
    }


    /**
     * 获取返回的数据
	 * @param bizResult
	 * @return
	 * 2017年5月16日 zhaowg
	 */
	public static <T>  T getBizResultData(BizResult<T> bizResult){
		//有异常，抛出
		if(!bizResult.isSuccess() || !bizResult.getErrCode().getCode().equals(ErrorType.BIZ_SUCCESS.getCode())){
			throw new BizException(bizResult.getErrCode(),bizResult.getErrMsg(),false);
		}
		return bizResult.getData();
	}
	

}
