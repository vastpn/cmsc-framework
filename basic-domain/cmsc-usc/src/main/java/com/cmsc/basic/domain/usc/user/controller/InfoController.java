package com.cmsc.basic.domain.usc.user.controller;

import com.cmsc.basic.domain.usc.user.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/user/info")
public class InfoController {

//  @Autowired
  private IInfoService infoService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public List getList() {
    return this.infoService.list();
  }


}
