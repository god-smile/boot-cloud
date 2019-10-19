package com.zxcv.commom.constants;

/**
 * key值推荐格式：域名:表名:功能名
 * 
 * Copyright: Copyright (c) 2017  zteits
 * @ClassName: com.zteits.oauth.portal.constants
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/5/9   下午5:55
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/5/9      atao          v1.0.0          创建
 */
public enum RedisKeyEnum {

	//字典表数据缓存
	SYS_CODE_DEF_KIND_VAL("park_cloud:ts_code_def:kind_val"),
    /**组织缓存key.*/
    SYS_ORG_KEY("sys_org_key"),


    THIRD_AUTH_APPID("park_cloud:tp_third_authorization:app_id") ,

    THIRD_AUTH_LIST("park_cloud:tp_third_authorization:third_auth"),

    //停车场信息-HASH类型，hkey:pl_no(停车场编号),hvalue:停车场信息
    PARK_PARKINGLOT_PLNO_PARKLOTINFO("park_cloud:tp_parking_lot:plNo_parkLotInfo"),
    //停车场数据缓存
  	PARK_PARKING_LOT("park_cloud:tp_parking_lot:park"),
  	//停车场经纬度缓存
  	PARK_PARKING_LOT_GEO("park_cloud:tp_parking_lot:park_geo"),


  	;

    private String key;

    RedisKeyEnum(String key) {
        this.key = key;

    }

    public String key() {
        return key;
    }
}
