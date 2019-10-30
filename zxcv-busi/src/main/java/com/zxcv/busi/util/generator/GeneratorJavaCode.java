package com.zxcv.busi.util.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mysql.jdbc.Driver;

/**
 * 生成DTO/Req/Service/Controller
 * Copyright: Copyright (c) 2017  zteits
 *
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
public class GeneratorJavaCode {

    /**
     * 项目跟路径.
     */
    
    private static final String projectRootPath = "D:/workspace_private/works/boot-cloud/";//更改1
//    private static final String projectRootPath = "D:/workspace_private/works/boot-cloud/";//更改1
    /**
     * 项目名称.
     */
    private static final String projectApiName = "zxcv-api/";
    private static final String projectbusiName = "zxcv-busi/";
    private static final String projectWebName = "zxcv-web/";

    /**
     * 项目根包名称.
     */
    private static final String projectPlublicPackageName = "src/main/java/";//公共路径
    private static final String projectApiRootPackageName = "com.zxcv.api.commom";
    private static final String projectBusiRootPackageName = "com.zxcv.busi";
    private static final String projectWebRootPackageName = "com.zxcv.portal";
    //private static final String projectWebRootPackageName = "com.zxcv.portal";

    /**
     * 项目包名后缀
     */
    private static final String packageNameSuffix = ".sys";//更改2

    /**
     * zxcv-api 代码.
     */
    private static final String javaClassPreffixName = "TbBillingRule";//更改3

    public static void main(String[] args) {
        String[] tableNames = new String[] {"tb_billing_rule"};////更改4
        String[] modules = new String[] {"DTO", "queryReq", "SaveAndModifyReq", "Service", "ServiceImpl", "Controller",
            "Dao", "DaoImpl"};
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
     *
     * @param module
     * @return
     */
    private static InjectionConfig getCfgS(String module) {
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("dtoPath",
                    projectApiRootPackageName + ".service" + packageNameSuffix + ".dto." + javaClassPreffixName
                        + "DTO");
                map.put("queryPath", projectApiRootPackageName + ".service" + packageNameSuffix + ".param.query.Query"
                    + javaClassPreffixName + "Req");
                map.put("operPath",
                    projectApiRootPackageName + ".service" + packageNameSuffix + ".param.oper.SaveAndModify"
                        + javaClassPreffixName + "Req");
                map.put("apiServicePackagePath", "com.zxcv.api.commom.service" + packageNameSuffix);
                map.put("busiDaoPackagePath", "com.zxcv.busi.dao." + packageNameSuffix);

                this.setMap(map);
            }
        };

        return cfg.setFileOutConfigList(focList);
    }

    private static TemplateConfig getTemplateConfig(String module) {
        TemplateConfig templateConfig = new TemplateConfig();
        if ("DTO".equals(module)) {
            templateConfig.setEntity("/templates/dto.java.vm")
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);//service模块不生成controller代码
        } else if ("queryReq".equals(module)) {
            templateConfig.setEntity("/templates/queryReq.java.vm")
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);//service模块不生成controller代码
        } else if ("SaveAndModifyReq".equals(module)) {
            templateConfig.setEntity("/templates/save.java.vm")
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);//service模块不生成controller代码
        } else if ("Controller".equals(module)) {
            templateConfig.setEntity(null)
                .setMapper(null)
                .setXml(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(new TemplateConfig().getController());
        } else if ("ServiceImpl".equals(module)) {
            templateConfig.setEntity(null)
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(null)
                .setServiceImpl(new TemplateConfig().getServiceImpl())
                .setController(null);//service模块不生成controller代码
        } else if ("Service".equals(module)) {
            templateConfig.setEntity(null)
                .setEntity(null)
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(new TemplateConfig().getService())
                .setServiceImpl(null)
                .setController(null);//service模块不生成controller代码
        } else if ("Dao".equals(module)) {
            templateConfig.setEntity(null)
                .setEntity(null)
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService("/templates/Dao.java.vm")
                .setServiceImpl(null)
                .setController(null);//service模块不生成controller代码
        } else if ("DaoImpl".equals(module)) {
            templateConfig.setEntity(null)
                .setEntity(null)
                .setMapper(null)//mapper模板采用mybatis-plus自己模板
                .setXml(null)
                .setService(null)
                .setServiceImpl("/templates/DaoImpl.java.vm")
                .setController(null);//service模块不生成controller代码
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
            //.setEntityTableFieldAnnotationEnable(true)
            .setRestControllerStyle(true);
        return strategyConfig;
    }

    private static PackageConfig getPackageConfig(String module) {
        PackageConfig packageConfig = new PackageConfig();
        String packageName = "";//不同模块 代码生成具体路径自定义指定
        if ("DTO".equals(module) || "queryReq".equals(module) || "SaveAndModifyReq".equals(module) || "Service".equals(
            module)) {
            packageName = projectApiRootPackageName;
        } else if ("Controller".equals(module)) {
            packageName = projectWebRootPackageName;
        } else if ("ServiceImpl".equals(module) || "Dao".equals(module) || "DaoImpl".equals(module)) {
            packageName = projectBusiRootPackageName;
        }
        packageConfig.setParent(packageName);
        System.out.println("输出项目根路径=" + packageName);
        if ("DTO".equals(module)) {
            packageConfig.setEntity("service" + packageNameSuffix + ".dto");
        } else if ("queryReq".equals(module)) {
            packageConfig.setEntity("service" + packageNameSuffix + ".param.query");
        } else if ("SaveAndModifyReq".equals(module)) {
            packageConfig.setEntity("service" + packageNameSuffix + ".param.oper");
        } else if ("Controller".equals(module)) {
            packageConfig.setController("web" + packageNameSuffix);
            packageConfig.setService("service" + packageNameSuffix);
        } else if ("ServiceImpl".equals(module)) {
            packageConfig.setServiceImpl("biz" + packageNameSuffix);
            packageConfig.setEntity("domain" + packageNameSuffix);
            packageConfig.setMapper("dao" + packageNameSuffix);
        } else if ("Service".equals(module)) {
            packageConfig.setService("service" + packageNameSuffix);
        } else if ("DaoImpl".equals(module)) {
            packageConfig.setServiceImpl("dao" + packageNameSuffix + ".impl");
            packageConfig.setService("dao" + packageNameSuffix);
            packageConfig.setEntity("domain" + packageNameSuffix);
            packageConfig.setMapper("mapper" + packageNameSuffix);
        } else if ("Dao".equals(module)) {
            packageConfig.setService("dao" + packageNameSuffix);
            packageConfig.setEntity("domain" + packageNameSuffix);
        }

        return packageConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        String dbUrl
            = "jdbc:mysql://182.92.118.137:3306/zxcv?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
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
        //输出目录
        String outputDir = ""; //
        if ("DTO".equals(module) || "queryReq".equals(module) || "SaveAndModifyReq".equals(module) || "Service".equals(
            module)) {
            outputDir = projectRootPath + projectApiName + projectPlublicPackageName;
        } else if ("ServiceImpl".equals(module)) {
            outputDir = projectRootPath + projectbusiName + projectPlublicPackageName;
        } else if ("Controller".equals(module)) {
            outputDir = projectRootPath + projectWebName + projectPlublicPackageName;
        } else if ("Dao".equals(module)) {
            outputDir = projectRootPath + projectbusiName + projectPlublicPackageName;
        } else if ("DaoImpl".equals(module)) {
            outputDir = projectRootPath + projectbusiName + projectPlublicPackageName;
        }
        System.out.println("输出路径为===" + outputDir);
        globalConfig.setOutputDir(outputDir)
            .setOpen(false)
            .setFileOverride(true)                   // 是否覆盖文件
            .setActiveRecord(true)                   // 开启 activeRecord 模式
            .setEnableCache(false)                   // XML 二级缓存
            .setBaseResultMap(true)                  // XML ResultMap
            .setBaseColumnList(true)                 // XML columList
            .setOpen(false)                          //生成后打开文件夹
            .setDateType(DateType.ONLY_DATE)
            .setAuthor("xiejp");
        if ("DTO".equals(module)) {
            globalConfig.setEntityName(javaClassPreffixName + "DTO");
        } else if ("queryReq".equals(module)) {
            globalConfig.setEntityName("Query" + javaClassPreffixName + "Req");
        } else if ("SaveAndModifyReq".equals(module)) {
            globalConfig.setEntityName("SaveAndModify" + javaClassPreffixName + "Req");
        } else if ("Controller".equals(module)) {
            globalConfig.setControllerName(javaClassPreffixName + "Controller");
            globalConfig.setServiceName(javaClassPreffixName + "Service");
        } else if ("ServiceImpl".equals(module)) {
            globalConfig.setMapperName(javaClassPreffixName + "Dao");
            globalConfig.setServiceImplName(javaClassPreffixName + "ServiceImpl");
        } else if ("Service".equals(module)) {
            globalConfig.setServiceName(javaClassPreffixName + "Service");
        } else if ("Dao".equals(module)) {
            globalConfig.setServiceName(javaClassPreffixName + "Dao");
        } else if ("DaoImpl".equals(module)) {
            globalConfig.setServiceName(javaClassPreffixName + "Dao");
            globalConfig.setServiceImplName(javaClassPreffixName + "DaoImpl");
        }
        return globalConfig;
    }

}
