/*
Navicat MySQL Data Transfer

Source Server         : 飞飞阿里云
Source Server Version : 50717
Source Host           : 182.92.118.137:8002
Source Database       : zxcv

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-04-04 14:44:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for site_company_info
-- ----------------------------
DROP TABLE IF EXISTS `site_company_info`;
CREATE TABLE `site_company_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_no` varchar(32) DEFAULT NULL COMMENT '分公司编号',
  `project_no` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `name` varchar(128) DEFAULT NULL COMMENT '分公司名称',
  `address` varchar(512) DEFAULT NULL COMMENT '分公司地址',
  `phone` varchar(128) DEFAULT NULL COMMENT '电话',
  `fax` varchar(128) DEFAULT NULL COMMENT '传真',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `postcode` varchar(128) DEFAULT NULL COMMENT '邮编',
  `order_level` int(4) DEFAULT NULL COMMENT '排序等级',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分公司表';

-- ----------------------------
-- Table structure for site_config
-- ----------------------------
DROP TABLE IF EXISTS `site_config`;
CREATE TABLE `site_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_no` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `project_type` int(2) DEFAULT NULL COMMENT '项目类型 ',
  `type` varchar(32) DEFAULT NULL COMMENT '类型 作为key',
  `name` varchar(32) DEFAULT NULL COMMENT '名称 ',
  `value` varchar(512) DEFAULT NULL COMMENT '值 ',
  `value_alias` varchar(16) DEFAULT NULL COMMENT '备用字段',
  `order_level` int(4) DEFAULT NULL COMMENT '排序等级',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户配置表';

-- ----------------------------
-- Table structure for site_news_info
-- ----------------------------
DROP TABLE IF EXISTS `site_news_info`;
CREATE TABLE `site_news_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `news_no` varchar(32) NOT NULL COMMENT '新闻编号',
  `news_type` int(2) DEFAULT '1' COMMENT '新闻类型 1-新闻资讯 2-公告信息 3-招聘信息',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `read_num` int(11) DEFAULT '0' COMMENT '阅读量',
  `project_no` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- ----------------------------
-- Table structure for site_product_info
-- ----------------------------
DROP TABLE IF EXISTS `site_product_info`;
CREATE TABLE `site_product_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_no` varchar(32) NOT NULL COMMENT '产品编号',
  `pic_url` varchar(128) DEFAULT NULL COMMENT '封面图url',
  `pic_url1` varchar(128) DEFAULT NULL COMMENT '封面图url',
  `pic_url2` varchar(128) DEFAULT NULL COMMENT '封面图url',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `content_url` varchar(128) DEFAULT NULL COMMENT '正文内容url',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `user_no` varchar(16) DEFAULT NULL COMMENT '用户编号',
  `project_no` varchar(16) NOT NULL COMMENT '项目编号',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL DEFAULT '-1' COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户产品表';

-- ----------------------------
-- Table structure for site_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `site_visit_log`;
CREATE TABLE `site_visit_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_no` varchar(32) NOT NULL COMMENT '条目（新闻、产品）编号',
  `item_type` int(2) NOT NULL COMMENT '条目类型 0：新闻 1：产品',
  `project_no` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `request_ip` varchar(32) DEFAULT NULL COMMENT '访问ip地址',
  `user_agent` varchar(512) DEFAULT NULL COMMENT '访问浏览器信息',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='访问记录日志表';

-- ----------------------------
-- Table structure for sys_attachment_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_attachment_info`;
CREATE TABLE `sys_attachment_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_no` varchar(16) NOT NULL COMMENT '合同编号',
  `attachment_type` int(2) DEFAULT NULL COMMENT '附件类型，合同图片-1，需求文档-2',
  `attachment_url` varchar(128) DEFAULT NULL COMMENT '附件地址',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同附件信息表';

-- ----------------------------
-- Table structure for sys_contract_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_contract_info`;
CREATE TABLE `sys_contract_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_no` varchar(16) NOT NULL COMMENT '合同编号',
  `project_no` varchar(16) NOT NULL COMMENT '所属项目',
  `project_name` varchar(64) DEFAULT NULL COMMENT '项目的名称',
  `user_no` varchar(16) DEFAULT NULL COMMENT '所属用户',
  `total_money` decimal(16,0) DEFAULT NULL COMMENT '合同标价',
  `discount_money` decimal(16,0) DEFAULT NULL COMMENT '折扣金额，优先级高于 折扣',
  `discount_value` decimal(16,0) DEFAULT NULL COMMENT '折扣',
  `act_money` decimal(16,0) DEFAULT NULL COMMENT '入账金额',
  `valid_days` int(8) DEFAULT NULL COMMENT '合同有效期',
  `start_date` datetime DEFAULT NULL COMMENT '合同开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '合同结束时间',
  `delivery_finished` int(2) DEFAULT '0' COMMENT '是否完成交付,1是，0否',
  `first_commit` int(2) DEFAULT '1' COMMENT '是否是立项合同，立项合同-1，续约合同-2',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户合同信息表';

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(32) DEFAULT NULL COMMENT '类型 projectType：项目类型 ， newsType：新闻类型',
  `name` varchar(32) DEFAULT NULL COMMENT '名称 项目类型：官网、公众号、小程序、APP ',
  `value` varchar(512) DEFAULT NULL COMMENT '值 项目类型：1、2、3、4 ',
  `show_user` int(2) DEFAULT '0' COMMENT '是否展示给用户 0 不展示 ， 1 展示',
  `order_level` int(4) DEFAULT NULL COMMENT '排序等级',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Table structure for sys_op_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_op_log`;
CREATE TABLE `sys_op_log` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `op_code` varchar(32) DEFAULT NULL COMMENT '操作员code',
  `op_name` varchar(32) DEFAULT NULL COMMENT '操作员姓名',
  `log_type` int(2) DEFAULT '1' COMMENT '日志类型 0：登录日志 1：操作日志',
  `method` varchar(64) DEFAULT NULL COMMENT '方法',
  `method_desc` varchar(256) DEFAULT NULL COMMENT '方法',
  `class_method` varchar(256) DEFAULT NULL COMMENT '类方法',
  `request_ip` varchar(32) DEFAULT NULL COMMENT 'ip地址',
  `request_args` text COMMENT '请求入参',
  `response_type` int(1) DEFAULT NULL COMMENT '响应类型 0 正常 1 异常',
  `response_body` text COMMENT '响应原始数据-包含正常异常',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='登录/操作日志表';

-- ----------------------------
-- Table structure for sys_project_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_info`;
CREATE TABLE `sys_project_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_no` varchar(16) NOT NULL COMMENT '项目编号',
  `project_type` int(2) DEFAULT NULL COMMENT '项目类别',
  `project_name` varchar(64) NOT NULL COMMENT '项目的名称',
  `db_name` varchar(64) DEFAULT NULL COMMENT '数据库的名称',
  `user_no` varchar(16) NOT NULL COMMENT '用户编号',
  `special_type` int(1) NOT NULL DEFAULT '0' COMMENT '是否定制，1是，0不是',
  `index_url` varchar(128) DEFAULT NULL COMMENT '项目入口地址',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_no` varchar(16) NOT NULL COMMENT '用户编号',
  `user_name` varchar(32) DEFAULT NULL COMMENT '登录名',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '手机号',
  `wechat_number` varchar(32) DEFAULT NULL COMMENT '微信号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `card_no` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `sex` int(1) DEFAULT '3' COMMENT '性别：1男，2女，3保密',
  `address` varchar(128) DEFAULT NULL COMMENT '联系地址',
  `level` int(1) DEFAULT '1' COMMENT '用户星级:一、二、三',
  `begin_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '账号生效日期',
  `end_time` datetime DEFAULT '2100-01-01 00:00:00' COMMENT '账号失效日期',
  `user_state` int(2) DEFAULT '1' COMMENT '用户状态：1正常， 0冻结',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for ts_op
-- ----------------------------
DROP TABLE IF EXISTS `ts_op`;
CREATE TABLE `ts_op` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `org_id` bigint(20) NOT NULL COMMENT '操作员归属顶级组织',
  `login_code` varchar(32) NOT NULL COMMENT '登录工号',
  `login_password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `op_code` varchar(32) NOT NULL COMMENT '操作员code',
  `op_name` varchar(32) DEFAULT NULL COMMENT '操作员姓名',
  `sex` int(2) DEFAULT '3' COMMENT '性别：1男，2女，3保密',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  `login_code_type` int(2) DEFAULT '0' COMMENT '登陆账户类型:1:超级管理员;2:普通用户',
  `jobfunc_id` bigint(32) DEFAULT NULL COMMENT '职能id',
  `img_path` varchar(256) DEFAULT NULL COMMENT '操作员头像地址',
  `contact_address` varchar(128) DEFAULT NULL COMMENT '联系地址',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `card_type_id` int(2) DEFAULT NULL COMMENT '证件类型 1:身份证,2:护照',
  `card_no` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `try_times` int(2) DEFAULT NULL COMMENT '登录尝试次数',
  `acct_start_date` datetime DEFAULT NULL COMMENT '账号生效时间',
  `acct_end_date` datetime DEFAULT NULL COMMENT '账号失效时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `email_switch` int(2) DEFAULT '0' COMMENT '邮件开关 1:开启,0:关闭',
  `sms_switch` int(2) DEFAULT '0' COMMENT '短信开关 1:开启,0:关闭',
  `data_state` int(2) NOT NULL DEFAULT '1' COMMENT '数据状态：1有效，0无效,2:锁定',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `create_emp_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_emp_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp_id` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modify_emp_name` varchar(64) DEFAULT NULL COMMENT '修改人名称',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_login_code` (`login_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='操作员表(用户)';
