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
 * <b>Author: admin [2019/12/24 11:23]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/24 11:23        admin            new file.
 * <pre>
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InnerResult implements Serializable {

  /**通讯请求响应报文头,包含请求响应公共参数.*/
  private InnerHeader innerHeader = new InnerHeader();

  /**通讯请求响应报文头,包含响应公共参数.*/
  private InnerFooter innerFooter = new InnerFooter();

  private Object body;

}
