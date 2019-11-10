package sys;

import com.zxcv.api.commom.constants.NoPrefixEnum;
import com.zxcv.commom.utils.SequenceUtil;

/**
 * 测试雪花算法
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: SequenceTest.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfei
 * @date: 2019年11月9日   下午3:31:00
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019年11月9日      wangfei          v1.0.0          创建
 */
public class UtilsTest {
    public  static void main(String []args){
        System.out.print(SequenceUtil.getNextId(NoPrefixEnum.NEWS_NO.getValue()));
    }
}