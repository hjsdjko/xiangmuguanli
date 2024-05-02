package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BuggualiEntity;
import java.util.Map;

/**
 * bug 服务类
 */
public interface BuggualiService extends IService<BuggualiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}