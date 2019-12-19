package com.cmsc.basic.sn.eureka;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 * <pre>
 * <b>Eurek 注册中心</b>
 * <b>Describe: 启动类</b>
 *
 * <b>Author: admin [2019/12/18 21:29]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/18 21:29        admin            new file.
 * <pre>
 */
@Log4j2
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(EurekaApplication.class, args);
    System.out.println("--->"+context.getDisplayName());
    System.out.println("--->"+context.getId());
    log.info("单节点注册中心启动完成");
  }
}
