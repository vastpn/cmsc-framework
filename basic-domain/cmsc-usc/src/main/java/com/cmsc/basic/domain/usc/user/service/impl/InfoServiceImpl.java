package com.cmsc.basic.domain.usc.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmsc.basic.domain.usc.user.entity.Info;
import com.cmsc.basic.domain.usc.user.mapper.InfoMapper;
import com.cmsc.basic.domain.usc.user.service.IInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2019-12-23
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

}
