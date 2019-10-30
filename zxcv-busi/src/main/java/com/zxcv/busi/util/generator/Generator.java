package com.zxcv.busi.util.generator;



import com.baomidou.mybatisplus.annotation.DbType;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mysql.jdbc.Driver;

import java.io.File;
import java.util.*;

/**
 * Copyright: Copyright (c) 2017  zteits
 *https://www.cnblogs.com/JzedyBlogs/p/10262278.html
 * @ClassName: Generator.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-05-30 12:29
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-05-30     wangfs              v1.0.0               创建
 */
public class Generator {
    /**项目包名后缀*/
    private static final String packageNameSuffix = ".sys";
    /**mapper文件生成包.*/
    private static final String mapperPackageNameSuffix = "sys";
    /**是否覆盖更新.*/
    private static final Boolean isFileOverride = true;

    /**如果不填会选择项目根路径*/
    private static final String absolutePath = "D:/workspace_private/works/boot-cloud/";//更改1
//  private static final String absolutePath = "D://workspace_private/works/boot-cloud/";//更改1

    public static void main(String[] args) {
        String[] tableNames = new String[]{"test_cust"};
        String[] modules = new String[]{"zxcv-busi"};//项目模块名，需自定义
        for (String module : modules) {
            moduleGenerator(module, tableNames);
        }
    }

    private static void moduleGenerator(String module, String[] tableNames) {
        /**1.全局配置*/
        GlobalConfig globalConfig = getGlobalConfig(module);
        /**2.数据源配置*/
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        /**3.包配置*/
        PackageConfig packageConfig = getPackageConfig(module);
        /**4.策略配置*/
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        /**5.配置模板*/
        TemplateConfig templateConfig = getTemplateConfig(module);

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
            .setDataSource(dataSourceConfig)
            .setPackageInfo(packageConfig)
            .setStrategy(strategyConfig)
            .setTemplate(templateConfig)
            .setCfg(getCfgS(module))
            .execute();
    }

    /**
     * 加载自定义mapper模板
     * @param module
     * @return
     */
    private  static InjectionConfig getCfgS (String module){
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("apiServicePackagePath","com.zxcv.api.commom.service"+packageNameSuffix);
                this.setMap(map);
            }
        };
        if ("zxcv-busi".equals(module)) {
            focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String absolutePathInner ="";
                    if(absolutePath == "" || absolutePath == null ){
                        absolutePathInner =new File(module).getAbsolutePath();
                    }else{
                        absolutePathInner=absolutePath+module;
                    }
                    return absolutePathInner+"/src/main/resources/mybatis/mapper/" + mapperPackageNameSuffix+"/" + tableInfo.getEntityName() + "Mapper.xml";
                }
            });
        }
        return cfg.setFileOutConfigList(focList);
    }

    private static TemplateConfig getTemplateConfig(String module) {
        TemplateConfig templateConfig = new TemplateConfig();
        if ("zxcv-busi".equals(module)) {
            templateConfig.setEntity(new TemplateConfig().getEntity(false))
                .setMapper(new TemplateConfig().getMapper())//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(null)
                .setController(null)
                .setServiceImpl(null);
        } else {
            throw new IllegalArgumentException("参数匹配错误，请检查");
        }
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig(String[] tableNames) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
            .setCapitalMode(true)//驼峰命名
            .setEntityLombokModel(false)
            .setRestControllerStyle(false)
            .setNaming(NamingStrategy.underline_to_camel)
            .setLogicDeleteFieldName("data_state")  //逻辑删除字段
            .setInclude(tableNames)
            //.setExclude(new String[]{"test"}) // 排除生成的表
            // 自定义实体父类
            // .setSuperEntityClass("com.baomidou.demo.TestEntity")
            // 自定义实体，公共字段
            //.setSuperEntityColumns(new String[]{"test_id"})
            // 自定义 mapper 父类
            // .setSuperMapperClass("com.baomidou.demo.TestMapper")
            // 自定义 service 父类
            // .setSuperServiceClass("com.baomidou.demo.TestService")
            // 自定义 service 实现类父类
            // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
            // 自定义 controller 父类  com.parkscloud.comm.base
            .setSuperControllerClass("com.zxcv.portal.common.BaseController")
            // 【实体】是否生成字段常量（默认 false）
            // public static final String ID = "test_id";
            // .setEntityColumnConstant(true)BaseController.java
            // 【实体】是否为构建者模型（默认 false）
            // public User setName(String name) {this.name = name; return this;}
            // .setEntityBuilderModel(true)
            // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
            // .setEntityLombokModel(true)
            // Boolean类型字段是否移除is前缀处理
            .setEntityBooleanColumnRemoveIsPrefix(true)
            //是否生成实体时，生成字段注解
            .setEntityTableFieldAnnotationEnable(true)
            .setRestControllerStyle(true);
        return strategyConfig;
    }

    private static PackageConfig getPackageConfig(String module) {
        PackageConfig packageConfig = new PackageConfig();
        String packageName = "";//不同模块 代码生成具体路径自定义指定
        String busiPackageName = "com.zxcv.busi";
        if("zxcv-busi".equals(module)){
            packageName =busiPackageName;
        }

        packageConfig.setParent(packageName)
            .setEntity("domain"+packageNameSuffix)
            .setMapper("mapper"+packageNameSuffix);
        //.setService("service"+packageNameSuffix)
        //.setServiceImpl("biz"+packageNameSuffix)
        //.setController("web"+packageNameSuffix);
        return packageConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        String dbUrl = "jdbc:mysql://182.92.118.137:3306/zxcv?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
            .setDriverName(Driver.class.getName())
            .setUsername("root")
            .setPassword("123qwe")
            .setUrl(dbUrl);
        return dataSourceConfig;
    }

    private static GlobalConfig getGlobalConfig(String module) {
        GlobalConfig globalConfig = new GlobalConfig();
        String absolutePathInner ="";
        if(absolutePath == "" || absolutePath == null ){
            absolutePathInner =new File(module).getAbsolutePath();
        }else{
            absolutePathInner=absolutePath+module;
        }
        globalConfig.setOpen(false)
            .setOutputDir(absolutePathInner + "/src/main/java")//生成文件的输出目录
            .setFileOverride(isFileOverride)                   // 是否覆盖文件
            .setActiveRecord(true)                   // 开启 activeRecord 模式
            .setEnableCache(false)                   // XML 二级缓存
            .setBaseResultMap(true)                  // XML ResultMap
            .setBaseColumnList(true)                 // XML columList
            .setOpen(false)                          //生成后打开文件夹
            .setDateType(DateType.ONLY_DATE)
            .setAuthor("xiejp")
            .setMapperName("%sMapper")
            .setXmlName("%sMapper")
            .setServiceName("%sService")
            .setServiceImplName("%sServiceImpl");
        return globalConfig;
    }

}
