package com.zxcv.api.commom.constants;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: IEnum.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-06-01 11:39
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-06-01     wangfs              v1.0.0               创建
 */
public interface IEnum<T extends Serializable> {

    T getValue();
}
