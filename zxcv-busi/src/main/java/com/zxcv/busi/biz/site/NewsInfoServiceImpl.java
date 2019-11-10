package com.zxcv.busi.biz.site;
import com.zxcv.busi.domain.site.NewsInfo;
import com.zxcv.busi.dao.site.NewsInfoDao;
import com.zxcv.api.commom.service.site.NewsInfoService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.zxcv.api.commom.service.site.dto.NewsInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QueryNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifyNewsInfoReq;
import com.zxcv.commom.utils.pagepager.PageBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 新闻表 服务实现类
 * Copyright: Copyright (c)
 * @ClassName: NewsInfoServiceImpl.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-11-09
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-11-09         zxcv         v1.0.0               创建
 */
@Service("com.zxcv.busi.biz.site.NewsInfoServiceImpl")
public class NewsInfoServiceImpl  implements NewsInfoService {

    private static final Logger logger = LoggerFactory.getLogger(NewsInfoServiceImpl.class);

    @Autowired
    private NewsInfoDao newsInfoDao;

     /**
      * 新增新闻表
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> saveNewsInfo(SaveAndModifyNewsInfoReq req) {
         logger.info("begin调用新闻表service层add()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int insertCount = newsInfoDao.saveNewsInfo(req);
         logger.info("end调用新闻表service层add()方法,插入条数=【{}】条。", insertCount);
         return new BizResult<Integer>(insertCount);
     }

     /**
      * 修改新闻表
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> updateNewsInfoById(SaveAndModifyNewsInfoReq req) {
         logger.info("begin调用新闻表service层update()方法,入参={}", JSONObject.toJSON(req));
         if (req == null || null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         int updateCount = newsInfoDao.updateNewsInfoById(req);
         logger.info("end调用新闻表service层update()方法,修改条数=【{}】条。", updateCount);
         return new BizResult<Integer>(updateCount);
     }

     /**
      * 删除新闻表
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public BizResult<Integer> deleteNewsInfo(SaveAndModifyNewsInfoReq req) {
         logger.info("begin调用新闻表service层delete()方法,入参={}", JSONObject.toJSON(req));
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
         if (CollectionUtils.isEmpty(req.getIds())) {
             throw new BizException(ErrorType.PARAMM_NULL, "id为空!");
         }
		 int deleteCount = newsInfoDao.deleteNewsInfo(req);
         logger.info("end调用新闻表service层delete()方法,删除条数=【{}】条。", deleteCount);
         return new BizResult<Integer>(deleteCount);
     }

     /**
      * 查询新闻表对象
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      *
      */
     @Override
     public BizResult<NewsInfoDTO> selectNewsInfo(QueryNewsInfoReq req) {
         logger.info("begin调用新闻表service层查询对象()方法,入参={}", JSONObject.toJSON(req));
         NewsInfoDTO newsInfoDTO = new NewsInfoDTO();
         if (StringUtils.isBlank(req.getNewsNo()) && null == req.getId()) {
             throw new BizException(ErrorType.PARAMM_NULL, "查询参数为空!");
         }
         NewsInfo obj = newsInfoDao. selectNewsInfo(req);
         if (null != obj) {
             BeanUtils.copyProperties(obj,newsInfoDTO);
         }
         logger.info("end调用新闻表service层查询对象方法,结果=【{}】", JSONObject.toJSON(newsInfoDTO));
         return new BizResult<NewsInfoDTO>(newsInfoDTO);
     }

     /**
      * 分页-查询新闻表列表
      *
      * @author: zxcv
      * @since 2019-11-09
      * @param req
      * @return
      */
     @Override
     public BizResult<PageBean<NewsInfoDTO>> queryNewsInfoForPage(QueryNewsInfoReq req) {
         logger.info("begin调用service层分页-查询新闻表列表()方法,入参={}", JSONObject.toJSON(req));
         PageBean<NewsInfoDTO> pageBean = new PageBean<NewsInfoDTO>();
         if (req == null) {
             throw new BizException(ErrorType.PARAMM_NULL, "入参为空!");
         }
	     IPage<NewsInfo> pageInfo = newsInfoDao.queryNewsInfoForPage(req);
         if (null != pageInfo) {
             PageBeanUtil.copyProperties(pageInfo, pageBean, NewsInfoDTO.class);
         }
         logger.info("end调用service-查询新闻表列表分页()方法,查询条数={}条。", pageBean.getTotal());
         return new BizResult<PageBean<NewsInfoDTO>>(pageBean);
     }
}
