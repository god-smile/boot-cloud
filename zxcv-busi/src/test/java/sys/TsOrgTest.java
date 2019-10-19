package sys;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.TsOpService;
import com.zxcv.api.commom.service.sys.dto.TsOpDTO;
import com.zxcv.api.commom.service.sys.param.query.QueryTsOpReq;
import com.zxcv.busi.ZXCVBusiApplication;
import com.zxcv.busi.domain.sys.TsOp;
import com.zxcv.busi.mapper.sys.TsOpMapper;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: TsOrgTest.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-07-01 14:35
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-07-01     wangfs              v1.0.0               创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZXCVBusiApplication.class)
public class TsOrgTest {

    @Autowired
    private TsOpMapper tsOpMapper;
    @Autowired
    private TsOpService tsOpService;

    @Test
    public void testSelectOp(){
        QueryWrapper<TsOp> queryWrapper =  new QueryWrapper<TsOp>();
        queryWrapper.lambda().eq(TsOp::getDataState,1);
        List<TsOp> list = tsOpMapper.selectList(queryWrapper);
        

        System.out.print(JSONObject.toJSONString(list));
    }
    
    @Test
    public void testQueryOp(){
       
        QueryTsOpReq req = new QueryTsOpReq();
		BizResult<PageBean<TsOpDTO>> list = tsOpService.queryTsOpForPage(req );

        System.out.print(JSONObject.toJSONString(list));
    }

}
