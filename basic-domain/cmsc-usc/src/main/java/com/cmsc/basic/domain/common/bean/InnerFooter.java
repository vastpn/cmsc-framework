package com.cmsc.basic.domain.common.bean;

import com.cmsc.basic.domain.common.code.CommonApiCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * <b>API接口通讯消息体[非合作方接入]</b>
 * <b>Describe:
 * 包含
 *  -交易码 (交易结果代码)
 *  -交易码中文描述 （交易结果代码对应的中文描述）
 *  -交易状态 (交易成功、失败状态)
 * </b>
 *
 * <b>Author: admin [2019/12/24 11:37]</b>
 * <b>Copyright:</b> Copyright 2008-2026 http://www.jinvovo.com Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author           Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2019/12/24 11:37        tanlin            new file.
 * <pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InnerFooter implements Serializable {

  /**
   * 交易状态码[必填].
   */
  private String code;
  /**
   * 交易状态的描述[必填].
   */
  private String message;
  /**
   * 交易状态[必填].
   */
  private boolean status;

  public InnerFooter(Boolean flag, CommonApiCodeEnum codeEnum) {
    this.status = flag;
    this.code = CommonApiCodeEnum.HTTP_SUCCESS.getCode();
    this.message = CommonApiCodeEnum.HTTP_SUCCESS.getMessage();
  }


}
