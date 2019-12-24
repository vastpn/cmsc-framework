package com.cmsc.basic.domain.common.advice;

import com.cmsc.basic.domain.common.bean.InnerFooter;
import com.cmsc.basic.domain.common.bean.InnerResult;
import com.cmsc.basic.domain.common.code.CommonApiCodeEnum;
import com.cmsc.basic.domain.common.exception.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * <b>SpringBoot HTTP 全局异常</b>
 * <b>Describe: 封装常规异常返回消息内容
 * BusinessException：业务异常
 * Exception：其他异常
 * NullPointerException：空指针异常
 * </b>
 *
 * <b>Author: tanlin [2019/12/24 10:57]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/24 10:57        tanlin            new file.
 * <pre>
 */
@Log4j2
@ControllerAdvice
public class CommonAdvice {

  /**
   * <pre>
   * <b>业务异常处理</b>
   * <b>Describe: 封装业务异常消息体</b>
   *
   * <b>Author: tanlin [2019/12/24 11:46]</b>
   *
   * @param request Http请求对象
   * @param exception 异常堆栈
   * @return com.cmsc.basic.domain.common.bean.InnerResult 异常消息封装对象
   * <pre>
   */
  @ExceptionHandler(value = BusinessException.class)
  @ResponseBody
  public InnerResult busiNessExceptionHandler(HttpServletRequest request, BusinessException exception) {
    log.error(CommonApiCodeEnum.HTTP_BUSINESS_ERROR.getCode() + "_" + exception.getMessage(), exception);
    return new InnerResult().setInnerFooter(
        new InnerFooter(Boolean.FALSE, CommonApiCodeEnum.HTTP_BUSINESS_ERROR));
  }


  /**
   * <pre>
   * <b>其他异常处理</b>
   * <b>Describe:封装其他异常消息体</b>
   *
   * <b>Author: tanlin [2019/12/24 13:55]</b>
   *
   * @param request Http请求对象
   * @param exception 异常堆栈
   * @return com.cmsc.basic.domain.common.bean.InnerResult 异常消息封装对象
   * <pre>
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public InnerResult exceptionHandler(HttpServletRequest request, Exception exception) {
    log.error(CommonApiCodeEnum.HTTP_BUSINESS_ERROR.getCode() + "_" + exception.getMessage(), exception);
    return new InnerResult().setInnerFooter(
        new InnerFooter(Boolean.FALSE, CommonApiCodeEnum.UNKNOWN_ERROR));
  }


  /**
   * <pre>
   * <b>空指针异常处理</b>
   * <b>Describe:封装空指针异常消息体</b>
   *
   * <b>Author: tanlin [2019/12/24 13:57]</b>
   *
   * @param request Http请求对象
   * @param exception 异常堆栈
   * @return com.cmsc.basic.domain.common.bean.InnerResult 异常消息封装对象
   * <pre>
   */
  @ExceptionHandler(value = NullPointerException.class)
  @ResponseBody
  public InnerResult nullExceptionHandler(HttpServletRequest request, NullPointerException exception) {
    log.error(CommonApiCodeEnum.HTTP_BUSINESS_ERROR.getCode() + "_" + exception.getMessage(), exception);
    return new InnerResult().setInnerFooter(
        new InnerFooter(Boolean.FALSE, CommonApiCodeEnum.HTTP_VALID_ERROR));
  }


}
