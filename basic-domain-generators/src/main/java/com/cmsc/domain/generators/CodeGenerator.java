package com.cmsc.domain.generators;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * <b>TODO</b>
 * <b>Describe:TODO</b>
 *
 * <b>Author: admin [2019/12/19 15:21]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/19 15:21        admin            new file.
 * <pre>
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

  /*控制台输入提示信息*/
  public static final String NOTE_MESSAGE="请输入";

  /*控制台错误提示信息*/
  public static final String NOTE_MESSAGE_CONFIRM="请输入正确的";

  /*自动生成代码的项目路径，根项目里的路径*/
  public static final String PROJECT_DOMAIN_NAME="/basic-domain-generators";
  /*项目源码根目录*/
  public static final String PROJECT_SRC_JAVA="/src/main/java";
  /*用户名，注释专用*/
  public static final String PROJECT_NOTE_USER="admin";
  /*模块名称*/
  public static final String PROJECT_MODULE_MESSAGE="模块名";

  /*模块包前缀*/
  public static final String PROJECT_MODULE_PATH ="com.cmsc.basic.domain.usc";
  public static final String PROJECT_MODULE_MAPPER_XML_PATH ="/src/main/resources/mapper/";

  public static final String DB_URL="jdbc:mysql://192.168.1.240:3306/cmsc-test?useUnicode=true&useSSL=false&characterEncoding=utf8";
  public static final String DB_DRIVER="com.mysql.jdbc.Driver";
  public static final String DB_USER="root";
  public static final String DB_PWD="111111";


  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append(NOTE_MESSAGE + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException(NOTE_MESSAGE_CONFIRM + tip + "！");
  }


  public static void main(String[] args) throws IOException {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir")+PROJECT_DOMAIN_NAME;
    System.out.println("路径："+projectPath);
    gc.setOutputDir(projectPath + PROJECT_SRC_JAVA);
    gc.setAuthor(PROJECT_NOTE_USER);
    gc.setOpen(false);
    // gc.setSwagger2(true); 实体属性 Swagger2 注解
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(DB_URL);
    // dsc.setSchemaName("public");
    dsc.setDriverName(DB_DRIVER);
    dsc.setUsername(DB_USER);
    dsc.setPassword(DB_PWD);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName(scanner(PROJECT_MODULE_MESSAGE));
    pc.setParent(PROJECT_MODULE_PATH);
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new

        InjectionConfig() {

          @Override
      public void initMap() {
        // to do nothing
      }


        };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new

                    FileOutConfig(templatePath) {

                      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return projectPath + PROJECT_MODULE_MAPPER_XML_PATH + pc.getModuleName()
            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
      }


                    });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController();

    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//    strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // 公共父类
//    strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
    // 写于父类中的公共字段
    strategy.setSuperEntityColumns("id");
    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix(pc.getModuleName() + "_");
    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();

  }


}
