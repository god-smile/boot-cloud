package com.zxcv.portal.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.constants.SessionEnum;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.sys.dto.AuthUserInfo;
import com.zxcv.api.commom.service.sys.dto.AuthUserInfoRes;
import com.zxcv.api.commom.service.sys.dto.LoginOathRes;
import com.zxcv.portal.common.vo.BizResultVO;
import com.zxcv.portal.common.vo.EasyUIDataGridVO;


/**
 * @描述: Copyright: Copyright (c) 2017 Alibb
 * @ClassName: BizController.java
 * @Description: 所有基于Spring MVC的Web控制器类（Action）的统一父类，提供一些便利的请求处理方法，如返回Json、文本数据等
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年2月23日  下午1:26:50
 * <p>
 * Modification History:
 * Date        Author        Version        Description
 * ---------------------------------------------------------*
 * 2017年2月23日     wangbiao       v1.0.0         创建
 */
public class BaseController {
    private static final String MIME_JSON = "application/json;charset=UTF-8";

    @Autowired
    private HttpSession session;

    /**
     * 返回jqgrid格式数据
     *
     * @param bizResult
     * @param voClass
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException 2017年5月12日 zhaowg
     */
    protected <DTO, VO> BizResultVO<EasyUIDataGridVO<VO>> returnJqGridData(BizResult<PageBean<DTO>> bizResult, Class<VO> voClass) throws InstantiationException, IllegalAccessException {
        PageBean<DTO> pageBean = getBizResultData(bizResult);
        //将DTO转换为VO
        List<VO> vos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(pageBean.getRows())) {
            for (DTO dto : pageBean.getRows()) {
                VO vo = voClass.newInstance();
                BeanUtils.copyProperties(dto, vo);
                vos.add(vo);
            }
        }
        //返回jqGrid数据
        EasyUIDataGridVO<VO> jqGridDatas = new EasyUIDataGridVO<>();
        jqGridDatas.setTotal(pageBean.getTotal() == null ? 0 : pageBean.getTotal());
        jqGridDatas.setRows(vos);

        BizResultVO<EasyUIDataGridVO<VO>> bizResultVO = new BizResultVO<>();
        bizResultVO.setCode(bizResult.getErrCode().getCode());
        bizResultVO.setMsg(bizResult.getErrMsg());
        bizResultVO.setData(jqGridDatas);

