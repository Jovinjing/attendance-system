package com.gxuwz.zjh.service;

import com.gxuwz.zjh.entity.User;
import com.gxuwz.zjh.service.baseServices.AbstractService;
import com.gxuwz.zjh.service.baseServices.SelectPageService;


/**
 * 管理员表 服务类
 */
public interface IUserService  extends AbstractService<User>, SelectPageService<User> {

}
