package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaifaEntity;
import java.util.Map;

/**
 * 开发人员 服务类
 */
public interface KaifaService extends IService<KaifaEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}