package com.cmsc.basic.domain.common.code;

import lombok.Getter;

/**
 * <pre>
 * <b>开放接口交易码枚举对象</b>
 * <b>Describe:包含常规交易码及对应描述</b>
 *
 * <b>Author: tanlin [2019/12/24 14:00]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/24 14:00        tanlin            new file.
 * <pre>
 */
@Getter
public enum CommonApiCodeEnum {

  HTTP_SUCCESS("0000", "业务交易成功"),

  HTTP_VALID_ERROR("0001", "非法业务参数"),

  HTTP_BUSINESS_ERROR("0002", "业务处理异常"),

  HTTP_PERSIST_ERROR("0003", "业务数据持久化异常"),

  COMMUNICATION_ERROR("0004","远程渠道通讯异常"),

  UNKNOWN_ERROR("1111","未知异常");


  /**
   * 代码编号
   */
  private String code;
  /**
   * 代码编号的中文描述
   */
  private String message;

  CommonApiCodeEnum(String code, String message) {

    this.code = code;
    this.message = message;
  }
}
