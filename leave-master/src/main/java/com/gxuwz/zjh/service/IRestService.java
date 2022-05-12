package com.gxuwz.zjh.service;

import com.gxuwz.zjh.entity.Rest;
import com.gxuwz.zjh.service.baseServices.FindIdAndAddService;
import com.gxuwz.zjh.service.baseServices.SelectPageService;

public interface IRestService extends SelectPageService<Rest>, FindIdAndAddService<Rest> {
    void updateById(Rest rest);
}
