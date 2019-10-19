package com.zxcv.commom.utils.pagepager;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.bean.PageBean;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页插件结果转换工具类.<br/>
 *
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: PageBeanUtil.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2017年4月19日   下午4:03:33
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年4月19日      wangfs           v1.0.0               创建
 */
public class PageBeanUtil {

    /**
     * 将PageInfo 转换成PageBean.<br/>
     *
     * @param form  PageInfo<R> 对象.<br/>
     * @param to    PageBean<L> 对象.<br/>
     * @param clazz
     */
    public static <R, L> void copyProperties(IPage<R> form, PageBean<L> to, Class<L> clazz) {
        if (form != null && to != null && clazz != null) {
            List<L> list = new ArrayList<L>();
            if (CollectionUtils.isNotEmpty(form.getRecords())) {

                for (R source : form.getRecords()) {
                    if (null == source) {
                        continue;
                    }
                    try {
                        L target = clazz.newInstance();
                        BeanUtils.copyProperties(source, target);
                        list.add(target);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                to.setDataList(list);
                to.setPageNum(Integer.valueOf(form.getCurrent()+""));
                to.setPageSize(Integer.valueOf(form.getSize()+""));
                to.setPages(Integer.valueOf(form.getPages()+""));
                to.setPageTotals(Integer.valueOf(String.valueOf(form.getTotal())));
            }
        } else {
            try {
                throw new Exception("源对象,目标对象,clazz 不能为空!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
