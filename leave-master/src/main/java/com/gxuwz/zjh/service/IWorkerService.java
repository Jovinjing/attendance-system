package com.gxuwz.zjh.service;

import com.gxuwz.zjh.entity.Worker;
import com.gxuwz.zjh.service.baseServices.AbstractService;
import com.gxuwz.zjh.service.baseServices.SelectPageService;

import java.util.List;

/**
 * 工人表 服务类
 */
public interface IWorkerService extends AbstractService<Worker>, SelectPageService<Worker> {

    List<Worker> findWorkerByClassId(Worker worker);

}
