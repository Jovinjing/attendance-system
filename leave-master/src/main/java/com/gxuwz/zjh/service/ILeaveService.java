package com.gxuwz.zjh.service;

import com.gxuwz.zjh.entity.Leave;
import com.gxuwz.zjh.service.baseServices.AbstractService;
import com.gxuwz.zjh.service.baseServices.SelectPageService;

import java.util.List;

/**
 * 请假表 服务类
 */
public interface ILeaveService  extends AbstractService<Leave>, SelectPageService<Leave> {
    List<Leave> findLeaveByStuNo(Leave leave);

}
