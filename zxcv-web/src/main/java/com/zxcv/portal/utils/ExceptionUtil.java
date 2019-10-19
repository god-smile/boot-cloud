package com.zxcv.portal.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.zxcv.api.commom.exception.AppException;

public class ExceptionUtil {
    
    public static String getTrace(Throwable t) {
    	StringBuffer buffer = new StringBuffer();
    	if(t==null){
			return "";
		}
		if(t instanceof AppException) {
			AppException bizException = (AppException)t;
			buffer.append("错误信息为："+bizException.getErrMsg()+"\n");
		}
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        //设置堆栈信息
        buffer.append("堆栈信息为:" + stringWriter.getBuffer().toString());
        return buffer.toString();
    }

}
