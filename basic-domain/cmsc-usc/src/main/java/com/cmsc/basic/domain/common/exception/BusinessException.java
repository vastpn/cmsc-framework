package com.cmsc.basic.domain.common.exception;

import lombok.Getter;

/**
 * <pre>
 * <b>TODO</b>
 * <b>Describe:TODO</b>
 *
 * <b>Author: tanlin [2019/12/24 13:47]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/24 13:47        tanlin            new file.
 * <pre>
 */
@Getter
public class BusinessException extends Exception {

  /**异常代码, 默认格式: PREFIX + 错误代码, 如：ER_UNKNOWN、ER_10301*/
  protected int code = 500;
  /**引起相关异常的数据对象*/
  protected Object data;

  /**
   * <pre>
   * <b>构造函数</b>
   * <b>Describe:</b>
   *
   * <b>Author: tanlin [2019/12/24 13:53]</b>
   *
   * @param cause 错误堆栈信息
   * @return
   * <pre>
   */
  public BusinessException(BusinessException cause) {

    super(cause);
    if (null != cause) {
      this.code = cause.getCode();
      this.data = cause.getData();
    }
  }

  /**
   * <pre>
   * <b>构造方法</b>
   * <b>Describe:TODO</b>
   *
   * <b>Author: tanlin [2019/12/24 13:54]</b>
   *
   * @param code 错误代码
   * @param message 自定义错误消息
   * @param data 引起相关异常的数据对象
   * @param cause 错误堆栈信息
   * @return
   * <pre>
   */
  public BusinessException(int code, String message, Object data, Throwable cause) {
    super(message, cause);
    this.code = code;
    this.data = data;
  }


  @Override
  public String toString() {
    String message = this.getMessage();
    return this.code + (null != message ? (":" + this.getMessage()) : "") + " ->" + String.valueOf(this.data);
  }


}
