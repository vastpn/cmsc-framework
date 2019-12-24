package com.cmsc.basic.domain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <pre>
 * <b>TODO</b>
 * <b>Describe:TODO</b>
 *
 * <b>Author: tanlin [2019/12/23 11:16]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/23 11:16        tanlin            new file.
 * <pre>
 */
@SpringCloudApplication
@MapperScan("com.cmsc.basic.domain.usc.user.mapper")
public class USCApplication {

  public static void main(String[] args) {
    SpringApplication.run(USCApplication.class, args);
  }

}
