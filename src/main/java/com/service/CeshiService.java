package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CeshiEntity;
import java.util.Map;

/**
 * 测试人员 服务类
 */
public interface CeshiService extends IService<CeshiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}