        return bizResultVO;
    }

    /**
     * 返回jqgrid格式数据
     *
     * @param bizResult
     * @return 2017年5月12日 zhaowg
     */
    protected <DTO> BizResultVO<EasyUIDataGridVO<DTO>> returnJqGridData(BizResult<PageBean<DTO>> bizResult) {
        PageBean<DTO> pageBean = getBizResultData(bizResult);
        //返回jqGrid数据
        EasyUIDataGridVO<DTO> jqGridDatas = new EasyUIDataGridVO<>();
        jqGridDatas.setTotal(pageBean.getTotal() == null ? 0 : pageBean.getTotal());
        jqGridDatas.setRows(pageBean.getRows());

        BizResultVO<EasyUIDataGridVO<DTO>> bizResultVO = new BizResultVO<>();
        bizResultVO.setCode(bizResult.getErrCode().getCode());
        bizResultVO.setMsg(bizResult.getErrMsg());
        bizResultVO.setData(jqGridDatas);

        return bizResultVO;
    }

    /**
     * 分页结果封装后返回标准格式JSON串.<br/>
     *
     * @param response
     * @param result
     */
    public void returnJsonDataGrid(HttpServletResponse response, BizResult<?> result) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (result == null) {
            throw new NullPointerException("result 为空,不能进行封装!");
        } else if (result.getData() == null) {
            throw new NullPointerException("pageBean 为空,不能进行封装!");
        } else {
            if (result.getData() instanceof PageBean<?>) {
                PageBean<?> pageBean = (PageBean<?>) result.getData();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("total", (null == pageBean.getTotal() ? 0 : pageBean.getTotal()));
                map.put("rows", pageBean.getRows() != null ? pageBean.getRows() : new ArrayList<Object>());
                resultMap.put("code", result.getErrCode().getCode());
                resultMap.put("msg", result.getErrMsg());
                resultMap.put("data", map);

            } else {
                throw new ClassCastException("result.getData() 类型转换异常");
            }

        }
        this.returnJson(response, resultMap);
    }


    /**
     * 获取返回的数据
     *
     * @param bizResult
     * @return 2017年5月16日 zhaowg
     */
    public <T> T getBizResultData(BizResult<T> bizResult) {
        //有异常，抛出
        if (!bizResult.isSuccess() || !bizResult.getErrCode().getCode().equals(ErrorType.BIZ_SUCCESS.getCode())) {
            throw new BizException(bizResult.getErrCode(), bizResult.getErrMsg());
        }
        return bizResult.getData();
    }

    /**
     * 返回JSon格式的数据
     *
     * @param response
     * @param data
     * @throws Exception
     */
    public String returnJson(HttpServletResponse response, Object data) {

        return returnText(response, JSONObject.toJSONString(data), MIME_JSON);
    }

    /**
     * 返回xml格式的数据
     *
     * @param response
     * @param text
     * @throws Exception
     */
    public String returnXml(HttpServletResponse response, CharSequence text) {
        return returnText(response, text, "text/xml;charset=UTF-8");
    }

    /**
     * 返回文本数据
     *
     * @param response
     * @param text
     * @param contenttype 内容类型，如：text/plain、text/xml、application/json、text/json、text/javascript、application/javascript（不支持旧浏览器）
     * @param encoding    字符集编码，如：GB18030、UTF-8，不建议使用GB2312和GBK
     * @throws Exception
     */
    public String returnText(HttpServletResponse response, CharSequence text, final String contenttype, final String encoding) {
        return returnText(response, text, contenttype + ";charset=" + encoding);
    }

    /**
     * 返回文本数据
     *
     * @param response
     * @param text
     * @param contenttype
     * @throws IOException
     * @author lihl2 2011-3-25
     */
    public String returnText(HttpServletResponse response, CharSequence text, final String contenttype) {
        response.setContentType(contenttype);
        if (text != null) {
            try {
                response.getWriter().write(text.toString());
            } catch (IOException e) {
                throw new BizException(ErrorType.BIZ_ERROR, e);
            }
        }
        return null;
    }

    /**
     * 设置文件头格式
     *
     * @param response
     * @param mimeType
     * @param fileName
     * @param size
     */
    public void setFileHeader(HttpServletResponse response, CharSequence mimeType,
                              final CharSequence fileName, int size) {
        response.reset();
        // 设置response的Header
        if (mimeType != null) {
            response.setContentType(mimeType.toString());
        }
        try {
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.toString().getBytes("GB18030"), "ISO-8859-1"));
            response.setHeader("Access-Control-Allow-Origin","*");
        } catch (UnsupportedEncodingException e) {
            throw new BizException(ErrorType.BIZ_ERROR, "文件名编码转换失败");
        }
        if (size > 0) {
            response.addIntHeader("Content-Length", size);
        }
    }

    /**
     * 设置浏览器返回类型为Excel文件
     *
     * @param response
     * @param mimeType
     * @param fileName
     * @param size
     */
    public void setExcelFileHeader(HttpServletResponse response, CharSequence mimeType,
                                   final CharSequence fileName, int size) {
        setFileHeader(response, "application/vnd.ms-excel", fileName, size);
    }

    /**
     * 文件下载
     *
     * @param response
     * @param mimeType
     * @param fileName
     * @param file
     * @param size
     */
    public void downloadFile(HttpServletResponse response, CharSequence mimeType,
                             final CharSequence fileName, InputStream file, int size) {
        setFileHeader(response, mimeType, fileName, size);
        try {
            OutputStream out = response.getOutputStream();
            int l;
            while ((l = file.read()) >= 0) {
                out.write(l);
            }
            out.flush();
        } catch (IOException e) {
            throw new BizException(ErrorType.BIZ_ERROR, "下载文件失败");
        } finally {
            if (null != file) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    /**
     * 返回jqgrid格式数据
     *
     * @param bizResult
     * @param voClass
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException 2017年5月12日 zhaowg
     */
    protected <DTO, VO> BizResultVO<EasyUIDataGridVO<VO>> returnJqGridDataByList(BizResult<List<DTO>> bizResult, int total, Class<VO> voClass) throws InstantiationException, IllegalAccessException {
        //List<DTO> pageBean = getBizResultData(bizResult);
        //将DTO转换为VO
        List<VO> vos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(bizResult.getData())) {
            for (DTO dto : bizResult.getData()) {
                VO vo = voClass.newInstance();
                BeanUtils.copyProperties(dto, vo);
                vos.add(vo);
            }
        }
        //返回jqGrid数据
        EasyUIDataGridVO<VO> jqGridDatas = new EasyUIDataGridVO<>();

        jqGridDatas.setTotal(total);
        jqGridDatas.setRows(vos);

        BizResultVO<EasyUIDataGridVO<VO>> bizResultVO = new BizResultVO<>();
        bizResultVO.setCode(bizResult.getErrCode().getCode());
        bizResultVO.setMsg(bizResult.getErrMsg());
        bizResultVO.setData(jqGridDatas);

        return bizResultVO;
    }


    /**
     * 获取登陆token
     *
     * @return 2019年6月23日 wangfs
     */
    public LoginOathRes getLoginOath() {
        LoginOathRes loginOathRes = (LoginOathRes) session.getAttribute(SessionEnum.LOGIN_USER_TOKEN.key());
        return loginOathRes;
    }

    /**
     * 获取登陆用户信息
     *
     * @return 2019年6月23日 wangfs
     */
    public AuthUserInfo getUserInfo() {
        AuthUserInfoRes userInfoRes = (AuthUserInfoRes) session.getAttribute(SessionEnum.USER_INFO.key());
        if(null !=userInfoRes){
            AuthUserInfo authUserInfo = userInfoRes.getAuthUserInfo();
            authUserInfo.setPlNos(authUserInfo.getPlNos());
            return authUserInfo;
        }
        return null;
    }
    public static <T> void  nullToEmpty(T bean) {
        Field[] field = bean.getClass().getDeclaredFields();
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String name = field[j].getName();    //获取属性的名字
            //将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            String type = field[j].getGenericType().toString();    //获取属性的类型
            if (type.equals("class java.lang.String")) {   //如果type是类类型，则前面包含"class "，后面跟类名
                try {
                    Method mGet = bean.getClass().getMethod("get" + name);
                    String value = (String) mGet.invoke(bean);    //调用getter方法获取属性值
                    if (value == null || "".equals(value)) {
                        Method mSet = bean.getClass().getMethod("set" + name, new Class[]{String.class});
                        mSet.invoke(bean, new Object[]{new String("")});
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
