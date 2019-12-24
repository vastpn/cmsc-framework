package com.cmsc.basic.domain.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * <b>TODO</b>
 * <b>Describe:TODO</b>
 *
 * <b>Author: admin [2019/12/24 11:29]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/24 11:29        admin            new file.
 * <pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InnerHeader implements Serializable {

  /**App版本号[选填].*/
  private String appVersion;

  /**设备信息[选填].*/
  private String deviceInfo;

  /**请求渠道[必填].*/
  private String reqChannel;

  /**请求流水号[必填].*/
  private String reqSeqNo;

  /**请求时间戳[必填]*/
  private Long stampNo;

  /**接口版本号[必填].*/
  private String apiVersion;

  /**响应时间[可选].*/
  private String respDateTime;
  /**响应流水号[可选].*/
  private String respSeqNo;

  /**备用字段[可选].*/
  private String rsv1;

  /**备用字段[可选].*/
  private String rsv2;

  /**备用字段[可选].*/
  private String rsv3;
}
